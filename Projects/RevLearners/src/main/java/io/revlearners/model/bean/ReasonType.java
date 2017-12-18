package io.revlearners.model.bean;

import javax.persistence.*;

@Entity
@Table(name="REASON_TYPE")
public class ReasonType {
	
	@Id
	@Column(name="TYPE_ID")
    @SequenceGenerator(sequenceName = "REASON_TYPE_SEQ", name = "REASON_TYPE_SEQ")
    @GeneratedValue(generator = "REASON_TYPE_SEQ", strategy = GenerationType.SEQUENCE)
	private int typeId;
	
	@Column(name="REASON_TYPE")
	private String type;

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
