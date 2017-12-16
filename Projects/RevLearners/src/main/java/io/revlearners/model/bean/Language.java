package io.revlearners.model.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name="language")
public class Language implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="lang_id")
	@SequenceGenerator(name = "seq_gen_lang", sequenceName = "seq_lang")
	@GeneratedValue(generator="seq_gen_lang", strategy= GenerationType.AUTO)
	private int id;

	@Column(name="lang_name")
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
