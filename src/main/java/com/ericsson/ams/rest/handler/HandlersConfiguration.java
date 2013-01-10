package com.ericsson.ams.rest.handler;

import com.ericsson.ams.rest.handler.welcome.WelcomeHandler;
import com.sun.jersey.api.core.ClassNamesResourceConfig;

/**
 *
 */
public class HandlersConfiguration extends ClassNamesResourceConfig {
	/**
	 * 
	 */
	public HandlersConfiguration() {
		super(WelcomeHandler.class);
	}
}