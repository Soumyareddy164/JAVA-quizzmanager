package fr.epita.quizz.model;

public class Quiz {

	private String title;
	
    private Answer answer;
    private MCQ_Answer mcq_answer;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Answer getAnswer() {                    //text answer
		return answer;
	}

	public void setAnswer(Answer answer) {        //text answer
		this.answer = answer;
	}

	public MCQ_Answer getMcq_answer() {             //mcq answer
		return mcq_answer;
	}

	public void setMcq_answer(MCQ_Answer mcq_answer) {         //mcq answer
		this.mcq_answer = mcq_answer;
	}
}
