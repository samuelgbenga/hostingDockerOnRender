package uk.samuel.hostingdocker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.samuel.hostingdocker.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

    boolean existsByName(String name);
}
