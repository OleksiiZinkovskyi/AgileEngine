package com.agile.engine.test.image.gateway;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.agile.engine.test.image.domain.outbound.AgileEngineGateway;
import com.agile.engine.test.image.model.authentication.AuthResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
@RequiredArgsConstructor
@PropertySource(value = { "classpath:application.properties" })
public class AgileEngineGatewayImpl implements AgileEngineGateway
{

	private static final String AUTH_SUFFIX = "auth";
	private static final String REPLACE_BRACKETS_REGEX = "\\[|\\]";

	@Value("${agile.engine.base.url}")
	private String baseUrl;

	private final RestTemplate restTemplate;

	//TODO: Remake using WebClient for token caching and automated renewal?
	@Override
	public AuthResponse getBearerToken(final String apiKey)
	{
		final String tokenEndpointUrl = baseUrl + AUTH_SUFFIX;
		final HttpEntity<String> request = buildAuthRequest(apiKey);
		try
		{
			return restTemplate.postForObject(tokenEndpointUrl, request, AuthResponse.class);
		}
		catch (HttpClientErrorException ex)
		{
			log.error("Failed to get a bearer token: ", ex);
			//TODO: Exception recovery logic TBD
			throw ex;
		}
	}

	private HttpEntity<String> buildAuthRequest(final String apiKey)
	{
		//TODO: Rewrite using ObjectMapper
		JSONObject properties = new JSONObject();
		properties.append("apiKey", apiKey);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return new HttpEntity<>(properties.toString().replaceAll(REPLACE_BRACKETS_REGEX, ""), headers);
	}

}
