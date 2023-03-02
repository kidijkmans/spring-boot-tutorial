package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;

/*
 * Configure the data access service -> @Service or @Component
 */
@Service
public class PersonService {

    private final PersonDao personDao;

    // Inject into the actual constructor / autowiring in constructor -> @Autowired
    // To distinguish -> @Qualifier (+ @Repository in
    // FakePersonDataAccessService.java)
    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPeople() {
        return personDao.selectAllPeople();
    }

}
