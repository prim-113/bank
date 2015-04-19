package ru.amazing.bank.dao.impl;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import ru.amazing.bank.dao.TransactionDAO;
import ru.amazing.bank.entity.Transaction;
import ru.amazing.bank.entity.mapper.TransactionMapper;
import ru.amazing.bank.jooq.tables.records.TransactionRecord;

import static ru.amazing.bank.jooq.Tables.PERSON;
import static ru.amazing.bank.jooq.Tables.TRANSACTION;

public class TransactionDAOImpl implements TransactionDAO {

    @Autowired
    DSLContext dsl;

    @Override
    public Transaction get(int id) {
        TransactionRecord r =
                dsl.selectFrom(TRANSACTION)
                        .where(TRANSACTION.ID.equal(id))
                        .fetchOne();
        return new TransactionMapper().map(r);
    }

    @Override
    public void create(Transaction bean) {
        TransactionRecord r =
                dsl.insertInto(TRANSACTION)
                        .set(TRANSACTION.BANKCARD, bean.getBankCard().getId())
                        .set(TRANSACTION.TRANSACTIONDATE, new java.sql.Date(bean.getTransactionDate().getTime()))
                        .set(TRANSACTION.AMOUNT, bean.getAmount())
                        .returning(TRANSACTION.ID)
                        .fetchOne();
        bean.setId(r.getId());
    }

    @Override
    public void update(Transaction bean) {
        dsl.update(PERSON)
                .set(TRANSACTION.BANKCARD, bean.getBankCard().getId())
                .set(TRANSACTION.TRANSACTIONDATE, new java.sql.Date(bean.getTransactionDate().getTime()))
                .set(TRANSACTION.AMOUNT, bean.getAmount())
                .where(PERSON.ID.eq(bean.getId()))
                .execute();
    }

    @Override
    public void delete(int id) {
        dsl.delete(TRANSACTION)
                .where(TRANSACTION.ID.eq(id))
                .execute();
    }
}