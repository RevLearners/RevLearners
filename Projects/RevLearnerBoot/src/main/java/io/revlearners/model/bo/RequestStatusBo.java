package io.revlearners.model.bo;

import io.revlearners.util.commons.configs.Constants;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public class RequestStatusBo {

    private Long id;
    private String name;

    public RequestStatusBo() {
    }

    public RequestStatusBo(Long id, String name) {
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
