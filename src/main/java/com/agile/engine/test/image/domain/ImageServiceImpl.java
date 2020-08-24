package com.agile.engine.test.image.domain;

import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.agile.engine.test.image.ImageService;
import com.agile.engine.test.image.domain.outbound.AgileEngineGateway;
import com.agile.engine.test.image.entity.TokenEntity;
import com.agile.engine.test.image.model.authentication.AuthResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
@RequiredArgsConstructor
@PropertySource(value = { "classpath:application.properties" })
public class ImageServiceImpl implements ImageService
{

	private final AgileEngineGateway agileEngineGateway;

	@PersistenceContext
	private EntityManager entityManager;


	@Value("${agile.engine.image.api.key}")
	private String apiKey;

	@Override
	//@Transactional
	public String getBearerToken()
	{
		final AuthResponse authResponse = agileEngineGateway.getBearerToken(apiKey);
		log.info("SUCCESS: " + authResponse.getToken());

		/*entityManager.getTransaction().begin();
		TokenEntity token = new TokenEntity();
		token.setToken(authResponse.getToken());
		token.setExpired(Boolean.FALSE);
		token.setIssued(new Timestamp(System.currentTimeMillis()));
		entityManager.persist(token);*/

		return authResponse.getToken();
	}



}
