package com.example.demo.role.service;


import com.example.demo.commondata.GenericService;
import com.example.demo.role.model.Role;

public interface RoleService extends GenericService<Role, Long> {

	Role update(Role role, Long id);

}
