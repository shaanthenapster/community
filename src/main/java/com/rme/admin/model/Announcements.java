package com.rme.admin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Columns;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "announcements")
public class Announcements {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int announceId;
	@Column(nullable = true)
	private String Tittle;
	@Column(nullable = true)
	private String Subject;
	@Column(nullable = true)
	private String announcements;
	
}
