package com.gilbarco.controller;


import java.util.Date;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.gilbarco.utils.TimestampUtils;

@CrossOrigin
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/gilbarco")
public class GilbarcoController {

	private static final Logger logger = Logger.getLogger(GilbarcoController.class.getName());
	
	private static int COUNTER = 0;
	
	@RequestMapping("/")
	String home() {
		return "Welcome to Gilbarco!!!";
	}

	@RequestMapping(value="/timestamp", method=RequestMethod.GET)
	public @ResponseBody JsonNode getTimestamp(HttpServletRequest request) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			ObjectNode jsonNode =  mapper.createObjectNode();
			jsonNode.put("timestamp", TimestampUtils.getISO8601StringForCurrentDate());
			jsonNode.put("calls",new Integer(COUNTER++));
			
			
			logger.info("jsonNode data : " + jsonNode);
			logger.info("request ip : " + request.getRemoteAddr());
			
			return jsonNode;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}

