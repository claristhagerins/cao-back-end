package mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private static SqlSessionFactory factory;

	private MyBatisUtil() {
	}

	static {
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream("mybatis/mybatis-config.xml");
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
		factory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return factory;
	}
}
