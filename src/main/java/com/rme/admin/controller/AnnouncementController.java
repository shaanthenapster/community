package com.rme.admin.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import com.rme.admin.dto.AnnouncementRequestDto;
import com.rme.admin.dto.ErrorResponseDto;
import com.rme.admin.dto.SuccessResponseDto;
import com.rme.admin.model.Announcements;
import com.rme.admin.service.AnnouncementService;

@RestController
@RequestMapping("/admin")
public class AnnouncementController {

	@Autowired
	AnnouncementService service;

	@PostMapping(value = "addAnnouncements")
	ResponseEntity<Object> addEvents(HttpSession httpSession, @RequestBody AnnouncementRequestDto dto,
			WebRequest request) {

		try {
			System.out.println(dto);
			service.addAnnouncements(dto);
			SuccessResponseDto successResponseDto = new SuccessResponseDto();
			successResponseDto.getMsg().add("Event added Successfully");
			return ResponseEntity.ok().body(successResponseDto);

		} catch (Exception e) {
			ErrorResponseDto er = new ErrorResponseDto();
			er.getMsg().add("Event failed to save");
			return ResponseEntity.badRequest().body(er);
		}
	}

	@GetMapping(value = "showAllAnnouncements")
	ResponseEntity<Object> showAnnouncements(HttpSession httpSession, WebRequest request) {

		try {
			List<Announcements> announcements = service.getAllAnnouncements();
			System.out.println(announcements);
			return ResponseEntity.ok().body(announcements);
		} catch (Exception e) {
			ErrorResponseDto er = new ErrorResponseDto();
			er.getMsg().add("failed to retrive announcements");
			return ResponseEntity.badRequest().body(er);
		}
	}

}
