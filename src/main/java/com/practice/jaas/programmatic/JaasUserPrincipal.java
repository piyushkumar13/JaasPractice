package com.practice.jaas.programmatic;

import java.io.Serializable;
import java.security.Principal;

public class JaasUserPrincipal implements Principal, Serializable {

	private String username;

	public JaasUserPrincipal(String name) {
		this.username = name;
	}

	public String getName() {
		return username;
	}

}
