package cao.pollparticipant;

import cao.Base;

public class PollParticipant extends Base {
	private String pollParticipantId;
	private String[] userId;
	private String roleEventId;
	private String prefix;
	private int participantTotal;

	@Override
	public String toString() {
		return "PollParticipant [pollParticipantId= " + pollParticipantId + 
				", userId= " + userId + ", roleEventId= " + roleEventId + "]";
	}

	public String getPollParticipantId() {
		return pollParticipantId;
	}

	public void setPollParticipantId(String pollParticipantId) {
		this.pollParticipantId = pollParticipantId;
	}

	public String[] getUserId() {
		return userId;
	}

	public void setUserId(String[] userId) {
		this.userId = userId;
	}

	public String getRoleEventId() {
		return roleEventId;
	}

	public void setRoleEventId(String roleEventId) {
		this.roleEventId = roleEventId;
	}
	
	public int getParticipantTotal() {
		return participantTotal;
	}
	
	public void setParticipantTotal() {
		this.participantTotal = participantTotal;
	}
	
}
