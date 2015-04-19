package ru.amazing.bank.entity.mapper;

import org.jooq.RecordMapper;
import ru.amazing.bank.entity.BankAccount;
import ru.amazing.bank.entity.BankCard;
import ru.amazing.bank.jooq.tables.records.BankcardRecord;

public class BankCardMapper implements RecordMapper<BankcardRecord, BankCard> {

    @Override
    public BankCard map(BankcardRecord r) {
        BankCard b = new BankCard();
        b.setId(r.getId());
        b.setCardNumber(r.getCardnumber());


        if (r.getBlocked() != null) {
            b.setBlocked(r.getBlocked());
        }

        if (r.getBankaccount() != null) {
            b.setBankAccount(new BankAccount());
            b.getBankAccount().setId(r.getBankaccount());
        }

        return b;
    }
}