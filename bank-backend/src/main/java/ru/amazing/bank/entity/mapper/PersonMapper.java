package ru.amazing.bank.entity.mapper;

import org.jooq.RecordMapper;
import ru.amazing.bank.entity.Person;
import ru.amazing.bank.jooq.tables.records.PersonRecord;

public class PersonMapper implements RecordMapper<PersonRecord, Person> {

    @Override
    public Person map(PersonRecord r) {
        Person b = new Person();
        b.setId(r.getId());
        b.setName(r.getName());
        b.setSurname(r.getSurname());
        b.setPasswordNumber(r.getPasswordnumber());

        return b;
    }
}