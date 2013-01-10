package com.ericsson.ams.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.ericsson.ams.model.AbstractEntity;

/**
 *
 */
public abstract class AbstractHibernateDAO {
	/**
	 * 
	 */
	@Resource
	private SessionFactory sessionFactory;

	/**
	 * @return
	 */
	protected SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param entity
	 */
	protected void create(Object entity) {
		update(entity);
	}

	/**
	 * @param entity
	 */
	protected void update(Object entity) {
		getSessionFactory().getCurrentSession().saveOrUpdate(entity);
	}

	/**
	 * @param entity
	 */
	protected void delete(Object entity) {
		getSessionFactory().getCurrentSession().delete(entity);
	}

	/**
	 * @param clazz
	 * @param entityIdentifier
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected <T extends AbstractEntity> T find(
			Class<? extends AbstractEntity> clazz, Serializable entityIdentifier) {
		return (T) getSessionFactory().getCurrentSession().get(clazz,
				entityIdentifier);
	}

	/**
	 * @param clazz
	 * @param entityIdentifier
	 * @return
	 */
	protected <T extends AbstractEntity> T get(
			Class<? extends AbstractEntity> clazz, Serializable entityIdentifier) {
		T entity = find(clazz, entityIdentifier);
		if (entity == null) {
			throw new RuntimeException(String.format(
					"Cannot load the entity: %s, %s.", clazz,
					entityIdentifier));
		}

		return entity;
	}

	/**
	 * @param queryHQL
	 * @param parameters
	 * @return
	 */
	protected <T extends AbstractEntity> List<T> list(String queryHQL,
			Object... parameters) {
		Query query = getSessionFactory().getCurrentSession().createQuery(
				queryHQL);
		return list(query, parameters);
	}

	/**
	 * @param queryName
	 * @param parameters
	 * @return
	 */
	protected <T extends AbstractEntity> List<T> namedList(String queryName,
			Object... parameters) {
		Query query = getSessionFactory().getCurrentSession().getNamedQuery(
				queryName);
		return list(query, parameters);
	}

	/**
	 * @param query
	 * @param parameters
	 */
	private void setParameters(Query query, Object... parameters) {
		for (int i = 0; i < parameters.length; i++) {
			query.setParameter(i, parameters[i]);
		}
	}

	/**
	 * @param query
	 * @param parameters
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private <T extends AbstractEntity> List<T> list(Query query,
			Object... parameters) {
		setParameters(query, parameters);
		return query.list();
	}
}