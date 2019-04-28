package cao.events;

import cao.user.*;
import cao.voteresult.VoteResultService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.boon.json.JsonFactory;
import org.boon.json.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cao.user.*;
import cao.pollbridge.*;
import cao.pollparticipant.*;
import cao.polllocation.*;
import cao.polldatetime.*;
import cao.pollquestion.*;
import cao.pollparticipant.*;
import cao.choice.*;
import cao.voteresult.*;
//import cao.user.UserService;
import common.Common;

@RestController
@RequestMapping("/events")
public class EventsController {
	User user = new User();
	Events events = new Events();
	PollParticipant pollParticipant = new PollParticipant();
	PollBridge pollBridge = new PollBridge();
	PollLocation pollLocation = new PollLocation();
	PollDateTime pollDateTime = new PollDateTime();
	PollQuestion pollQuestion = new PollQuestion();
	Choice choice = new Choice();

	@PostMapping(value = "/showEventList")
	public @ResponseBody String showEventList(@RequestParam String userId, @RequestBody Events event) {
		EventsService esrv = new EventsService();
		List<Events> listEvents = null;
		ObjectMapper mapper = JsonFactory.create();

		String eventName = event.getEventName();
		String eventDesc = event.getEventDescription();
		String listResultJson = null;

		if ("".equals(eventName))
			eventName = null;
		if ("".equals(eventDesc))
			eventDesc = null;

		listEvents = esrv.getEventList(userId, eventName, eventDesc);

		listResultJson = mapper.writeValueAsString(listEvents);
		return listResultJson;
	}

	@PostMapping(value = "/showEventDetail")	
	public @ResponseBody String showEventDetail(@RequestBody Events events ) {
		HashMap<String, String> event = null;
		EventsService esrv = new EventsService();
		List<Map<String, String>> pollIdList=null;
		List<Events> listEvents = null;
		String listResultJson=null;
		ObjectMapper mapper = JsonFactory.create();

		pollIdList=esrv.getPollId(events.getEventId());
		String pollLocationId="";
		String pollDateTimeId="";
		String pollQuestionId=""; 
		if(null!=pollIdList.get(0).get("PollLocationId")) {
			pollLocationId=pollIdList.get(0).get("PollLocationId"); 
		}
		if(null!=pollIdList.get(0).get("PollLocationId")) {
			pollDateTimeId=pollIdList.get(0).get("PollDateTimeId");
		}
		if(null!=pollIdList.get(0).get("PollLocationId")) {
			pollQuestionId=pollIdList.get(0).get("PollQuestionId");
		}
		listEvents = esrv.getEventDetailByEventId(events.getEventId(), pollLocationId, pollDateTimeId, pollQuestionId);
		listResultJson = mapper.writeValueAsString(listEvents);
		
		return listResultJson;
	}

