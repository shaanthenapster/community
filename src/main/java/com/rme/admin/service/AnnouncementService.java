package com.rme.admin.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rme.admin.dao.AnnouncementDao;
import com.rme.admin.dto.AnnouncementRequestDto;
import com.rme.admin.model.Announcements;
import com.rme.admin.model.Events;

@Service
public class AnnouncementService {

	@Autowired
	AnnouncementDao announcementDao;

	@Transactional
	public Announcements addAnnouncements(AnnouncementRequestDto announcementrequestdto) throws Exception {

		Announcements announcements = new Announcements();
		try {
			announcements.setTittle(announcementrequestdto.getTittle());
			announcements.setSubject(announcementrequestdto.getSubject());
			return announcementDao.addAnnouncements(announcements);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error in saving events");
		}

	}

	@Transactional
	public List<Announcements> getAllAnnouncements() {
		return announcementDao.showAllAnnouncements();
	}

}
