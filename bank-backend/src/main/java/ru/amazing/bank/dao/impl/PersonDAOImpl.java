package ru.amazing.bank.dao.impl;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import ru.amazing.bank.dao.PersonDAO;
import ru.amazing.bank.entity.Person;
import ru.amazing.bank.entity.mapper.PersonMapper;
import ru.amazing.bank.jooq.tables.records.PersonRecord;

import static ru.amazing.bank.jooq.Tables.PERSON;

public class PersonDAOImpl implements PersonDAO {
    @Autowired
    DSLContext dsl;

    @Override
    public Person get(int id) {
        PersonRecord r =
                dsl.selectFrom(PERSON)
                        .where(PERSON.ID.equal(id))
                        .fetchOne();
        return new PersonMapper().map(r);
    }

    @Override
    public void create(Person bean) {
        PersonRecord r =
                dsl.insertInto(PERSON)
                        .set(PERSON.NAME, bean.getName())
                        .set(PERSON.SURNAME, bean.getSurname())
                        .set(PERSON.PASSWORDNUMBER, bean.getPasswordNumber())
                        .returning(PERSON.ID)
                        .fetchOne();
        bean.setId(r.getId());
    }

    @Override
    public void update(Person bean) {
        dsl.update(PERSON)
                .set(PERSON.NAME, bean.getName())
                .set(PERSON.SURNAME, bean.getSurname())
                .set(PERSON.PASSWORDNUMBER, bean.getPasswordNumber())
                .where(PERSON.ID.eq(bean.getId()))
                .execute();
    }

    @Override
    public void delete(int id) {
        dsl.delete(PERSON)
                .where(PERSON.ID.eq(id))
                .execute();
    }
}