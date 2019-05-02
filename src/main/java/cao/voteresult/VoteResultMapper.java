package cao.voteresult;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import cao.events.Events;
import cao.user.User;

public interface VoteResultMapper {
	public List<VoteResult> getVoteResultByUserId(String userId);
	public List<VoteResult> getVoteResultList(String eventId);
	public String getTotalVoters(String eventId);
	public String getTotalVotedVoters(String eventId);
	public int getNumberOfVoters(String chosenCategory, String chosenCategoryName);
	public List<Map<String,String>> getChoices(String eventId);
	public void giveVote(String eventId, String userId, String inputChosenDateTime, 
			String inputChosenLocationName, String inputChosenChoiceName);
	public void insertVoteResult(String eventId, String pollUserId);
}
