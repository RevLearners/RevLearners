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
@Table (name="LANGUAGE")
public class Language implements Serializable{
	private static final long serialVersionUID = -7336698542678175301L;
	
	@Id
	@Column (name="LANGUAGE_ID")
	@SequenceGenerator(sequenceName="LANG_SEQ", name="LANG_SEQ")
	@GeneratedValue(generator="LANG_SEQ", strategy=GenerationType.SEQUENCE)
	private int languageId;
	
	@Column(name="LANG_NAME")
	private String langName;

	public Language(int languageId, String langName) {
		super();
		this.languageId = languageId;
		this.langName = langName;
	}
	
	public Language() {

	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public String getLangName() {
		return langName;
	}

	public void setLangName(String langName) {
		this.langName = langName;
	}

	@Override
	public String toString() {
		return "Language [languageId=" + languageId + ", langName=" + langName + "]";
	}	

}
