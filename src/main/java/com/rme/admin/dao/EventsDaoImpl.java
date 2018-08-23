package com.rme.admin.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rme.admin.model.Events;

@Repository
public class EventsDaoImpl implements EventsDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public Events addEvents(Events events) {
		getCurrentSession().save(events);
		return events;
	}

	public List<Events> showAllEvents() {
		List<Events> events = getCurrentSession().createQuery("from Events").list();
		return events;
	}
}
