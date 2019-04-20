package cao.polldatetime;

import cao.Base;

public class PollDateTime extends Base {
	private String pollDateTimeId;
	private String[] startDate;
	private String[] endDate;
	private String[] startTime;
	private String[] endTime;
	private int dateTimeTotal;
	
//	public PollDateTime(String pollDateTimeId, String startDate, String endDate, String startTime, String endTime) {
//		this.pollDateTimeId = pollDateTimeId;
//		this.startDate = startDate;
//		this.endDate = endDate;
//		this.startTime = startTime;
//		this.endTime = endTime;
//	}

	public String getPollDateTimeId() {
		return pollDateTimeId;
	}

	public void setPollDateTimeId(String pollDateTimeId) {
		this.pollDateTimeId = pollDateTimeId;
	}

	public String[] getStartDate() {
		return startDate;
	}

	public void setStartDate(String[] startDate) {
		this.startDate = startDate;
	}

	public String[] getEndDate() {
		return endDate;
	}

	public void setEndDate(String[] endDate) {
		this.endDate = endDate;
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
	
}
