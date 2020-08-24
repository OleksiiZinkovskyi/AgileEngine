package com.agile.engine.test.image.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.agile.engine.test.image.ImageService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequiredArgsConstructor
public class ImageController
{

	private final ImageService imageService;

	@GetMapping(value = "/test")
	@ResponseStatus(HttpStatus.OK)
	public void test() {
		log.info("CONTROLLER: " + imageService.getBearerToken());
	}

}
