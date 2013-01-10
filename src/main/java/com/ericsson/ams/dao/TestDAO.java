package com.ericsson.ams.dao;

import java.util.List;

import com.ericsson.ams.model.Test;

/**
 *
 */
public interface TestDAO {
	/**
	 * @return
	 */
	List<Test> findAll();
}