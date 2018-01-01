package io.revlearners.model.bo;

public class FriendBo {

	private Long id;
	private String username;
	private Integer mutuals;
	
	public Integer getMutuals() {
		return mutuals;
	}

	public void setMutuals(Integer mutuals) {
		this.mutuals = mutuals;
	}

	public FriendBo(){
		
	}
	
	public FriendBo(Long id, String user, int mutuals) {
		this.id = id;
		this.username = user;
		this.mutuals = mutuals;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

}
