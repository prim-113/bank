package ru.amazing.bank.dao.impl;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import ru.amazing.bank.dao.BankAccountDAO;
import ru.amazing.bank.entity.BankAccount;
import ru.amazing.bank.entity.mapper.BankAccountMapper;
import ru.amazing.bank.jooq.tables.records.BankaccountRecord;

import static ru.amazing.bank.jooq.Tables.BANKACCOUNT;

public class BankAccountDAOImpl implements BankAccountDAO {

    @Autowired
    DSLContext dsl;

    @Override
    public BankAccount get(int id) {
        BankaccountRecord r =
                dsl.selectFrom(BANKACCOUNT)
                        .where(BANKACCOUNT.ID.equal(id))
                        .fetchOne();
        return new BankAccountMapper().map(r);
    }

    @Override
    public void create(BankAccount bean) {
        BankaccountRecord r =
                dsl.insertInto(BANKACCOUNT)
                        .set(BANKACCOUNT.BANKACCOUNTNUMBER, bean.getBankAccountNumber())
                        .set(BANKACCOUNT.PERSON, bean.getPerson().getId())
                        .returning(BANKACCOUNT.ID)
                        .fetchOne();
        bean.setId(r.getId());
    }

    @Override
    public void update(BankAccount bean) {
        dsl.update(BANKACCOUNT)
                .set(BANKACCOUNT.BANKACCOUNTNUMBER, bean.getBankAccountNumber())
                .set(BANKACCOUNT.PERSON, bean.getPerson().getId())
                .where(BANKACCOUNT.ID.eq(bean.getId()))
                .execute();
    }

    @Override
    public void delete(int id) {
        dsl.delete(BANKACCOUNT)
                .where(BANKACCOUNT.ID.eq(id))
                .execute();
    }
}
