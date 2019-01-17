package br.com.pedidosimples.util;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil implements Serializable {

	private static final long serialVersionUID = 1L;

	private static SessionFactory sessionFactory = buildSessionFactory();

	/**
	 * Respons�vel por ler o arquivo de configura��o hibernate.cfg.xml
	 * 
	 * @return SessionFactory
	 */
	private static SessionFactory buildSessionFactory() {
		try {
			if (sessionFactory == null) {
				sessionFactory = (new Configuration()).configure()
						.buildSessionFactory();
			}
			return sessionFactory;

		} catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError(
					"Erro ao criar conex�o SessionFactory:" + e.getMessage());
		}
	}

	/**
	 * Retorna o sessionFactory corrente.
	 * 
	 * @return sessionFactory
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
