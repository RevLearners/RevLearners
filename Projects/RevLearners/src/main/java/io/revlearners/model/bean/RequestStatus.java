package io.revlearners.model.bean;

import io.revlearners.util.commons.configs.Constants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity(name= Constants.TABLE_REQUEST_STATUS)
public class RequestStatus {

    @Id
    @Column(name=Constants.COLUMN_STATUS_ID)
    private Long id;

    @Column(name=Constants.COLUMN_STATUS_NAME)
    private String name;

    public RequestStatus() {
    }

    public RequestStatus(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
