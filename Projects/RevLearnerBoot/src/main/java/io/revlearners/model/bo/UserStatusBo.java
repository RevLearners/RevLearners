package io.revlearners.model.bo;

public class UserStatusBo {

	private Long id;
	private String name;

    public UserStatusBo(String name) {
        this.name = name;
    }

    public UserStatusBo(Long id) {
        this.id = id;
    }

    public UserStatusBo(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public UserStatusBo() {}

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
