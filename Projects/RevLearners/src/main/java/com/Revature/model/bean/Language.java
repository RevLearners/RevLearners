package com.Revature.model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name="LANGUAGE")
public class Language {
	
	@Id
	@Column(name="LANG_ID")
	@SequenceGenerator(name = "seq_gen_lang", sequenceName = "seq_lang")
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	@Column(name="LANG_NAME")
	private String name;
	
	public Language() {
	}

	public Language(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
	
	
	

}
