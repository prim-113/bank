package ru.amazing.bank.dao.impl;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import ru.amazing.bank.dao.BankCardDAO;
import ru.amazing.bank.entity.BankCard;
import ru.amazing.bank.entity.mapper.BankCardMapper;
import ru.amazing.bank.jooq.tables.records.BankcardRecord;

import static ru.amazing.bank.jooq.Tables.BANKCARD;

public class BankCardDAOImpl implements BankCardDAO {

    @Autowired
    DSLContext dsl;

    @Override
    public BankCard get(int id) {
        BankcardRecord r =
                dsl.selectFrom(BANKCARD)
                        .where(BANKCARD.ID.equal(id))
                        .fetchOne();
        return new BankCardMapper().map(r);
    }

    @Override
    public void create(BankCard bean) {
        BankcardRecord r =
                dsl.insertInto(BANKCARD)
                        .set(BANKCARD.CARDNUMBER, bean.getCardNumber())
                        .set(BANKCARD.BANKACCOUNT, bean.getBankAccount().getId())
                        .set(BANKCARD.BLOCKED, bean.getBlocked())
                        .returning(BANKCARD.ID)
                        .fetchOne();
        bean.setId(r.getId());
    }

    @Override
    public void update(BankCard bean) {
        dsl.update(BANKCARD)
                .set(BANKCARD.CARDNUMBER, bean.getCardNumber())
                .set(BANKCARD.BANKACCOUNT, bean.getBankAccount().getId())
                .set(BANKCARD.BLOCKED, bean.getBlocked())
                .where(BANKCARD.ID.eq(bean.getId()))
                .execute();
    }

    @Override
    public void delete(int id) {
        dsl.delete(BANKCARD)
                .where(BANKCARD.ID.eq(id))
                .execute();
    }
}
