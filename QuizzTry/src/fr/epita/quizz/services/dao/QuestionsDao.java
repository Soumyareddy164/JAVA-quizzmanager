package fr.epita.quizz.services.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.epita.quizz.model.Answer;
import fr.epita.quizz.model.Result;
import fr.epita.quizz.model.Student;
import fr.epita.quizz.service.Configuration;
import fr.epita.quizz.model.MCQ_Choice;
import fr.epita.quizz.model.Questions;

public class QuestionsDao {

	public static final String getQuestionsQuery = "SELECT * FROM QUESTIONS";
	public static final String answersQuery = "SELECT ACTUAL_ANSWER, USER_ANSWER FROM ANSWERS";
	public static final String insertUserAnswer = "UPDATE ANSWERS SET USER_ANSWER = ? WHERE QUESTION_ID = ?";
	public static final String getMCQChoices = "SELECT * FROM MCQ_CHOICE WHERE QUESTION_ID = ?";
	public static final String insertStudentNameandScore = "INSERT INTO STUDENT (NAME,SCORE) VALUES (?, ?)";

	 
	public List<Questions> getQuestions() {
		List<Questions> resultList = new ArrayList<Questions>();

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(getQuestionsQuery);) {

			ResultSet results = preparedStatement.executeQuery();
			while (results.next()) {
				int id = results.getInt("ID");
				int difficulty = results.getInt("DIFFICULTY");
				boolean isMcq = results.getBoolean("ISMCQ");
				String topics = results.getString("TOPICS");
				String quest = results.getString("QUESTION_TEXT");

				Questions currentQuestion = new Questions(id, topics, quest, difficulty, isMcq);
				resultList.add(currentQuestion);
			}
			results.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultList;

	}

	//Get all the actual and user entered answers
	
	public List<Result> getAnswers() {
		List<Result> resultsList = new ArrayList<>();

		try (Connection connection = getConnection()) {
			PreparedStatement statement = connection.prepareStatement(answersQuery);

			ResultSet results = statement.executeQuery();
			while (results.next()) {
				String actual_ans = results.getString("ACTUAL_ANSWER");
				String user_ans = results.getString("USER_ANSWER");

				Result result = new Result(actual_ans, user_ans);
				resultsList.add(result);
			}
			results.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultsList;
	}

	//Adds the user entered answer into the database
	 
	public void addAnswer(Answer answer) {

		try (Connection connection = getConnection()) {
			PreparedStatement statement = connection.prepareStatement(insertUserAnswer);
			statement.setString(1, answer.getAnswer());
			statement.setInt(2, answer.getQues_id());
			statement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
 
	//adding student name and score to the database in table student
	
	public void addStudent(Student s1) {

		try (Connection connection = getConnection()) {
			PreparedStatement statement = connection.prepareStatement(insertStudentNameandScore);
			statement.setString(1, s1.getName());
			statement.setInt(2, s1.getScore());
			statement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public List<MCQ_Choice> getMCQs(Questions question) {       //get the mcq_choices for a question
		List<MCQ_Choice> mcqChoicesList = new ArrayList<>();

		try (Connection connection = getConnection()) {
			PreparedStatement statement = connection.prepareStatement(getMCQChoices);

			statement.setInt(1, question.getQues_id());
			ResultSet results = statement.executeQuery();

			while (results.next()) {
				int id = results.getInt("MCQ_ID");
				String choice = results.getString("CHOICE");

				MCQ_Choice mcqChoice = new MCQ_Choice(id, choice);
				mcqChoicesList.add(mcqChoice);
			}
			results.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return mcqChoicesList;

	}
	
	private Connection getConnection() throws SQLException {
		Configuration conf = Configuration.getInstance();
		String jdbcUrl = conf.getPropertyValue("jdbc.url");
		String user = conf.getPropertyValue("jdbc.user");
		String password = conf.getPropertyValue("jdbc.password");
		Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
		return connection;
	}
}
