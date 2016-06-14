/**
* @author  Marchenko Oleksandr
* @version 1.0
* @since   2016-06-01
*/
package com.company.parkingmanager.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernateUtils {

	private static final Logger logger = LoggerFactory.getLogger(HibernateUtils.class);

	private static SessionFactory sessionFactory = null;

	public static SessionFactory getSessionFactory() {

		if (sessionFactory == null) {

			sessionFactory = new Configuration().configure().buildSessionFactory();

			logger.debug("SessionFactory was build.");

		} else {

			logger.debug("SessionFactory alredy exsist and was returned.");

			return sessionFactory;
		}

		return sessionFactory;

	}

}
