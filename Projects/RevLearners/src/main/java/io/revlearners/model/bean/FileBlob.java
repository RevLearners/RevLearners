package io.revlearners.model.bean;

import javax.persistence.*;

@Entity
@Table(name = "file_blob")
public class FileBlob {

    @Id
    @Column(name = "blob_id")
    @SequenceGenerator(name = "seq_gen_blob", sequenceName = "seq_blob")
    @GeneratedValue(generator = "seq_gen_blob", strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_size")
    private long file_size;

    @Lob
    @Column(name = "blob_contents")
    private Byte[] contents;

    @ManyToOne
    @JoinColumn(name = "mime_id")
    private MimeType mimeType;

    public FileBlob() {}

    public FileBlob(String fileName, long file_size, MimeType mimeType) {
        this.fileName = fileName;
        this.file_size = file_size;
        this.mimeType = mimeType;
    }

    public FileBlob(String fileName, long file_size, Byte[] contents, MimeType mimeType) {
        this.fileName = fileName;
        this.file_size = file_size;
        this.contents = contents;
        this.mimeType = mimeType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getFile_size() {
        return file_size;
    }

    public void setFile_size(long file_size) {
        this.file_size = file_size;
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
