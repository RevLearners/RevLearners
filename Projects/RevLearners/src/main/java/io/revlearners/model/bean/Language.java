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
	@SequenceGenerator(sequenceName="LANGUAGE_SEQ", name="LANGUAGE_SEQ")
	@GeneratedValue(generator="LANGUAGE_SEQ", strategy=GenerationType.SEQUENCE)
	private int languageId;
	
	@Column(name="LANGUAGE_NAME")
	private int languageName;

	public Language(int languageId, int languageName) {
		super();
		this.languageId = languageId;
		this.languageName = languageName;
	}
	
	public Language() {

	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public int getLanguageName() {
		return languageName;
	}

	public void setLanguageName(int languageName) {
		this.languageName = languageName;
	}

	@Override
	public String toString() {
		return "Language [languageId=" + languageId + ", languageName=" + languageName + "]";
	}

}
