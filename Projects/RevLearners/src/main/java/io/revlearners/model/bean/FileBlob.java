package io.revlearners.model.bean;

import javax.persistence.*;

import io.revlearners.util.commons.configs.Constants;

import java.io.Serializable;
import java.sql.Blob;

@Entity
@Table(name = Constants.TABLE_FILE_BLOB)
public class FileBlob implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5115254825153861311L;

	@Id
    @Column(name = Constants.COLUMN_BLOB_ID)
    @SequenceGenerator(name = "SEQ_GEN_BLOB", sequenceName = "SEQ_BLOB")
    @GeneratedValue(generator = "SEQ_GEN_BLOB", strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = Constants.COLUMN_FILE_NAME)
    private String name;

    @Column(name = Constants.COLUMN_FILESIZE)
    private Long size;

    @Lob
    @Column(name = Constants.COLUMN_BLOB_CONTENTS)
    private Blob contents;

    @ManyToOne
    @JoinColumn(name = Constants.COLUMN_MIME_ID)
    private MimeType mimeType;

    public FileBlob() {}

    public FileBlob(String name, Long size, MimeType mimeType) {
        this.name = name;
        this.size = size;
        this.mimeType = mimeType;
    }

    public FileBlob(String name, Long size, Blob contents, MimeType mimeType) {
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

    public Blob getContents() {
        return contents;
    }

    public void setContents(Blob contents) {
        this.contents = contents;
    }

    public MimeType getMimeType() {
        return mimeType;
    }

    public void setMimeType(MimeType mimeType) {
        this.mimeType = mimeType;
    }
}
