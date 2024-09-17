package uk.samuel.hostingdocker.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.samuel.hostingdocker.entity.Person;
import uk.samuel.hostingdocker.payload.PersonRequestDto;
import uk.samuel.hostingdocker.service.PersonService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonController {
    private final PersonService personService;

    @Value("${app.url.verification}")
    private String verificationUrl;


    @PostMapping()
    public ResponseEntity<String> addNew(@RequestBody PersonRequestDto requestDto){

        String response = personService.addNewPerson(requestDto.getName());

       return ResponseEntity.ok(response);

    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Person>> getAll(){

        return ResponseEntity.ok(personService.getAllPerson());

    }

    @GetMapping("/testing")
    public ResponseEntity<String> testing(){

        return ResponseEntity.ok("Samuel Joseph is A professor (it has been affected) "+ verificationUrl);
    }


}
