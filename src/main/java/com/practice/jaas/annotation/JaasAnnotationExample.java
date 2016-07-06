package com.practice.jaas.annotation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/auth/annotation")
@ServletSecurity(httpMethodConstraints = { @HttpMethodConstraint(value = "POST", rolesAllowed = { "javaee" }) })
public class JaasAnnotationExample extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		writer.write("Hi! this is the servelet security in get request.");

	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter writer = resp.getWriter();
		resp.setContentType("text/html");
		writer.write("Hi! this is the servelet security in post request.");

	}
}
