package com.rme.admin.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EventsDto {
		private int id;
	    private String eventImageUrl;
	    private String tittle;
	    private String subject;
	    private String venue;
	    private String guestSpeaker;
}
