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
