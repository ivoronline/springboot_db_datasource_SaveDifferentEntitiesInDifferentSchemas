package com.ivoronline.springboot_db_datasource_diffentitiesdiffschemas.schema1.repository;

import com.ivoronline.springboot_db_datasource_diffentitiesdiffschemas.schema1.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> { }
