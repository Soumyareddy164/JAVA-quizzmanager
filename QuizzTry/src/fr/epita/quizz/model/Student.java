package fr.epita.quizz.model;

public class Student {
	private int id;
	private String name;
	private int score;

	private Answer answer;                   // text answer
	private MCQ_Answer mcq_answer;           // mcq answer

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Answer getAnswer() { // text answer
		return answer;
	}

	public void setAnswer(Answer answer) { // text answer
		this.answer = answer;
	}

	public MCQ_Answer getMcq_answer() { // mcq answer
		return mcq_answer;
	}

	public void setMcq_answer(MCQ_Answer mcq_answer) { // mcq answer
		this.mcq_answer = mcq_answer;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
