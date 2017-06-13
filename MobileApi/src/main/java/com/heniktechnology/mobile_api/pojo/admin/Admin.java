package com.heniktechnology.mobile_api.pojo.admin;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.heniktechnology.mobile_api.pojo.admin.permission.Permission;

@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer adminId;

	private String adminName;

	private String adminLoginId;

	private String adminPassoword;

	private String note;
	
	@OneToMany
	private List<Permission> permissions ;

	public Admin(Integer adminId, String adminName, String adminLoginId, String adminPassoword, String note,
			List<Permission> permissions) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminLoginId = adminLoginId;
		this.adminPassoword = adminPassoword;
		this.note = note;
		this.permissions = permissions;
	}
	
	

	public Admin(String adminName, String adminLoginId, String adminPassoword, String note,
			List<Permission> permissions) {
		super();
		this.adminName = adminName;
		this.adminLoginId = adminLoginId;
		this.adminPassoword = adminPassoword;
		this.note = note;
		this.permissions = permissions;
	}



	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminLoginId() {
		return adminLoginId;
	}

	public void setAdminLoginId(String adminLoginId) {
		this.adminLoginId = adminLoginId;
	}

	public String getAdminPassoword() {
		return adminPassoword;
	}

	public void setAdminPassoword(String adminPassoword) {
		this.adminPassoword = adminPassoword;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}



	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminLoginId=" + adminLoginId
				+ ", adminPassoword=" + adminPassoword + ", note=" + note + ", permissions=" + permissions + "]";
	}

	
	
}
