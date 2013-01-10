package com.ericsson.ams.dao.impl;

import java.util.List;

import com.ericsson.ams.dao.TestDAO;
import com.ericsson.ams.model.Test;

/**
 *
 */
public class TestDAOImpl extends AbstractHibernateDAO implements TestDAO {
	@Override
	public List<Test> findAll() {
		return list("FROM Test t");
	}
}