package cao.voteresult;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

import com.fasterxml.jackson.core.io.InputDecorator;

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
		System.out.println("CHOSEN DATE TIME: "+inputChosenDateTime);
		

		inputChosenLocationName = "{\"chosenLocationName\":[pilihan]}";
		for(int i=0; i<chosenLocationNameArray.length; i++) {
			chosenLocationName +="\""+chosenLocationNameArray[i]+"\"";
			if(i!=chosenLocationNameArray.length-1) {
				chosenLocationName += ", ";
			}
		}
		inputChosenLocationName = inputChosenLocationName.replace("pilihan", chosenLocationName);
		System.out.println("CHOSEN LOCATION NAME: "+inputChosenLocationName);
		

		inputChosenChoiceName = "{\"chosenChoiceName\":[pilihan]}";
		for(int i=0; i<chosenChoiceNameArray.length; i++) {
			chosenChoiceName +="\""+chosenChoiceNameArray[i]+"\"";
			if(i!=chosenChoiceNameArray.length-1) {
				chosenChoiceName += ", ";
			}
		}
		inputChosenChoiceName = inputChosenChoiceName.replace("pilihan", chosenChoiceName);
		System.out.println("CHOSEN CHOICE NAME: "+inputChosenChoiceName);
		
		System.out.println("end hehe");
		System.out.println("event id: "+eventId);
		System.out.println("user id: "+userId);
		
		//flag red
		String url = "jdbc:postgresql://localhost:5432/CAO";
		String user = "postgres";
		String password = "admin";
		Connection conn =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "insert into vote_result(event_id, user_id, chosen_date_time, chosen_location_name, chosen_choice_name) " + 
					"values (?, ?, CAST(? AS json)," + 
					"CAST(? AS json), CAST(? AS json)) " + 
					"on conflict (event_id, user_id)\r\n" + 
					"do update set " + 
					"chosen_date_time = CAST(? AS json)," + 
					"chosen_location_name = CAST(? AS json)," + 
					"chosen_choice_name = CAST(? AS json)";
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url, user, password);
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, eventId);
			ps.setString(2, userId);
			ps.setString(3, inputChosenDateTime);
			ps.setString(4, inputChosenLocationName);
			ps.setString(5, inputChosenChoiceName);
			ps.setString(6, inputChosenDateTime);
			ps.setString(7, inputChosenLocationName);
			ps.setString(8, inputChosenChoiceName);
			
			ps.executeUpdate();
			return "SUBMIT VOTE SUCCESS";
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "SUBMIT VOTE FAILED";
		}
//		finally {
//			try {
//				rs.close();
//				ps.close();
//				conn.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		//end flag red
		
//		try {
//			vsrv.giveVote(eventId, userId, inputChosenDateTime, 
//					inputChosenLocationName, inputChosenChoiceName);
//			return "SUBMIT VOTE SUCCESS";
//		}catch (Exception e) {
//			// TODO: handle exception
//			return "SUBMIT VOTE FAILED";
//		}
	}
	
	@PostMapping(value = "/showVoteResult")	
	public @ResponseBody String showVoteResult (//RequestParam String userId, 
			@RequestBody Events event
			//@RequestBody VoteResult voteResult
			) {
		VoteResultService vsrv = new VoteResultService();
		String eventId = event.getEventId();
		
		VoteResult obj = new VoteResult();

		ObjectMapper mapper = JsonFactory.create();

		
		String listVoteResultJson=null;
		List<Map<String, String>> listOfChoices=null;
		listOfChoices = vsrv.getChoices(eventId);
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
