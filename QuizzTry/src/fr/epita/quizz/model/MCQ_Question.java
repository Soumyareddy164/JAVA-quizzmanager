package fr.epita.quizz.model;

public class MCQ_Question extends Questions {

	public MCQ_Question(int ques_id, String topics, String question, int difficulty, boolean ismcq) {
		super(ques_id, topics, question, difficulty, ismcq);
		// TODO Auto-generated constructor stub
	}

	private MCQ_Choice mcq_choice;

	public MCQ_Choice getMcq_choice() {
		return mcq_choice;
	}

	public void setMcq_choice(MCQ_Choice mcq_choice) {
		this.mcq_choice = mcq_choice;
	}
}
