package cao.events;

import java.util.HashMap;
import java.util.List;

import cao.pollbridge.PollBridge;
import cao.user.User;


public interface EventsMapper {
	public String getEventId(String prefix);
	public void insertEvent(String eventId, String eventName, String eventDescription, String pollStatus,
			String pollCondition, String eventCreatedBy);
	public List<Events> getEventListByUserId(String userId);
	public List<Events> getEventList(String userId, String eventName, String eventDescription);
	public List<Events> getEventListByNameAndDesc(String eventName, String eventDescription);
	public List<Events> getEventListByName(String eventName);
	public List<Events> getEventListByDescription(String eventDescription);
	public List<Events> getEventDetailByEventId(String eventId);
	public PollBridge getEventBridge(String eventId);
	public void deleteEvent(String eventId);
	public void deletePollParticipant(String pollParticipantId);
	public void deletePollLocation(String pollLocationId);
	public void deletePollDateTime(String pollDateTimeId);
	public void deletePollQuestion(String pollQuestionId);
	public void deletePollChoice(String pollChoiceId);	
	public void deletePollBridge(String pollBridgeId);	
}
