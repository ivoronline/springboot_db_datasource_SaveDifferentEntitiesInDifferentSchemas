package com.ivoronline.springboot_db_datasource_savedifferententitiesindifferentschemas.schema2.repository;

import com.ivoronline.springboot_db_datasource_savedifferententitiesindifferentschemas.schema2.entity.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Integer> { }
