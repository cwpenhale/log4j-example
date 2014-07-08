package com.openlogic.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet(urlPatterns="/log",loadOnStartup=1)
public class LoggerTest extends HttpServlet {
	
	/**
	 * @author connor.penhale@openlogic.com
	 */
	private static final long serialVersionUID = -8838320310739332919L;
	private static final Logger log = Logger.getLogger(LoggerTest.class);

	public LoggerTest() {
		if(log.isDebugEnabled())
			log.info("STARTED");
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.error("HIT");
		if(req.getParameter("level")!=null&&req.getParameter("level").equals("DEBUG"))
			log.debug("DEBUG");
	}

}
