package br.com.pedidosimples.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import  br.com.pedidosimples.util.HibernateUtil;

public abstract class DaoImplementacao<T> implements DaoInterface<T> {

	private Class<T> persistenceClass;

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public DaoImplementacao(Class<T> persistenceClass) {
		super();
		this.persistenceClass = persistenceClass;
	}

	@Override
	public void salvar(T objeto) throws Exception {
		sessionFactory.getCurrentSession().beginTransaction();	
		sessionFactory.getCurrentSession().save(objeto);
		sessionFactory.getCurrentSession().flush();
		sessionFactory.getCurrentSession().getTransaction().commit();
	}

	@Override
	public void deletar(T objeto) throws Exception {
		sessionFactory.getCurrentSession().beginTransaction();	
		sessionFactory.getCurrentSession().delete(objeto);
		sessionFactory.getCurrentSession().flush();
		sessionFactory.getCurrentSession().getTransaction().commit();
	}

	@Override
	public void atualizar(T objeto) throws Exception {
		sessionFactory.getCurrentSession().beginTransaction();	
		sessionFactory.getCurrentSession().update(objeto);
		sessionFactory.getCurrentSession().flush();
		sessionFactory.getCurrentSession().getTransaction().commit();
	}

	@Override
	public void salvarOuAtualizar(T objeto) throws Exception {
		sessionFactory.getCurrentSession().beginTransaction();	
		sessionFactory.getCurrentSession().saveOrUpdate(objeto);
		sessionFactory.getCurrentSession().flush();
		sessionFactory.getCurrentSession().getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T merge(T objeto) throws Exception {
		sessionFactory.getCurrentSession().beginTransaction();	
		 T t =  (T) sessionFactory.getCurrentSession().merge(objeto);
		 sessionFactory.getCurrentSession().flush();
		 sessionFactory.getCurrentSession().getTransaction().commit();
		 return t;
		
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> lista() throws Exception {
		List<T> retorno = null;
		sessionFactory.getCurrentSession().beginTransaction();
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(persistenceClass);
		criteria.addOrder(Order.asc("id"));
		retorno = criteria.list();
		sessionFactory.getCurrentSession().getTransaction().commit();
		return retorno;
	}
	
	@Override
	public T loadObjeto(Long codigo) throws Exception { 
		return (T) sessionFactory.getCurrentSession().get(persistenceClass, codigo);
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public Class<T> getPersistenceClass() {
		return persistenceClass;
	}
	
	
	@Override
	public List<T> lista(String campoBanco, String valorCampo) throws Exception {
		sessionFactory.getCurrentSession().beginTransaction();
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(getPersistenceClass());
		criteria.add(Restrictions.like(campoBanco, valorCampo));
		criteria.addOrder(Order.asc("id"));
		return criteria.list();
	}
	
	public List<T> listaPorData(String campoBanco, String valorCampo) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sessionFactory.getCurrentSession().beginTransaction();
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(getPersistenceClass());
		criteria.add(Restrictions.eq(campoBanco, sdf.parse(valorCampo)));
		criteria.addOrder(Order.asc("id"));
		return criteria.list();
	}
	
	@Override
	public List<T> lista(String campoBanco, Long valorCampo) throws Exception {
		List<T> retorno = null;
		sessionFactory.getCurrentSession().beginTransaction();
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(getPersistenceClass());
		criteria.add(Restrictions.eq(campoBanco, valorCampo));
		criteria.addOrder(Order.asc("id"));
		retorno = criteria.list();
		sessionFactory.getCurrentSession().getTransaction().commit();
		return retorno;
	}
	
	@Override
	public List<T> listaLikeExpression(String campoBanco, String valorCampo)
			throws Exception {
		try{
			getSessionFactory().getCurrentSession().beginTransaction(); 
		return getSessionFactory().
				getCurrentSession().
				createQuery(" select a from " + getPersistenceClass().getSimpleName() + " a where a." + campoBanco + " like'%" + valorCampo + "%'").list();
		}finally{
			getSessionFactory().getCurrentSession().getTransaction().commit();
		}
	}
	
	
	
	@Override
	public List<T> lista(String ids) throws Exception {
		
		List<Long> longs = new ArrayList<Long>();
		List<T> retorno = null;
		
		String[] strings = ids.split(",");
		for (int i = 0 ; i < strings.length; i++){
			longs.add(Long.parseLong(strings[i]));
		}
		
		sessionFactory.getCurrentSession().beginTransaction();
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(getPersistenceClass());
		criteria.add(Restrictions.in("id", longs));		
		retorno = criteria.list();
		sessionFactory.getCurrentSession().getTransaction().commit();
		return retorno;
	}
	
	
	/**
	 * Retorna a lista de objetos de acordo com a pagina offset
	 * @param numeroPagina
	 * @return List<T> persistenceClass
	 * @throws Exception
	 */
	public List<T> consultaPaginada(String numeroPagina) throws Exception {
		List<T> retorno = null;
		int total_por_pagina = 6;
		if (numeroPagina == null || (numeroPagina != null && numeroPagina.trim().isEmpty())){
			numeroPagina = "0";
		}
		int offSet = (Integer.parseInt(numeroPagina) * total_por_pagina) - total_por_pagina; 
		
		if (offSet < 0){
			offSet = 0;
		}
		
		Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(getPersistenceClass());
		criteria.setFirstResult(offSet);
		criteria.setMaxResults(total_por_pagina);
		criteria.addOrder(Order.asc("id"));
		retorno = criteria.list();
		sessionFactory.getCurrentSession().getTransaction().commit();
		return retorno;
	}

	/**
	 * Retorna a quantidade de paginas de registros
	 * @return int quantidadePagina
	 * @throws Exception
	 */
	public int quantidadePagina() throws Exception {
		String sql = "select count(1) as totalRegistros FROM " + getPersistenceClass().getSimpleName();
		int quantidadePagina = 1;
		double total_por_pagina = 6.0;
			SQLQuery find = getSessionFactory().getCurrentSession().createSQLQuery(sql);
			Object resultSet = find.uniqueResult();
			if (resultSet != null) {
				double totalRegistros = Double.parseDouble(resultSet.toString());
				if (totalRegistros > total_por_pagina){
					
					double quantidadePaginaTemp = Float.parseFloat(""+(totalRegistros / total_por_pagina));

					if (!(quantidadePaginaTemp % 2 == 0)){
						quantidadePagina =   new Double(quantidadePaginaTemp).intValue() + 1;
					}
					else {
						quantidadePagina = new Double(quantidadePaginaTemp).intValue();
					}
				}else {
					quantidadePagina = 1;
				}
			}
		return quantidadePagina;
	}
}
