package cao.voteresult;

import java.util.List;

import cao.events.Events;
import cao.user.User;

public interface VoteMapper {
	public List<VoteResult> getVoteResultByUserId(String userId);
}
