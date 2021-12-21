package com.example.demo.role.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.commondata.GenericServiceImpl;
import com.example.demo.role.model.Role;
import com.example.demo.role.repository.RoleRepository;

@Service
public class RoleServiceImpl extends GenericServiceImpl<Role, Long> implements RoleService {
	@Autowired
	private RoleRepository repo;

	@Override
	public Role update(Role role, Long id) {
		try {
			Role updatedRole = repo.getById(id);
			updatedRole.setRoleName(role.getRoleName());
			updatedRole.setDescription(role.getDescription());

			return repo.save(updatedRole);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}

	}

}
