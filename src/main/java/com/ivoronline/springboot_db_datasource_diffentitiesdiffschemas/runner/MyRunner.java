package com.ivoronline.springboot_db_datasource_diffentitiesdiffschemas.runner;

import com.ivoronline.springboot_db_datasource_diffentitiesdiffschemas.schema1.entity.Person;
import com.ivoronline.springboot_db_datasource_diffentitiesdiffschemas.schema1.repository.PersonRepository;
import com.ivoronline.springboot_db_datasource_diffentitiesdiffschemas.schema2.entity.Address;
import com.ivoronline.springboot_db_datasource_diffentitiesdiffschemas.schema2.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

  //PROPERTIES
  @Autowired PersonRepository  personRepository;
  @Autowired AddressRepository addressRepository;

  //=========================================================================================================
  // INSERT RECORDS
  //=========================================================================================================
  @Override
  public void run(String... args) {
    personRepository.save (new Person (0, "John"  , 20         ));
    addressRepository.save(new Address(0, "London", "Picadilly"));
  }

}
