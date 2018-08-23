package com.rme.admin.dao;

import java.util.List;
import com.rme.admin.model.Events;

public interface EventsDao{
	
    public Events addEvents(Events events);
   
    public List<Events> showAllEvents();
  
}
