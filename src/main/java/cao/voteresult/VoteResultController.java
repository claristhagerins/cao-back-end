package cao.voteresult;

import java.util.List;
import java.util.Map;

import org.boon.json.JsonFactory;
import org.boon.json.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cao.events.Events;
import cao.events.EventsService;


@RestController
@RequestMapping("/voteresult")
public class VoteResultController {
	
	
	@PostMapping(value = "/giveVote")	
	public @ResponseBody String giveVote (@RequestBody VoteResult voteResult) {
		EventsService esrv = new EventsService();
		VoteResultService vsrv = new VoteResultService();
		String eventId, userId;
		String[] chosenDateTimeArray = {}, chosenLocationNameArray = {}, chosenChoiceNameArray = {};
		String chosenDateTime = "";
		String chosenLocationName = "";
		String chosenChoiceName = "";
		
		eventId = voteResult.getEventId();
		userId = voteResult.getUserId();
		chosenDateTimeArray = voteResult.getChosenDateTimeArray();
		chosenLocationNameArray = voteResult.getChosenLocationNameArray();
		chosenChoiceNameArray = voteResult.getChosenChoiceNameArray();
		
		String inputChosenDateTime = "", inputChosenLocationName = "", inputChosenChoiceName = "";
		
		System.out.println("hehe");
		
//		{"chosenDateTime":["2019-07-03", "2019-07-04"]}
		inputChosenDateTime = "{\"chosenDateTime\":[pilihan]}";
		for(int i=0; i<chosenDateTimeArray.length; i++) {
			chosenDateTime +="\""+chosenDateTimeArray[i]+"\"";
			if(i!=chosenDateTimeArray.length-1) {
				chosenDateTime += ", ";
			}
		}
		inputChosenDateTime = inputChosenDateTime.replace("pilihan", chosenDateTime);
		System.out.println("INI DIA: "+inputChosenDateTime);
		

		inputChosenLocationName = "{\"chosenLocationName\":[pilihan]}";
		for(int i=0; i<chosenLocationNameArray.length; i++) {
			chosenLocationName +="\""+chosenLocationNameArray[i]+"\"";
			if(i!=chosenLocationNameArray.length-1) {
				chosenLocationName += ", ";
			}
		}
		inputChosenLocationName = inputChosenLocationName.replace("pilihan", chosenLocationName);
		System.out.println("INI DIA 2: "+inputChosenLocationName);
		

		inputChosenChoiceName = "{\"chosenChoiceName\":[pilihan]}";
		for(int i=0; i<chosenChoiceNameArray.length; i++) {
			chosenChoiceName +="\""+chosenChoiceNameArray[i]+"\"";
			if(i!=chosenChoiceNameArray.length-1) {
				chosenChoiceName += ", ";
			}
		}
		inputChosenChoiceName = inputChosenChoiceName.replace("pilihan", chosenChoiceName);
		System.out.println("INI DIA 3: "+inputChosenChoiceName);
		
		
		System.out.println("end hehe");
		
		vsrv.updateVoteResult(eventId, userId, inputChosenDateTime, 
				inputChosenLocationName, inputChosenChoiceName);
		
		return "SUBMIT VOTE SUCCESS";
	}
	
	@PostMapping(value = "/showVoteResult")	
	public @ResponseBody String showVoteResult (//RequestParam String userId, 
			@RequestBody Events event
			//@RequestBody VoteResult voteResult
			) {
		System.out.println("masuk lho");
		VoteResultService vsrv = new VoteResultService();
		String eventId = event.getEventId();
		
		VoteResult obj = new VoteResult();

		ObjectMapper mapper = JsonFactory.create();

		
		String listVoteResultJson=null;
		List<Map<String, String>> listOfChoices=null;
		String listOfChoicesJson = null;
		listOfChoices = vsrv.getChoices(eventId);
		listOfChoicesJson = mapper.writeValueAsString(listOfChoices);
		String choiceOfLocation[], choiceOfAnswer[], choiceOfDateTime[] = {};
		String choiceOfLocationList = listOfChoices.get(0).get("ChoiceOfLocation");
		String choiceOfAnswerList = listOfChoices.get(0).get("ChoiceOfAnswer");
		String choiceOfDateTimeList = listOfChoices.get(0).get("ChoiceOfDateTime");
		String choiceOfLocationContent = "";
		String choiceOfAnswerContent = "";
		String choiceOfDateTimeContent = "";
		
		if(!"".equals(choiceOfLocationList) && 
				choiceOfLocationList!=null) {
			choiceOfLocation = choiceOfLocationList.split("~");
			int[] numberOfVoters = new int[choiceOfLocation.length];
			System.out.println("choiceOfLocation length: "+choiceOfLocation.length);
			for(int i = 0; i<choiceOfLocation.length; i++) {
				numberOfVoters[i]=vsrv.getNumberOfVoters("chosenLocationName", 
						(String)choiceOfLocation[i]);
				choiceOfLocationContent=choiceOfLocationContent+choiceOfLocation[i]+"~"+numberOfVoters[i];
				if(i<choiceOfLocation.length-1) {
					choiceOfLocationContent = choiceOfLocationContent + ";";
				}
			}
		}
		
		if(!"".equals(choiceOfAnswerList) && 
				choiceOfAnswerList!=null) {
			choiceOfAnswer = choiceOfAnswerList.split("~");
			int[] numberOfVoters = new int[choiceOfAnswer.length];
			for(int i = 0; i<choiceOfAnswer.length; i++) {
				numberOfVoters[i]=vsrv.getNumberOfVoters("chosenChoiceName", 
						(String)choiceOfAnswer[i]);
				choiceOfAnswerContent=choiceOfAnswerContent+choiceOfAnswer[i]+"~"+numberOfVoters[i];
				if(i<choiceOfAnswer.length-1){
					choiceOfAnswerContent = choiceOfAnswerContent + ";";
				}
			}
		}
		
		if(!"".equals(choiceOfDateTimeList) && 
				choiceOfDateTimeList!=null) {
			choiceOfDateTime = choiceOfDateTimeList.split("~");
			int[] numberOfVoters = new int[choiceOfDateTime.length];
			for(int i = 0; i<choiceOfDateTime.length; i++) {
				numberOfVoters[i]=vsrv.getNumberOfVoters("chosenDateTime", 
						(String)choiceOfDateTime[i]);
				choiceOfDateTimeContent=choiceOfDateTimeContent+choiceOfDateTime[i]+"~"+numberOfVoters[i];
				if(i<choiceOfDateTime.length-1){
					choiceOfDateTimeContent = choiceOfDateTimeContent + ";";
				}
			}
		}
		obj.setEventId(eventId);
		obj.setTotalVoters(vsrv.getTotalVoters(eventId));
		obj.setChoiceOfLocation(choiceOfLocationContent);
		obj.setChoiceOfAnswer(choiceOfAnswerContent);
		obj.setChoiceOfDateTime(choiceOfDateTimeContent);
		
		listVoteResultJson = mapper.writeValueAsString(obj);
		
		return listVoteResultJson;
	}
}
