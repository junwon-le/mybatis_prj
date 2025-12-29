package kr.co.sist.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class myBatiseHandler {
	private static myBatiseHandler mdh;
	private static SqlSessionFactory ssf;
	
	private myBatiseHandler() {
		org.apache.ibatis.logging.LogFactory.useLog4J2Logging();
	}
	
	public static myBatiseHandler getInstance() { 
		if(mdh == null) {
			mdh=new myBatiseHandler();
		}
		return mdh;
	}//getInstance
	
	private SqlSessionFactory getSessFactory() throws IOException {
		if(ssf == null) {
			//1. 설정용 XML과 연결
			Reader reader = Resources.getResourceAsReader("kr/co/sist/dao/mybatis-config.xml");
			//2. SqlSessionFactoryBuild 생성
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			//3. SqlSessionFatory를 bilding 한다.
			ssf = ssfb.build(reader);
			if(reader != null) {
				reader.close();
			}//end if
			
		}//end if
		return ssf;
	}//getSessFactory
	
	/**
	 * MyBatise Handler 얻기 
	 * @param autoCommitFlag true- autolcommit, flase - non autocommit
	 * @return
	 */
	public SqlSession getMyBatisHandler(boolean autoCommitFlag) {
		SqlSession ss = null;
		
		try {
			ss= getSessFactory().openSession(autoCommitFlag);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		return ss;
	}
	
}//class
