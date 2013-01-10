package com.ericsson.ams.model;

import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class Test extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private Long id;
	
	/**
	 * 
	 */
	private Integer a;
	
	/**
	 * 
	 */
	private String b;

	@Override
	public List<?> getBusinessKey() {
		return Arrays.asList(id);
	}

	/**
	 * @return
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return
	 */
	public Integer getA() {
		return a;
	}

	/**
	 * @param a
	 */
	public void setA(Integer a) {
		this.a = a;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}
}