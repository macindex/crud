package br.com.cadastro.hibernate;

import org.hibernate.cfg.Configuration;

import com.mysql.cj.xdevapi.SessionFactory;

public class HibernateUtil {
	
	private static final SessionFactory session = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try{
			Configuration cfg = new Configuration();
			cfg.configure("./META-INF/persistence.cfg.xml");
			return (SessionFactory) cfg.buildSessionFactory();
			
		}catch (Throwable e){
			System.out.println("Deu pau!\n " + e);
			throw new ExceptionInInitializerError();
			
		}
	}

	public static SessionFactory getSession() {
		return session;
	}	
}
