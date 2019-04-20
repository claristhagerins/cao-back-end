package cao.msroleevent;

public class MsRoleEvent {
	private String roleEventId;
	private String roleEventName;
	
	public MsRoleEvent(String roleEventId, String roleEventName) {
		this.roleEventId = roleEventId;
		this.roleEventName = roleEventName;
	}

	public String getRoleEventId() {
		return roleEventId;
	}

	public void setRoleEventId(String roleEventId) {
		this.roleEventId = roleEventId;
	}

	public String getRoleEventName() {
		return roleEventName;
	}

	public void setRoleEventName(String roleEventName) {
		this.roleEventName = roleEventName;
	}
	
}
