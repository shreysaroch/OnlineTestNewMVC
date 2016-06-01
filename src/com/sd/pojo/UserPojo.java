package com.sd.pojo;

public class UserPojo {
	
	@Override
	public String toString() {
		return "UserPojo [userId=" + userId + ", name=" + name + ", email="
				+ email + ", password=" + password + ", groupId=" + groupId
				+ "]";
	}

	// auto increment primary key
	private Integer userId;
	
	private String name, email, password;
	private Integer groupId; // for join with TestPojo
	
	public UserPojo() {
		super();
	}

	public UserPojo(String name, String email, String password,
			Integer groupId) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.groupId = groupId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	

}
