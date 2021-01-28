package com.dhanrajapp.util;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static StandardServiceRegistry registry;
	private static MetadataSources metadataSources;
	private static Metadata metadata;
	private static SessionFactory factory;
	
	private static Logger logger=Logger.getLogger(HibernateUtil.class);
	
	public static SessionFactory getSessionFactory() {
		registry=new StandardServiceRegistryBuilder().configure("../main/java/hibernate.cfg.xml").build();
		metadataSources=new MetadataSources(registry);
		metadata=metadataSources.getMetadataBuilder().build();
		factory=metadata.getSessionFactoryBuilder().build();
		logger.info("Factory Created Successfully");
		return factory;
	}
	
}
