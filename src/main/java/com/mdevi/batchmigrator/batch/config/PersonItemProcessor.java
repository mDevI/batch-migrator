package com.mdevi.batchmigrator.batch.config;

import com.mdevi.batchmigrator.domain.Employee;
import com.mdevi.batchmigrator.domain.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class PersonItemProcessor implements ItemProcessor<Person, Employee> {

    private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);

    @Override
    public Employee process(final Person person) throws Exception {
        final String firstName = person.getFirstName().toUpperCase();
        final String lastName = person.getLastName().toUpperCase();
        final Integer newSalary = person.getSalary() * 2;


        final Employee transformedPerson = new Employee();
        transformedPerson.setDepartment("Sales");
        transformedPerson.setSalary(newSalary);
        transformedPerson.setName(firstName + " " + lastName);
        log.info("Converting (" + person + ") into (" + transformedPerson + ")");

        return transformedPerson;
    }

}
