package ru.amazing.bank.dao.impl;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import ru.amazing.bank.dao.AccountDAO;
import ru.amazing.bank.entity.Account;
import ru.amazing.bank.entity.mapper.AccountMapper;
import ru.amazing.bank.jooq.tables.records.AccountRecord;

import static ru.amazing.bank.jooq.Tables.ACCOUNT;

public class AccountDAOImpl implements AccountDAO {

    @Autowired
    DSLContext dsl;

    @Override
    public Account get(int id) {
        AccountRecord r =
                dsl.selectFrom(ACCOUNT)
                        .where(ACCOUNT.ID.equal(id))
                        .fetchOne();
        return new AccountMapper().map(r);
    }

    @Override
    public void create(Account account) {
        AccountRecord r =
                dsl.insertInto(ACCOUNT)
                        .set(ACCOUNT.LOGIN, account.getLogin())
                        .set(ACCOUNT.BANKACCOUNT, account.getBankAccount().getId())
                        .set(ACCOUNT.PASSWORDHASH, account.getPasswordHash())
                        .returning(ACCOUNT.ID)
                        .fetchOne();
        account.setId(r.getId());
    }

    @Override
    public void update(Account account) {
        dsl.update(ACCOUNT)
                .set(ACCOUNT.LOGIN, account.getLogin())
                .set(ACCOUNT.BANKACCOUNT, account.getBankAccount().getId())
                .set(ACCOUNT.PASSWORDHASH, account.getPasswordHash())
                .where(ACCOUNT.ID.eq(account.getId()))
                .execute();
    }

    @Override
    public void delete(int id) {
        dsl.delete(ACCOUNT)
                .where(ACCOUNT.ID.eq(id))
                .execute();
    }
}
