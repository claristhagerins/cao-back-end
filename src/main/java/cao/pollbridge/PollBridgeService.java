package cao.pollbridge;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cao.events.EventsMapper;
import cao.pollbridge.PollBridgeMapper;
import mybatis.MyBatisUtil;

public class PollBridgeService {
	public String getPollBridgeId(String prefix) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			PollBridgeMapper pollBridgeMapper = sqlSession.getMapper(PollBridgeMapper.class);
			return pollBridgeMapper.getPollBridgeId(prefix);
		} finally {
			sqlSession.close();
		}
	}

	public void insertPollBridge(String pollBridgeId, String pollEventId, String pollParticipantId,
			String pollLocationId, String pollDateTimeId, String pollQuestionId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			PollBridgeMapper pollBridgeMapper = sqlSession.getMapper(PollBridgeMapper.class);
			pollBridgeMapper.insertPollBridge(pollBridgeId, pollEventId, pollParticipantId, 
					pollLocationId, pollDateTimeId, pollQuestionId);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
}
