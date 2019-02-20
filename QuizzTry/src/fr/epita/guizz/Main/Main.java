package fr.epita.guizz.Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import fr.epita.quizz.model.Answer;
import fr.epita.quizz.model.MCQ_Choice;
import fr.epita.quizz.model.Questions;
import fr.epita.quizz.model.Result;
import fr.epita.quizz.model.Student;
import fr.epita.quizz.services.dao.QuestionsDao;
 
public class Main {
	private QuestionsDao dao;

	public Main() {
		dao = new QuestionsDao();
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.displayQuestions();
	}
	 
	@SuppressWarnings("resource")
	
	private void displayQuestions() {
		List<Questions> questions = dao.getQuestions();  //should display all the questions from the database Table QUESTIONS
		Collections.shuffle(questions, new Random());
		
		System.out.println("Enter your Name and press enter to start your QUIZZ ");
		Scanner scanner1 = new Scanner(System.in);
		String name1 = scanner1.nextLine();
		//Student s1 =new Student();
		//s1.setName(name1);
		//dao.addStudent(s1);
		
		
		System.out.println("INSTRUCTIONS\n" 
		+"1.Type the option charecter(a or b or c) for MCQ-QUESTIONS\n"
		+"2.Press enter to get the next question\n" 
		+"3. You cannot move back to the previous question\n");
		for (Questions quest : questions) {

			System.out.println(quest.getQuestion());
			checkAndFetchMCQs(quest);
			Scanner scanner = new Scanner(System.in);
			String ans = scanner.nextLine();
			Answer answer = new Answer(quest.getQues_id(), ans);
			dao.addAnswer(answer);
		}

		compareAnswers(name1);
	}
	 
	private void compareAnswers(String name1) {                   //COMPARING ACTUAL_ANSWER WITH THE USER_ENTERED ANSWER 
		List<Result> results = dao.getAnswers();
		int score = 0;
        String name=name1;
		for (Result result : results) {

			if (result.getUser_answer() != null
					&& result.getActual_answer().trim().equalsIgnoreCase(result.getUser_answer().trim())) {
				score += 2;
			}
		}

		System.out.println("Hi " +name +" Your Score is: " + score +" out of 20");
		
		Student s1 =new Student();
		s1.setScore(score);               //storing user name and score in the STUDENT table in the Database
		s1.setName(name);
		dao.addStudent(s1);
	
		
	}
	 
	private void checkAndFetchMCQs(Questions quest) {    //if the question is an MCQ question display the mcq's associated with the question 
		List<MCQ_Choice> mcqChoices = new ArrayList<>();

		if (quest.isIsmcq()) {
			mcqChoices = dao.getMCQs(quest);

			for (MCQ_Choice mcqChoice : mcqChoices) {
				System.out.println(mcqChoice.getChoice());
			}
		}
	}

}
