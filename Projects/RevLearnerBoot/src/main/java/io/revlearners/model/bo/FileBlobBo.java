package io.revlearners.model.bo;

import javax.persistence.*;

import io.revlearners.util.commons.configs.Constants;

import java.io.Serializable;

public class FileBlobBo {

    private Long id;
    private String name;
    private Long size;
    private byte[] contents;
    private MimeTypeBo mimeType;
    
    public FileBlobBo() {}

    public FileBlobBo(String name, Long size, MimeTypeBo mimeType) {
        this.name = name;
        this.size = size;
        this.mimeType = mimeType;
    }

    public FileBlobBo(String name, Long size, byte[] contents, MimeTypeBo mimeType) {
        this.name = name;
        this.size = size;
        this.contents = contents;
        this.mimeType = mimeType;
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

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public byte[] getContents() {
        return contents;
    }

    public void setContents(byte[] contents) {
        this.contents = contents;
    }

    public MimeTypeBo getMimeType() {
        return mimeType;
    }

    public void setMimeType(MimeTypeBo mimeType) {
        this.mimeType = mimeType;
    }
}
