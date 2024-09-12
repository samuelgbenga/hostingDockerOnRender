package uk.samuel.hostingdocker.service;

import uk.samuel.hostingdocker.entity.Person;

import java.util.List;

public interface PersonService {

    String addNewPerson(String name);

    List<Person> getAllPerson();
}
