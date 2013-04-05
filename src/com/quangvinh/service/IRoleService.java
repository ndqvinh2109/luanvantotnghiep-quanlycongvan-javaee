package com.quangvinh.service;

import java.util.List;

import com.quangvinh.model.Roles;

public interface IRoleService {
	void saveRoles(Roles roles);
	void updateRoles(Roles roles);
	void deleteRoles(int id);
	List<Roles> getRoles();
	Roles findRoleID(int id);
}
