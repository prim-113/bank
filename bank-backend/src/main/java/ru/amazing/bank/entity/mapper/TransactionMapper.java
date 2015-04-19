package ru.amazing.bank.entity.mapper;

import org.jooq.RecordMapper;
import ru.amazing.bank.entity.BankCard;
import ru.amazing.bank.entity.Transaction;
import ru.amazing.bank.jooq.tables.records.TransactionRecord;

public class TransactionMapper implements RecordMapper<TransactionRecord, Transaction> {

    @Override
    public Transaction map(TransactionRecord r) {
        Transaction b = new Transaction();
        b.setId(r.getId());
        b.setAmount(r.getAmount());
        b.setTransactionDate(r.getTransactiondate());

        if (r.getBankcard() != null) {
            b.setBankCard(new BankCard());
            b.getBankCard().setId(r.getBankcard());
        }

        return b;
    }
}