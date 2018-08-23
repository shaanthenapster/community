package com.rme.admin.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "events")
public class Events{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int eventId;
	@Column(nullable = true)
    private String eventImageUrl;
	@Column(nullable = true)
	private String tittle;
	@Column(nullable = true)
    private String subject;
	@Column(nullable = true)
    private String venue;
	@Column(nullable = true)
    private String guestSpeaker;
}
