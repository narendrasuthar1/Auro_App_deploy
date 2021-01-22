package com.dhanrajapp.db;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dhanrajapp.bean.LoginBean;
import com.dhanrajapp.bean.PendingTaskBean;
import com.dhanrajapp.util.HibernateUtil;
import com.dhanrajapp.util.Utility;
public class PendingDao {
	private SessionFactory factory=HibernateUtil.getSessionFactory();
	private Session session=null;
	private Transaction transaction=null;
	private static Logger logger=Logger.getLogger(PendingDao.class);
	
	public int saveBean(PendingTaskBean Bean)
	{
		try {
			session= factory.openSession();
			transaction=session.beginTransaction();
			int id=(Integer) session.save(Bean);
			transaction.commit();
			session.close();
			return id;
		}
		catch(Exception e) {
			logger.error("Exception occured while ",e);
			
			} finally {
				if (null != session && session.isOpen()) {
					session.close();
				}
			
		}
		return 0;
		
	}
	
	public List<PendingTaskBean> getPending(String id){
		try {
			session=factory.openSession();
			Query query=session.createQuery("from PendingTaskBean where status='ACTIVE' and license='"+id+"' order by staffid asc, urg desc, task_status desc, task asc, remark desc");
			List<PendingTaskBean> list = query.list();
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
	public List<PendingTaskBean> getDeletedPending(String id){
		try {
			session=factory.openSession();
			Query query=session.createQuery("from PendingTaskBean where status='NOT ACTIVE' and license='"+id+"' order by staffid asc, urg desc, task_status desc, task asc, remark desc");
			List<PendingTaskBean> list = query.list();
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
	public int updatePending(String name,String value,int id) {
		try {
			session=factory.openSession();
			transaction = session.beginTransaction();
			Query query =session.createSQLQuery("update pendingtask_table set "+name+"='"+value+"' where id="+id+"");
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

	
}

