package cao.choice;

import cao.Base;

public class Choice extends Base {
	private String choiceId;
	private String[] choice;
	private String pollQuestionId;
	private String question;
	int choiceTotal;
	
//	public Choice(String choiceId, String choice, String pollQuestionId, String question) {
//		this.choiceId = choiceId;
//		this.choice = choice;
//		this.pollQuestionId = pollQuestionId;
//		this.question = question;
//	}
	
	public String getChoiceId() {
		return choiceId;
	}
	public void setChoiceId(String choiceId) {
		this.choiceId = choiceId;
	}
	public String[] getChoice() {
		return choice;
	}
	public void setChoice(String[] choice) {
		this.choice = choice;
	}
	public String getPollQuestionId() {
		return pollQuestionId;
	}
	public void setPollQuestionId(String pollQuestionId) {
		this.pollQuestionId = pollQuestionId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public int getChoiceTotal() {
		return choiceTotal;
	}
	public void setChoiceTotal(int choiceTotal) {
		this.choiceTotal = choiceTotal;
	}
	@Override
	public String toString() {
		return "Choice [choiceId=" + choiceId + ", choice=" + choice + ", pollQuestionId=" + pollQuestionId
				+ ", question=" + question + "]";
	}
	
}
