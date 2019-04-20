package cao.pollbridge;

import cao.Base;

public class PollBridge extends Base {
	private String pollBridgeId;
	private String eventId;
	private String pollParticipationId;
	private String pollLocationId;
	private String pollDateTimeId;
	private String pollQuestionId;
	
//	public PollBridge(String pollBridgeId, String voteResultId, String eventId, String pollParticipationId,
//			String pollLocationId, String pollDateTimeId, String pollQuestionId) {
//		this.pollBridgeId = pollBridgeId;
//		this.voteResultId = voteResultId;
//		this.eventId = eventId;
//		this.pollParticipationId = pollParticipationId;
//		this.pollLocationId = pollLocationId;
//		this.pollDateTimeId = pollDateTimeId;
//		this.pollQuestionId = pollQuestionId;
//	}

	public String getPollBridgeId() {
		return pollBridgeId;
	}

	public void setPollBridgeId(String pollBridgeId) {
		this.pollBridgeId = pollBridgeId;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getPollParticipationId() {
		return pollParticipationId;
	}

	public void setPollParticipationId(String pollParticipationId) {
		this.pollParticipationId = pollParticipationId;
	}

	public String getPollLocationId() {
		return pollLocationId;
	}

	public void setPollLocationId(String pollLocationId) {
		this.pollLocationId = pollLocationId;
	}

	public String getPollDateTimeId() {
		return pollDateTimeId;
	}

	public void setPollDateTimeId(String pollDateTimeId) {
		this.pollDateTimeId = pollDateTimeId;
	}

	public String getPollQuestionId() {
		return pollQuestionId;
	}

	public void setPollQuestionId(String pollQuestionId) {
		this.pollQuestionId = pollQuestionId;
	}
	
}
