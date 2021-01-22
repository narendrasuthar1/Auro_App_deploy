package com.dhanrajapp.db;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dhanrajapp.bean.LicenseBean;
import com.dhanrajapp.bean.LoginBean;
import com.dhanrajapp.form.LicenseForm;
import com.dhanrajapp.util.HibernateUtil;
import com.dhanrajapp.util.Utility;

public class LicenseDao {
	private SessionFactory factory = HibernateUtil.getSessionFactory();
	private Session session = null;
	private Transaction transaction = null;
	private static Logger logger = Logger.getLogger(HibernateUtil.class);

	public String getLicenseDetails() {
		try {
			session = factory.openSession();
			Query query = session.createSQLQuery("select licexpdt from license_table");
			List<Object> list = query.list();
			if (!Utility.listIsNullOrEmpty(list)) {
				return (String) list.get(0);
			}
		} catch (Exception e) {
			logger.error("Exception occured while ", e);
		} finally {
			if (null != session && session.isOpen()) {
				session.close();
			}
		}
		return null;
	}

	public int saveBean(LicenseBean bean) {
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			int id = (Integer) session.save(bean);
			transaction.commit();
			session.close();
			return id;
		} catch (Exception e) {
			logger.error("Exception occured while ", e);
		} finally {
			if (null != session && session.isOpen()) {
				session.close();
			}
		}
		return 0;
	}

	public int saveLoginBean(LoginBean bean) {
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			int id =  (Integer) session.save(bean);
			transaction.commit();
			session.close();
			return id;
		} catch (Exception e) {
			logger.error("Exception occured while ", e);
		} finally {
			if (null != session && session.isOpen()) {
				session.close();
			}
		}
		return 0;
	}

}
