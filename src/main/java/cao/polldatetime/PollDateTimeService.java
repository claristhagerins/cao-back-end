package cao.polldatetime;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cao.polllocation.PollLocationMapper;
import cao.user.UserMapper;
import mybatis.MyBatisUtil;

public class PollDateTimeService {
	public String getPolldateTimeId(String prefix) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			PollDateTimeMapper pollDateTimeMapper = sqlSession.getMapper(PollDateTimeMapper.class);
			return pollDateTimeMapper.getPollDateTimeId(prefix);
		} finally {
			sqlSession.close();
		}
	}
	
	public void insertPollDateTime(String pollDateTimeId, String eventDate
			//,String startTime, String endTime
			) { 
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			PollDateTimeMapper pollDateTimeMapper = sqlSession.getMapper(PollDateTimeMapper.class);
			pollDateTimeMapper.insertPollDateTime(pollDateTimeId, eventDate/*, startTime, endTime*/);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
}
