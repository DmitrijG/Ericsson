package com.ericsson.ams.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.ericsson.ams.dao.TestDAO;
import com.ericsson.ams.model.Test;
import com.ericsson.ams.service.TestService;
import com.ericsson.ams.service.dto.TestDO;

/**
 */
public class TestServiceImpl implements TestService {
	/**
	 * 
	 */
	@Resource
	private TestDAO testDAO;

	@Override
	public List<TestDO> findAll() {
		List<TestDO> testDOs = new ArrayList<TestDO>();

		for (Test test : testDAO.findAll()) {
			TestDO testDO = new TestDO();
			testDO.setId(test.getId());
			testDO.setA(test.getA());
			testDO.setB(test.getB());
			testDOs.add(testDO);
		}

		return testDOs;
	}
}