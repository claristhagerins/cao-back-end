package cao.voteresult;

public class VoteResult {
	private String voteResultId;
	private String pollBridgeId;
	private String pollParticipantId;
	private String userId;
	private String eventId;
	private String pollLocationId;
	private String pollDateTimeId;
	private String pollQuestionId;
	
	public VoteResult(String voteResultId, String pollBridgeId, String pollParticipantId, String userId, String eventId,
			String pollLocationId, String pollDateTimeId, String pollQuestionId) {
		this.voteResultId = voteResultId;
		this.pollBridgeId = pollBridgeId;
		this.pollParticipantId = pollParticipantId;
		this.userId = userId;
		this.eventId = eventId;
		this.pollLocationId = pollLocationId;
		this.pollDateTimeId = pollDateTimeId;
		this.pollQuestionId = pollQuestionId;
	}

	public String getVoteResultId() {
		return voteResultId;
	}

	public void setVoteResultId(String voteResultId) {
		this.voteResultId = voteResultId;
	}

	public String getPollBridgeId() {
		return pollBridgeId;
	}

	public void setPollBridgeId(String pollBridgeId) {
		this.pollBridgeId = pollBridgeId;
	}

	public String getPollParticipantId() {
		return pollParticipantId;
	}

	public void setPollParticipantId(String pollParticipantId) {
		this.pollParticipantId = pollParticipantId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
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
