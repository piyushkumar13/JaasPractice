package com.practice.jaas.programmatic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpServletImpl extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("Inside the servlet ....");
		// System.setProperty("java.security.auth.login.config",
		// "/Users/kumarp9/Documents/eclipse_workspace/JaasPractice/src/main/resources/config/jaas.config");
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		CustomCallbackHandler handler = new CustomCallbackHandler(username, password);
		try {
			LoginContext lc = new LoginContext("JaasApplication", handler);
			lc.login();
			writer.write("Login is successful");
			lc.logout();

		} catch (LoginException e) {
			writer.write("Login failed");
			e.printStackTrace();
		}

	}
}