	@RequestMapping(value = "/createNewEvent", method = RequestMethod.POST)
	public String createNewEvent(@RequestBody CreateNewEventParameter parameter) {
		String action = "", eventName = "", eventDescription = "", pollStatus = "", 
				eventCreatedBy = "", isMultiple = "", pollClosedDate = "";

		int participantTotal = 0;
		String[] pollUserId = {}; // pollUserId[0] adalah inisiator, pollUserId[1] dst adalah voters

		int locationTotal = 0;
		String[] locationName = {}, locationContact = {};

		int dateTimeTotal = 0;
		String[] eventDate = {}/* , startTime = {}, endTime = {} */;

		String question = "";

		int choiceTotal = 0;
		
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");

		action = parameter.getAction();
		eventName = parameter.getEventName();
		eventDescription = parameter.getEventDescription();
		pollStatus = parameter.getPollStatus();
		eventCreatedBy = parameter.getUserId()[0];
		
		isMultiple = parameter.getIsMultiple();
		pollClosedDate = parameter.getPollClosedDate();

		// flag
		System.out.println("=====================EVENT");
		System.out.println(eventName);
		System.out.println(eventDescription);
		System.out.println(pollStatus);
		System.out.println(eventCreatedBy);
		// end flag

		participantTotal = parameter.getUserId().length;
		pollUserId = parameter.getUserId();

		// flag
		System.out.println("=====================POLL PARTICIPANT");
		System.out.println(participantTotal);
		for (int i = 0; i < participantTotal; i++) {
			System.out.println(pollUserId[i]);
		}
		// end flag

		locationTotal = parameter.getLocationName().length;
		locationName = parameter.getLocationName();
		locationContact = parameter.getLocationContact();

		// flag
		System.out.println("=====================LOCATION");
		System.out.println(locationTotal);
		for (int i = 0; i < locationTotal; i++) {
			System.out.println(locationName[i]);
			System.out.println(locationContact[i]);
		}
		// end flag

		dateTimeTotal = parameter.getEventDate().length;
		eventDate = parameter.getEventDate();
//		startTime = pdate.getStartTime();
//		endTime = pdate.getEndTime();

		// flag
		System.out.println("=====================POLL DATE TIME");
		System.out.println(dateTimeTotal);
		for (int i = 0; i < dateTimeTotal; i++) {
			System.out.println(eventDate[i]);
		}
		// end flag

		question = parameter.getQuestion();

		// flag
		System.out.println("=====================QUESTION");
		System.out.println(question);
		// end flag

		choiceTotal = parameter.getChoice().length;
		String[] choice = new String[choiceTotal];
		choice = parameter.getChoice();

		// flag
		System.out.println("=====================CHOICE");
		System.out.println(choiceTotal);
		for (int i = 0; i < choiceTotal; i++) {
			System.out.println(choice[i]);
		}
		// end flag

		PollBridgeService pbsrv = new PollBridgeService();
		EventsService esrv = new EventsService();
		PollParticipantService ppsrv = new PollParticipantService();
		PollLocationService plsrv = new PollLocationService();
		PollDateTimeService pdsrv = new PollDateTimeService();
		PollQuestionService pqsrv = new PollQuestionService();
		ChoiceService csrv = new ChoiceService();
		VoteResultService vsrv = new VoteResultService();

		String eventId = "", pollParticipantId = "", pollLocationId = "", pollDateTimeId = "", pollQuestionId = "",
				choiceId = "", pollBridgeId = "";

		// flag
		System.out.println("=====================PREFIX + ID");
		System.out.println("eventId : " + parameter.getEventId());
		System.out.println("pollParticipantId : " + parameter.getPollParticipantId());
		System.out.println("pollLocationId : " + parameter.getPollLocationId());
		System.out.println("pollDateTimeId : " + parameter.getPollDateTimeId());
		System.out.println("polLQuestionId : " + parameter.getPollQuestionId());
		System.out.println("choiceId : " + parameter.getChoiceId());
		System.out.println("pollBridgeId : " + parameter.getPollBridgeId());
		// end flag

		// proses insert
		// insert event. sukses pada case normal
		parameter.setPrefix(Common.PREFIX_EVENT);
		eventId = esrv.getEventId(parameter.getPrefix());
		String pollCondition = "";
		if ("SAVE".equals(action)) {
			pollCondition = "Draft";
		} else if ("PUBLISH".equals(action)) {
			pollCondition = "Published";
		}
		esrv.insertEvent(eventId, eventName, eventDescription, pollStatus, pollCondition, 
				eventCreatedBy, isMultiple, pollClosedDate);
		//end insert event
		
		//insert voteResult
		if (participantTotal > 0) {
			for (int i = 0; i < participantTotal; i++) {
				System.out.println("*****************");
				System.out.println(eventId);
				System.out.println(pollUserId[i]);
				esrv.insertVoteResult(eventId, pollUserId[i]);
				System.out.println("insert vote result telah dilakukan");
			}
		}
		//end insert voteResult
		
		
		// insert pollParticipant. sukses pada case normal
		String pollRoleEventId = "";
		if (participantTotal > 0) {
			parameter.setPrefix(Common.PREFIX_POLL_PARTICIPANT);
			pollParticipantId = ppsrv.getPollParticipantId(parameter.getPrefix());
			for (int i = 0; i < participantTotal; i++) {
				if (i == 0) {
					pollRoleEventId = "INI";
				} else
					pollRoleEventId = "VTR";
				ppsrv.insertPollParticipant(pollParticipantId, pollUserId[i], pollRoleEventId);
			}
		}

		// insert pollLocation. sukses pada case normal
		if (locationTotal > 0) {
			parameter.setPrefix(Common.PREFIX_POLL_LOCATION);
			for(int i=0; i<locationTotal; i++) {
				if(i==0 && !"".equals(locationName[i])) {
					pollLocationId = plsrv.getPollLocationId(parameter.getPrefix());
				}
				if(!"".equals(locationName[i])) {
					plsrv.insertPollLocation(pollLocationId, locationName[i], locationContact[i]);
				}
			}
		}
//		
		// insert pollDateTime. note: belum ada time
		if (dateTimeTotal > 0) {
			parameter.setPrefix(Common.PREFIX_POLL_DATE_TIME);
			for(int i=0; i<dateTimeTotal; i++) {
				if(i==0 && !"".equals(eventDate[i])) {
					pollDateTimeId = pdsrv.getPolldateTimeId(parameter.getPrefix());
				}
				if(!"".equals(eventDate[i])) {
					pdsrv.insertPollDateTime(pollDateTimeId, eventDate[i]
	//						, startTime[i], endTime[i]
							);
				}
			}
		}

		// insert pollQuestion. sukses pada case normal
		if (!"".equals(question)) {
			parameter.setPrefix(Common.PREFIX_POLL_QUESTION);
			pollQuestionId = pqsrv.getPollQuestionId(parameter.getPrefix());
			pqsrv.insertPollQuestion(pollQuestionId, question);
			// insert choice
			parameter.setPrefix(Common.PREFIX_CHOICE);
			for(int i=0; i<choiceTotal; i++) {
				if(i==0 && !"".equals(choice[i])) {
					choiceId = csrv.getChoiceId(parameter.getPrefix());
				}
				if(!"".equals(choice[i])) {
					csrv.insertPollChoice(pollQuestionId, question, choiceId, choice[i]);
				}
			}
		}

		// insert pollBridge
		parameter.setPrefix(Common.PREFIX_POLL_BRIDGE);
		pollBridgeId = pbsrv.getPollBridgeId(parameter.getPrefix());

		pbsrv.insertPollBridge(pollBridgeId, eventId, pollParticipantId, pollLocationId, pollDateTimeId,
				pollQuestionId);
		// end proses insert
		
		return "Ok";
	}
	
	@PostMapping(value = "/deleteEvent")
	public @ResponseBody String deleteEvent(@RequestBody Events event) {
		EventsService esrv = new EventsService();
		PollBridge pbridge = new PollBridge();
		ObjectMapper mapper = JsonFactory.create();

		String eventId = event.getEventId();
		String listResultJson = null;

		pbridge = esrv.getEventBridge(eventId);
		
		//DELETE
		esrv.deleteEvent(pbridge.getEventId());
		esrv.deleteVoteResult(pbridge.getEventId());
		esrv.deletePollParticipant(pbridge.getPollParticipationId());
		
		if(pbridge.getPollLocationId() != "") {
			esrv.deletePollLocation(pbridge.getPollLocationId());			
		}
		
		if(pbridge.getPollDateTimeId() != "") {
			esrv.deletePollDateTime(pbridge.getPollDateTimeId());			
		}
		
		if(pbridge.getPollQuestionId() != "") {
			esrv.deletePollQuestion(pbridge.getPollQuestionId());
			esrv.deletePollChoice(pbridge.getPollQuestionId());
		}
		
		esrv.deletePollBridge(pbridge.getPollBridgeId());
		
		listResultJson = mapper.writeValueAsString(pbridge);
		return listResultJson;
	}

}
