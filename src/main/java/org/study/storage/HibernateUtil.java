package org.study.storage;

import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.study.link.Link;

public class HibernateUtil {
	private static final HibernateUtil INSTANCE;

	@Getter
	private SessionFactory sessionFactory;

	static {
		INSTANCE = new HibernateUtil();
	}

	private HibernateUtil() {
		sessionFactory = new Configuration()
				.setProperty("hibernate.connection.url",StorageConstants.CONNECTION_URL)
				.addAnnotatedClass(Link.class)
				.buildSessionFactory();
	}

	public static HibernateUtil getInstance() {
		return INSTANCE;
	}

	public void close() {
		sessionFactory.close();
	}
}
//hibernate.dialect=org.hibernate.dialect.H2Dialect
//		hibernate.connection.driver_class=org.h2.Driver
//		#hibernate.connection.url=jdbc:h2:./mydb;TRACE_LEVEL_SYSTEM_OUT=3
//		hibernate.connection.pool_size=10
//		hibernate.connection.autocommit=true