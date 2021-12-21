package com.example.demo.staff.service;

import com.example.demo.commondata.GenericService;
import com.example.demo.staff.model.AddManagerDto;
import com.example.demo.staff.model.Manager;
import com.example.demo.staff.model.UpdateManagerDto;

public interface ManagerService extends GenericService<Manager, Long> {

	Manager save(AddManagerDto dto);

	Manager update(UpdateManagerDto dto, long id);

}
