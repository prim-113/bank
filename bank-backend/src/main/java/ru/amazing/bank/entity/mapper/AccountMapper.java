package ru.amazing.bank.entity.mapper;

import org.jooq.RecordMapper;
import ru.amazing.bank.entity.Account;
import ru.amazing.bank.entity.BankAccount;
import ru.amazing.bank.jooq.tables.records.AccountRecord;

public class AccountMapper implements RecordMapper<AccountRecord, Account> {

    @Override
    public Account map(AccountRecord r) {
        Account a = new Account();
        a.setId(r.getId());
        a.setLogin(r.getLogin());
        a.setPasswordHash(r.getPasswordhash());

        if (r.getBankaccount() != null) {
            a.setBankAccount(new BankAccount());
            a.getBankAccount().setId(r.getBankaccount());
        }

        return a;
    }
}
