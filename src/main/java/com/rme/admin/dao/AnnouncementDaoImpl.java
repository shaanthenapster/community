package com.rme.admin.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.mapping.CrudMethodsSupportedHttpMethods;
import org.springframework.stereotype.Repository;

import com.rme.admin.model.Announcements;

@Repository
public class AnnouncementDaoImpl implements AnnouncementDao{

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public Announcements addAnnouncements(Announcements announcements) {
		getCurrentSession().save(announcements);
		return announcements;
	}

	@Override
	public List<Announcements> showAllAnnouncements() {
		List<Announcements> announcements = getCurrentSession().createQuery("from Announcements").list();
		return announcements;
	}
}
