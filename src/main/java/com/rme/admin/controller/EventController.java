package com.rme.admin.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.rme.admin.dto.EventsDto;
import com.rme.admin.model.Events;
import com.rme.admin.service.EventsService;
import com.rme.admin.dto.*;

@RestController
@RequestMapping("admin")
public class EventController {

	@Autowired
	EventsService eventservice;

	@PostMapping(value = "addEvents")
	ResponseEntity<Object> addEvents(HttpSession httpSession, @RequestBody EventsDto eventsdto, WebRequest request) {

		try {
			System.out.println(eventsdto);
			eventservice.addEvents(eventsdto);
			SuccessResponseDto successResponseDto = new SuccessResponseDto();
			successResponseDto.getMsg().add("Event added Successfully");
			return ResponseEntity.ok().body(successResponseDto);

		} catch (Exception e) {
			ErrorResponseDto dto = new ErrorResponseDto();
			dto.getMsg().add("Event failed to save");
			return ResponseEntity.badRequest().body(dto);
		}
	}

	@GetMapping(value = "showAllEvents")
	ResponseEntity<Object> showEvents(HttpSession httpSession, WebRequest request) {

		try {
			List<Events> events = eventservice.getAllEvents();
			System.out.println(events);
			return ResponseEntity.ok().body(events);
		} catch (Exception e) {
			ErrorResponseDto dto = new ErrorResponseDto();
			dto.getMsg().add("failed to retrive events");
			return ResponseEntity.badRequest().body(dto);
		}
	}
	@RequestMapping(value = "hello" , method = RequestMethod.GET)
	public String hello() {
		return "hello";
	}
}
