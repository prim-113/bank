package ru.amazing.bank.entity.mapper;

import org.jooq.RecordMapper;
import ru.amazing.bank.entity.BankAccount;
import ru.amazing.bank.entity.Person;
import ru.amazing.bank.jooq.tables.records.BankaccountRecord;

public class BankAccountMapper implements RecordMapper<BankaccountRecord, BankAccount> {

    @Override
    public BankAccount map(BankaccountRecord r) {
        BankAccount b = new BankAccount();
        b.setId(r.getId());
        b.setBankAccountNumber(r.getBankaccountnumber());

        if (r.getPerson() != null) {
            b.setPerson(new Person());
            b.getPerson().setId(r.getPerson());
        }

        return b;
    }
}