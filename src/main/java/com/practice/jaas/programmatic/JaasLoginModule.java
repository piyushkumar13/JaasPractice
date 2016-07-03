package com.practice.jaas.programmatic;

import java.io.IOException;
import java.security.Principal;
import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class JaasLoginModule implements LoginModule {

	private Subject subject;
	private CallbackHandler handler;
	private Map<String, ?> sharedState;
	private Map<String, ?> options;
	private String username;
	private String password;
	private boolean succeeded;
	private boolean commitSucceeded;

	public void initialize(
			Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState, Map<String, ?> options) {
		System.out.println("Inside the initializer ...");
		this.subject = subject;
		this.handler = callbackHandler;
		this.sharedState = sharedState;
		this.options = options;
	}

	public boolean login() throws LoginException {
		System.out.println("Inside login....");

		NameCallback nameCallback = new NameCallback("username : ");
		PasswordCallback passwordCallback = new PasswordCallback("password : ", false);

		Callback[] callbacks = new Callback[] { nameCallback, passwordCallback };

		try {
			handler.handle(callbacks);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (UnsupportedCallbackException e) {
			e.printStackTrace();
		}

		username = nameCallback.getName();
		password = new String(passwordCallback.getPassword());
		if (username.equals("piyush") && password.equals("kumar")) {
			System.out.println("Login successful ....");
			succeeded = true;
			return true;
		}
		System.out.println("Login failed");
		return false;
	}

	public boolean commit() throws LoginException {
		System.out.println("Inside commit ...");
		if (!succeeded) {
			System.out.println("Commint unsuccessful...");
			return false;
		} else {
			JaasUserPrincipal userPrincipal = new JaasUserPrincipal(username);
			JaasPasswordPrincipal passwordPrincipal = new JaasPasswordPrincipal(password);

			if (!subject.getPrincipals().contains(userPrincipal)) {
				subject.getPrincipals().add(userPrincipal);
			}
			if (!subject.getPrincipals().contains(passwordPrincipal)) {
				subject.getPrincipals().add(passwordPrincipal);
			}
			commitSucceeded = true;
			System.out.println("Commit successful ...");
			return true;
		}
	}

	public boolean abort() throws LoginException {
		System.out.println("Inside Abort...");
		return true;
	}

	public boolean logout() throws LoginException {
		System.out.println("Inside logout ... ");
		subject.getPrincipals().clear();
		username = null;
		password = null;
		succeeded = false;
		commitSucceeded = false;
		return true;
	}

}
