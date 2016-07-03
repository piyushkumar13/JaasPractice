package com.practice.jaas;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BasicAuthenticatedServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");

		Principal principal = request.getUserPrincipal();
		String principal_name = "Unauthenticated user";
		if (null != principal) {
			principal_name = principal.getName();
		}

		writer.write("Hi!! You are " + principal_name);

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");

		Principal principal = request.getUserPrincipal();
		String principal_name = "Unauthenticated user";
		if (null != principal) {
			principal_name = principal.getName();
		}

		writer.write("Hi!! You are " + principal_name);

	}

}
