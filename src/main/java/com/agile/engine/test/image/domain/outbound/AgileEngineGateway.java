package com.agile.engine.test.image.domain.outbound;

import com.agile.engine.test.image.model.authentication.AuthResponse;


public interface AgileEngineGateway
{

	AuthResponse getBearerToken(String apiKey);

}
