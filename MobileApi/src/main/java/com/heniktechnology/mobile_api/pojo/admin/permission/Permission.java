package com.heniktechnology.mobile_api.pojo.admin.permission;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Permission {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long permissionId;
	private String permission;
	
	public Permission(String permission) {
		super();
		this.permission = permission;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	@Override
	public String toString() {
		return "Permission [permissionId=" + permissionId + ", permission=" + permission + "]";
	}
	
	

}
