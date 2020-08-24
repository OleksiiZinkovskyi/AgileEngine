package com.agile.engine.test.image.model.authentication;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthResponse
{

	private Boolean auth;
	private String token;

	//TODO: Remove later
	public AuthResponse() {}

	public AuthResponse(final Boolean auth, final String token)
	{
		this.auth = auth;
		this.token = token;
	}

}
