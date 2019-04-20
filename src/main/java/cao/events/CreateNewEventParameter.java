package cao.events;

import cao.Base;

public class CreateNewEventParameter extends Base {

	private String action;
	private String eventId;
	private String eventName;
	private String eventDescription;
	private String pollStatus;
	private String dateCreated;
	private String createdBy;

	private String pollParticipantId;
	private String[] userId;
	private String roleEventId;
	private String prefix;
	private int participantTotal;

	private String pollLocationId;
	private String[] locationName;
	private String[] locationContact;
	private int locationTotal;

	private String pollDateTimeId;
	private String[] eventDate;
	private String[] startTime;
	private String[] endTime;
	private int dateTimeTotal;

	private String pollQuestionId;
	private String question;

	private String choiceId;
	private String[] choice;
	int choiceTotal;

	private String pollBridgeId;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public String getPollStatus() {
		return pollStatus;
	}

	public void setPollStatus(String pollStatus) {
		this.pollStatus = pollStatus;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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

	public void setParticipantTotal(int participantTotal) {
		this.participantTotal = participantTotal;
	}

	public String getPollLocationId() {
		return pollLocationId;
	}

	public void setPollLocationId(String pollLocationId) {
		this.pollLocationId = pollLocationId;
	}

	public String[] getLocationName() {
		return locationName;
	}

	public void setLocationName(String[] locationName) {
		this.locationName = locationName;
	}

	public String[] getLocationContact() {
		return locationContact;
	}

	public void setLocationContact(String[] locationContact) {
		this.locationContact = locationContact;
	}

	public int getLocationTotal() {
		return locationTotal;
	}

	public void setLocationTotal(int locationTotal) {
		this.locationTotal = locationTotal;
	}

	public String getPollDateTimeId() {
		return pollDateTimeId;
	}

	public void setPollDateTimeId(String pollDateTimeId) {
		this.pollDateTimeId = pollDateTimeId;
	}

	public String[] getEventDate() {
		return eventDate;
	}

	public void setEventDate(String[] eventDate) {
		this.eventDate = eventDate;
	}

	public String[] getStartTime() {
		return startTime;
	}

	public void setStartTime(String[] startTime) {
		this.startTime = startTime;
	}

	public String[] getEndTime() {
		return endTime;
	}

	public void setEndTime(String[] endTime) {
		this.endTime = endTime;
	}

	public int getDateTimeTotal() {
		return dateTimeTotal;
	}

	public void setDateTimeTotal(int dateTimeTotal) {
		this.dateTimeTotal = dateTimeTotal;
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

	public int getChoiceTotal() {
		return choiceTotal;
	}

	public void setChoiceTotal(int choiceTotal) {
		this.choiceTotal = choiceTotal;
	}

	public String getPollBridgeId() {
		return pollBridgeId;
	}

	public void setPollBridgeId(String pollBridgeId) {
		this.pollBridgeId = pollBridgeId;
	}

}
