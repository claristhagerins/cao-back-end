package cao.polllocation;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cao.events.EventsMapper;
import cao.user.UserMapper;
import mybatis.MyBatisUtil;

public class PollLocationService {

	public String getPollLocationId(String prefix) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
		PollLocationMapper pollLocationMapper = sqlSession.getMapper(PollLocationMapper.class);
			return pollLocationMapper.getPollLocationId(prefix);
		} finally {
			sqlSession.close();
		}
	}
	
	public void insertPollLocation(String pollLocationId, String locationName, String locationContact) { 
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			PollLocationMapper pollLocationMapper = sqlSession.getMapper(PollLocationMapper.class);
			pollLocationMapper.insertPollLocation(pollLocationId, locationName, locationContact);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	public String getContactByLocationName(String locationName) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
		PollLocationMapper pollLocationMapper = sqlSession.getMapper(PollLocationMapper.class);
			return pollLocationMapper.getContactByLocationName(locationName);
		} finally {
			sqlSession.close();
		}
	}
}
