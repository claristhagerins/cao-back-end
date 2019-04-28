package cao.events;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import cao.pollbridge.PollBridge;
import cao.user.User;
import cao.user.UserMapper;
import cao.voteresult.VoteResultMapper;
import mybatis.MyBatisUtil;

public class EventsService {
	
	public String getEventId(String prefix) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			EventsMapper eventsMapper = sqlSession.getMapper(EventsMapper.class);
			return eventsMapper.getEventId(prefix);
		} finally {
			sqlSession.close();
		}
	}

	public void insertEvent(String eventId, String eventName, String eventDescription, 
			String pollStatus, String pollCondition, String eventCreatedBy, 
			String isMultiple, String pollClosedDate) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			EventsMapper eventMapper = sqlSession.getMapper(EventsMapper.class);
			eventMapper.insertEvent(eventId, eventName, eventDescription, pollStatus, 
					pollCondition, eventCreatedBy, isMultiple, pollClosedDate);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	public void insertVoteResult(String eventId, String pollUserId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			EventsMapper voteResultMapper = sqlSession.getMapper(EventsMapper.class);
			voteResultMapper.insertVoteResult(eventId, pollUserId);
		} finally {
			sqlSession.close();
		}
	}

	public List<Events> getEventList(String userId, String eventName, String eventDesc) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			EventsMapper eventsMapper = sqlSession.getMapper(EventsMapper.class);
			return eventsMapper.getEventList(userId, eventName, eventDesc);
		} finally {
			sqlSession.close();
		}
	}

	
	public List<Events> getEventDetailByEventId(String eventId, String pollLocationId,
			String pollDateTimeId, String choiceId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			EventsMapper eventsMapper = sqlSession.getMapper(EventsMapper.class);
			return eventsMapper.getEventDetailByEventId(eventId, pollLocationId, pollDateTimeId, choiceId);
		} finally {
			sqlSession.close();
		}
	}
	
	public List<Map<String,String>> getPollId(String eventId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			EventsMapper eventsMapper = sqlSession.getMapper(EventsMapper.class);
			return eventsMapper.getPollId(eventId);
		} finally {
			sqlSession.close();
		}
	}
	
	public PollBridge getEventBridge(String eventId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			EventsMapper eventsMapper = sqlSession.getMapper(EventsMapper.class);
			return eventsMapper.getEventBridge(eventId);
		} finally {
			sqlSession.close();
		}
	}
	
	public void deleteEvent(String eventId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			EventsMapper eventsMapper = sqlSession.getMapper(EventsMapper.class);
			eventsMapper.deleteEvent(eventId);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	public void deleteVoteResult(String eventId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			EventsMapper eventsMapper = sqlSession.getMapper(EventsMapper.class);
			eventsMapper.deleteVoteResult(eventId);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
	
	public void deletePollParticipant(String pollParticipantId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			EventsMapper eventsMapper = sqlSession.getMapper(EventsMapper.class);
			eventsMapper.deletePollParticipant(pollParticipantId);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
	
	public void deletePollLocation(String pollLocationId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			EventsMapper eventsMapper = sqlSession.getMapper(EventsMapper.class);
			eventsMapper.deletePollLocation(pollLocationId);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
	
	public void deletePollDateTime(String pollDateTimeId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			EventsMapper eventsMapper = sqlSession.getMapper(EventsMapper.class);
			eventsMapper.deletePollDateTime(pollDateTimeId);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
	
	public void deletePollQuestion(String pollQuestionId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			EventsMapper eventsMapper = sqlSession.getMapper(EventsMapper.class);
			eventsMapper.deletePollQuestion(pollQuestionId);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
	
	public void deletePollChoice(String pollQuestionId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			EventsMapper eventsMapper = sqlSession.getMapper(EventsMapper.class);
			eventsMapper.deletePollChoice(pollQuestionId);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
	
	public void deletePollBridge(String pollBridgeId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			EventsMapper eventsMapper = sqlSession.getMapper(EventsMapper.class);
			eventsMapper.deletePollBridge(pollBridgeId);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
}
