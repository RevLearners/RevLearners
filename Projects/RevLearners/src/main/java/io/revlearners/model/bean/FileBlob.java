package io.revlearners.model.bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "FILE_BLOB")
public class FileBlob implements Serializable {

    @Id
    @Column(name = "BLOB_ID")
    @SequenceGenerator(name = "SEQ_GEN_BLOB", sequenceName = "SEQ_BLOB")
    @GeneratedValue(generator = "SEQ_GEN_BLOB", strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "FILE_NAME")
    private String name;

    @Column(name = "FILESIZE")
    private Long size;

    @Lob
    @Column(name = "BLOB_CONTENTS")
    private Byte[] contents;

    @ManyToOne
    @JoinColumn(name = "MIME_ID")
    private MimeType mimeType;

    public FileBlob() {}

    public FileBlob(String name, Long size, MimeType mimeType) {
        this.name = name;
        this.size = size;
        this.mimeType = mimeType;
    }

    public FileBlob(String name, Long size, Byte[] contents, MimeType mimeType) {
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

    public Byte[] getContents() {
        return contents;
    }

    public void setContents(Byte[] contents) {
        this.contents = contents;
    }

    public MimeType getMimeType() {
        return mimeType;
    }

    public void setMimeType(MimeType mimeType) {
        this.mimeType = mimeType;
    }
}
