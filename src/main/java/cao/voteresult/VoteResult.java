package cao.voteresult;

public class VoteResult {
	private String eventId;
	private String userId;
	private String chosenDateTime;
	private String chosenLocationName;
	private String chosenChoiceName;
	private String numberOfVotersDesc;
	
	//flag red
	private String choiceOfLocation;
	private String choiceOfAnswer;
	private String choiceOfDateTime;
	private String totalVoters;
	//end flag red
	
	private String[] chosenDateTimeArray;
	private String[] chosenLocationNameArray;
	private String[] chosenChoiceNameArray;
	
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getChosenDateTime() {
		return chosenDateTime;
	}
	public void setChosenDateTime(String chosenDateTime) {
		this.chosenDateTime = chosenDateTime;
	}
	public String getChosenLocationName() {
		return chosenLocationName;
	}
	public void setChosenLocationName(String chosenLocationName) {
		this.chosenLocationName = chosenLocationName;
	}
	public String getChosenChoiceName() {
		return chosenChoiceName;
	}
	public void setChosenChoiceName(String chosenChoiceName) {
		this.chosenChoiceName = chosenChoiceName;
	}
	public String getNumberOfVotersDesc() {
		return numberOfVotersDesc;
	}
	public void setNumberOfVotersDesc(String numberOfVotersDesc) {
		this.numberOfVotersDesc = numberOfVotersDesc;
	}
	public String getChoiceOfLocation() {
		return choiceOfLocation;
	}
	public void setChoiceOfLocation(String choiceOfLocation) {
		this.choiceOfLocation = choiceOfLocation;
	}
	public String getChoiceOfAnswer() {
		return choiceOfAnswer;
	}
	public void setChoiceOfAnswer(String choiceOfAnswer) {
		this.choiceOfAnswer = choiceOfAnswer;
	}
	public String getChoiceOfDateTime() {
		return choiceOfDateTime;
	}
	public void setChoiceOfDateTime(String choiceOfDateTime) {
		this.choiceOfDateTime = choiceOfDateTime;
	}
	public String getTotalVoters() {
		return totalVoters;
	}
	public void setTotalVoters(String totalVoters) {
		this.totalVoters = totalVoters;
	}
	public String[] getChosenDateTimeArray() {
		return chosenDateTimeArray;
	}
	public void setChosenDateTimeArray(String[] chosenDateTimeArray) {
		this.chosenDateTimeArray = chosenDateTimeArray;
	}
	public String[] getChosenLocationNameArray() {
		return chosenLocationNameArray;
	}
	public void setChosenLocationNameArray(String[] chosenLocationNameArray) {
		this.chosenLocationNameArray = chosenLocationNameArray;
	}
	public String[] getChosenChoiceNameArray() {
		return chosenChoiceNameArray;
	}
	public void setChosenChoiceNameArray(String[] chosenChoiceNameArray) {
		this.chosenChoiceNameArray = chosenChoiceNameArray;
	}
}
