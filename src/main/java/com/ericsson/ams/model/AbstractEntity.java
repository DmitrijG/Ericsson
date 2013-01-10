package com.ericsson.ams.model;

import java.io.Serializable;
import java.util.List;

/**
 *
 */
public abstract class AbstractEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unused")
	private Long version;

	/**
	 * @return
	 */
	public abstract List<?> getBusinessKey();

	@Override
	public String toString() {
		return String.format("%s key = %s.", getClass().getSimpleName(),
				getBusinessKey());
	}

	@Override
	public int hashCode() {
		return getBusinessKey().hashCode();
	}

	@Override
	public boolean equals(Object object) {
		if (object == null) {
			return false;
		}

		if (!(object instanceof AbstractEntity)) {
			return false;
		}

		return getBusinessKey().equals(
				((AbstractEntity) object).getBusinessKey());
	}
}