package com.ivoronline.springboot_db_datasource_savedifferententitiesindifferentschemas.schema1.repository;

import com.ivoronline.springboot_db_datasource_savedifferententitiesindifferentschemas.schema1.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> { }
