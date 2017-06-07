package com.example.controller;

import java.io.IOException;
import java.security.Principal;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.example.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@Controller
public class HomeController {

	@GetMapping("/")
	public String loginHome(Model model, Principal principal) {

		model.addAttribute("authenticated", false);

		if (principal != null) {
			model.addAttribute("authenticated", true);
			model.addAttribute("user", "Someone");

			/*
			 * RestTemplate restTemplate = new RestTemplate();
			 * HttpEntity<String> response =
			 * restTemplate.exchange("http://localhost:8080/user",
			 * HttpMethod.GET, null, String.class);
			 * System.out.println(response.getBody()); //com.example.model.User
			 * user = restTemplate.getForObject(
			 * "http://jsonplaceholder.typicode.com/users/1",
			 * com.example.model.User.class);
			 * //System.out.println(user.toString());
			 */

			// Only one time
			/*Unirest.setObjectMapper(new ObjectMapper() {
				private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper = new com.fasterxml.jackson.databind.ObjectMapper();

				public <T> T readValue(String value, Class<T> valueType) {
					try {
						return jacksonObjectMapper.readValue(value, valueType);
					} catch (IOException e) {
						throw new RuntimeException(e);
					}
				}

				public String writeValue(Object value) {
					try {
						return jacksonObjectMapper.writeValueAsString(value);
					} catch (JsonProcessingException e) {
						throw new RuntimeException(e);
					}
				}
			});

			HttpResponse<User> userResponse = null;
			try {
				userResponse = Unirest.get("http://localhost:8080/user")
						.asObject(User.class);
			} catch (UnirestException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			User userObject = userResponse.getBody();
			System.out.println(userObject.toString());*/
		}

		return "index";
	}
}
