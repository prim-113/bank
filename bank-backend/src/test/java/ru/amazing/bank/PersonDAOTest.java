package ru.amazing.bank;

import org.jooq.DSLContext;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.amazing.bank.dao.PersonDAO;
import ru.amazing.bank.entity.Person;
import ru.amazing.bank.jooq.Tables;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/jooq-spring.xml"})
public class PersonDAOTest {

    @Autowired
    PersonDAO personDAO;

    @Autowired
    DSLContext dls;

    @After
    public void deleteAll() {
        dls.delete(Tables.PERSON).execute();
    }

    @Test
    public void testAdd() {

        Person p = new Person();
        p.setName("some name");
        p.setSurname("some surname");
        p.setPasswordNumber("Password Number");

        personDAO.create(p);

        Assert.assertNotNull(p.getId());
    }
}
