package com.dhanrajapp.db;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dhanrajapp.bean.LoginBean;
import com.dhanrajapp.util.HibernateUtil;
import com.dhanrajapp.util.Utility;

public class LoginDao {
	private SessionFactory factory=HibernateUtil.getSessionFactory();
	private Session session=null;
	private Transaction transaction=null;
	private static Logger logger=Logger.getLogger(LoginDao.class);
	
	public Object[] getLoginDetails(String id, String pass, String license) {
		try {
			session=factory.openSession();
			Query query = session.createSQLQuery("select l.admin,lt.id from login_table l left join license_table lt on lt.id=l.license where l.staffid='"+id+"' AND l.password='"+pass+"' and l.license='"+license+"'");
			List<Object[]> list = query.list();
			if (!Utility.listIsNullOrEmpty(list)) {
				return  list.get(0);
			}
		} catch (Exception e) {
			logger.error("Exception occured while ",e);
		} finally {
			if (null != session && session.isOpen()) {
				session.close();
			}
		}
		return null;
	}
	public List<LoginBean> getLogin() {
		try {
			session=factory.openSession();
			Query query = session.createQuery("from LoginBean");
			List<LoginBean> list = query.list();
			if(!Utility.listIsNullOrEmpty(list)) {
				return list;
			}
		} catch (Exception e) {
			logger.error("Exception occured while ",e);
		} finally {
			if (null != session && session.isOpen()) {
				session.close();
			}
		}
		return null;
	}
	
	public int updateUser(String staffId,String password,String senerity,int id) {
		try {
			session=factory.openSession();
			transaction = session.beginTransaction();
			Query query =session.createSQLQuery("update login_table set staffid='"+staffId+"',password='"+password+"',seniority='"+senerity+"' where id="+id+"");
			int rowsAffected=query.executeUpdate();
			transaction.commit();
	        session.close();
	        return rowsAffected;
		}catch (Exception e) {
			logger.error("Exception occured while ",e);
			return 0;
		} finally {
			if (null != session && session.isOpen()) {
				session.close();
			}
		}
	}
	public List<String> getStaffid(){
		try {
			session=factory.openSession();
			Query query = session.createSQLQuery("select staffid from login_table");
			List<String> list = query.list();
			if(!Utility.listIsNullOrEmpty(list)) {
				return list;
		}
			
		}catch (Exception e) {
			logger.error("Exception occured while ",e);
		} finally {
			if (null != session && session.isOpen()) {
				session.close();
			}
		
		
	}
	
		return null;
	}
}
