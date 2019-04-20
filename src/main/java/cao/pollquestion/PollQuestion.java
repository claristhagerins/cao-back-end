package cao.pollquestion;

import cao.Base;

public class PollQuestion extends Base {
	private String pollQuestionId;
	private String question;
	
//	public PollQuestion(String pollQuestionId, String question) {
//		this.pollQuestionId = pollQuestionId;
//		this.question = question;
//	}

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
	
}
