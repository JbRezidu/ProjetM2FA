package com.jirafe.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jirafe.entities.User;
import com.jirafe.services.JsonConverter;
import com.jirafe.services.UserService;

/** 
 * Contrôleur pour la gestion des User 
 */

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	JsonConverter jsonConverter;
	
	/**
	 * Ajoute un nouveau client dans la base de données
	 * @param req : requête reçue avec les données en JSON
	 * @param resp : permet de renvoyer la réponse avec le message correspondant
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public void createUser(HttpServletRequest req, HttpServletResponse resp) {
		String json = "";
		try {
			String line;
			while((line = req.getReader().readLine()) != null)
				json += line;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			User user = jsonConverter.userFromJson(json);
			userService.createUser(user);
			resp.getWriter().write(jsonConverter.JSON_OK);
		} catch(Exception e) {
			try {
				resp.getWriter().write(jsonConverter.JSON_ERROR);
			} catch (IOException xe) {
				xe.printStackTrace();
			}
		}
		
	}	

	/**
	 * Met à jour le token du client, via son adresse mail 
	 * @param req : requête reçue avec les données en JSON
	 * @param resp : permet de renvoyer la réponse avec le message correspondant
	 */
	@RequestMapping(value = "/updateToken", method = RequestMethod.POST)
	public void updateToken(HttpServletRequest req, HttpServletResponse resp) {
		String json = "";
		try {
			String line;
			while((line = req.getReader().readLine()) != null)
				json += line;
		} catch (Exception e) {
			e.printStackTrace();
		}
		String token = jsonConverter.fromJson(json).getAsJsonObject().get("token").getAsString();
		String mail = jsonConverter.fromJson(json).getAsJsonObject().get("mail").getAsString();
		boolean updateDone = userService.updateToken(token, mail);
		if(updateDone) {
			try {
				resp.getWriter().write(jsonConverter.JSON_OK);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			try {
				resp.getWriter().write(jsonConverter.JSON_ERROR);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	/*@RequestMapping(value = "/user", method = RequestMethod.POST)
	public void getUserByToken(HttpServletRequest req, HttpServletResponse resp) {
		String json = "";
		try {
			String line;
			while((line = req.getReader().readLine()) != null)
				json += line;
		} catch (Exception e) {
			e.printStackTrace();
		}
		String token = jsonConverter.fromJson(json).getAsJsonObject().get("token").getAsString();
		User user = userService.getUserByToken(token);
		if(user != null) {
			try {
				resp.getWriter().write(jsonConverter.toJson(user));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			try {
				resp.getWriter().write(jsonConverter.JSON_ERROR);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}*/
	
	
}
