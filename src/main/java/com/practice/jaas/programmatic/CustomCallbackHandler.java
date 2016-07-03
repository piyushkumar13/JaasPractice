package com.practice.jaas.programmatic;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;

public class CustomCallbackHandler implements CallbackHandler {

	private String username;
	private String password;

	public CustomCallbackHandler(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        System.out.println("Inside handler ...");
        
		if (callbacks[0] instanceof NameCallback) {
			((NameCallback) callbacks[0]).setName(username);
		}
		if (callbacks[1] instanceof PasswordCallback) {
			((PasswordCallback) callbacks[1]).setPassword(password.toCharArray());
		}
	}

} 
