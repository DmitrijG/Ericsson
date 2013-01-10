package com.ericsson.ams.web.handler.xslt;

import javax.annotation.Resource;
import javax.xml.bind.JAXBException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ericsson.ams.service.TestService;

/**
 *
 */
@Controller
@RequestMapping("/welcome")
public class WelcomeHandler {
	/**
	 * 
	 */
	@Resource
	private TestService testService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView doGet() throws JAXBException {
		return doPost();
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView doPost() throws JAXBException {
		return new ModelAndView("welcome");
	}
}