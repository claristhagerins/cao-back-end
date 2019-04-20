package cao.polllocation;

import cao.Base;

public class PollLocation extends Base {
	private String pollLocationId;
	private String[] locationName;
	private String[] locationContact;
	private int locationTotal;
	
//	public PollLocation(String locationId, String locationName, String locationDescription, String contact) {
//		this.locationId = locationId;
//		this.locationName = locationName;
//		this.locationDescription = locationDescription;
//		this.contact = contact;
//	}

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
	
}
