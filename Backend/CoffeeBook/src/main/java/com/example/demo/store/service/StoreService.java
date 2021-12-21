package com.example.demo.store.service;


import java.util.List;

import com.example.demo.commondata.GenericService;
import com.example.demo.store.model.AddStoreDto;
import com.example.demo.store.model.Store;
import com.example.demo.store.model.StoreDistrict;
import com.example.demo.store.model.UpdateStoreDto;

public interface StoreService extends GenericService<Store, Long> {

	Store save(AddStoreDto dto);

	Store update(UpdateStoreDto dto, long id);

	List<StoreDistrict> findByDistrict();

}
