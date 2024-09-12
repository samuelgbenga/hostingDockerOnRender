package uk.samuel.hostingdocker.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uk.samuel.hostingdocker.entity.Person;
import uk.samuel.hostingdocker.repository.PersonRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService{
    private final PersonRepository repository;

    @Override
    public String addNewPerson(String name) {
        if(repository.existsByName(name)){
            return "User already exist";
        }

       Person newPerson = new Person();

        newPerson.setName(name);

        repository.save(newPerson);

        return name+" has been saved";
    }

    @Override
    public List<Person> getAllPerson() {

        return repository.findAll();
    }
}
