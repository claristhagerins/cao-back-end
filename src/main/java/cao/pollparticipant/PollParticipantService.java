package cao.pollparticipant;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cao.events.EventsMapper;
import cao.user.UserMapper;
import mybatis.MyBatisUtil;

public class PollParticipantService {
	
	public String getPollParticipantId(String prefix) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			PollParticipantMapper pollParticipantMapper = sqlSession.getMapper(PollParticipantMapper.class);
			return pollParticipantMapper.getPollParticipantId(prefix);
		} finally {
			sqlSession.close();
		}
	}
	
	public void insertPollParticipant(String pollParticipantId, String pollUserId, String pollRoleEventId) {
	SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			PollParticipantMapper pollParticipantMapper = sqlSession.getMapper(PollParticipantMapper.class);
			pollParticipantMapper.insertPollParticipant(pollParticipantId, pollUserId, pollRoleEventId);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
}
