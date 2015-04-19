package ru.amazing.bank.entity;

public class BankAccount {
    private Integer id;
    private Integer bankAccountNumber;
    private Person person;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(Integer bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
