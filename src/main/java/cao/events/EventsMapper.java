package cao.events;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cao.pollbridge.PollBridge;
import cao.user.User;


public interface EventsMapper {
	public String getEventId(String prefix);
	public void insertVoteResult(String eventId, String pollUserId);
	public void insertEvent(String eventId, String eventName, String eventDescription, 
			String pollStatus,String pollCondition, String eventCreatedBy, String isMultiple, 
			String pollClosedDate);
	public List<Map<String,String>> getPollId(String eventId);
	public List<Events> getEventList(String userId, String eventName, String eventDescription);
	public List<Events> getEventDetailByEventId(String eventId, String pollLocationId, String pollDateTimeId, String pollQuestionId);
	public PollBridge getEventBridge(String eventId);
	public void deleteEvent(String eventId);
	public void deleteVoteResult(String eventId);
	public void deletePollParticipant(String pollParticipantId);
	public void deletePollLocation(String pollLocationId);
	public void deletePollDateTime(String pollDateTimeId);
	public void deletePollQuestion(String pollQuestionId);
	public void deletePollChoice(String pollChoiceId);	
	public void deletePollBridge(String pollBridgeId);	
}
