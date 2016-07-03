package com.practice.jaas.programmatic;

import java.io.Serializable;
import java.security.Principal;

public class JaasPasswordPrincipal implements Principal, Serializable {

	private String password;

	public JaasPasswordPrincipal(String password) {
		this.password = password;
	}

	public String getName() {
		return password;
	}

}
