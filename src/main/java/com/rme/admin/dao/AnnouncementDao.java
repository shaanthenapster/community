package com.rme.admin.dao;


import java.util.List;

import com.rme.admin.model.Announcements;

public interface AnnouncementDao{
	
 
	public Announcements addAnnouncements(Announcements announcements);
	
	public List<Announcements> showAllAnnouncements();
}
