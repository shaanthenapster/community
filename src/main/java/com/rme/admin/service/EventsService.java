package com.rme.admin.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rme.admin.dao.EventsDao;
import com.rme.admin.dto.EventsDto;
import com.rme.admin.model.Events;

@Service
public class EventsService {

	@Autowired
	EventsDao dao;

	@Transactional
	public Events addEvents(EventsDto dto) throws Exception {
		try {
			Events events = new Events();
			events.setEventImageUrl(dto.getEventImageUrl());
			events.setGuestSpeaker(dto.getGuestSpeaker());
			events.setSubject(dto.getSubject());
			events.setTittle(dto.getTittle());
			events.setVenue(dto.getVenue());
			return dao.addEvents(events);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error in saving events");
		}

	}

	@Transactional
	public List<Events> getAllEvents() {
		return dao.showAllEvents();
	}

}
