package com.ericsson.ams.service;

import java.util.List;

import com.ericsson.ams.service.dto.TestDO;

/**
 *
 */
public interface TestService {
	/**
	 * @return
	 */
	List<TestDO> findAll();
}