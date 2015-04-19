/**
 * This class is generated by jOOQ
 */
package ru.amazing.bank.jooq.tables.records;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.5.4"
	},
	comments = "This class is generated by jOOQ"
)
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class BankaccountRecord extends org.jooq.impl.UpdatableRecordImpl<ru.amazing.bank.jooq.tables.records.BankaccountRecord> implements org.jooq.Record3<java.lang.Integer, java.lang.Integer, java.lang.Integer> {

	private static final long serialVersionUID = 1996009915;

	/**
	 * Setter for <code>bank.bankaccount.id</code>.
	 */
	public void setId(java.lang.Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>bank.bankaccount.id</code>.
	 */
	public java.lang.Integer getId() {
		return (java.lang.Integer) getValue(0);
	}

	/**
	 * Setter for <code>bank.bankaccount.bankAccountNumber</code>.
	 */
	public void setBankaccountnumber(java.lang.Integer value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>bank.bankaccount.bankAccountNumber</code>.
	 */
	public java.lang.Integer getBankaccountnumber() {
		return (java.lang.Integer) getValue(1);
	}

	/**
	 * Setter for <code>bank.bankaccount.person</code>.
	 */
	public void setPerson(java.lang.Integer value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>bank.bankaccount.person</code>.
	 */
	public java.lang.Integer getPerson() {
		return (java.lang.Integer) getValue(2);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Record1<java.lang.Integer> key() {
		return (org.jooq.Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record3 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row3<java.lang.Integer, java.lang.Integer, java.lang.Integer> fieldsRow() {
		return (org.jooq.Row3) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row3<java.lang.Integer, java.lang.Integer, java.lang.Integer> valuesRow() {
		return (org.jooq.Row3) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field1() {
		return ru.amazing.bank.jooq.tables.Bankaccount.BANKACCOUNT.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field2() {
		return ru.amazing.bank.jooq.tables.Bankaccount.BANKACCOUNT.BANKACCOUNTNUMBER;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field3() {
		return ru.amazing.bank.jooq.tables.Bankaccount.BANKACCOUNT.PERSON;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value1() {
		return getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value2() {
		return getBankaccountnumber();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value3() {
		return getPerson();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BankaccountRecord value1(java.lang.Integer value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BankaccountRecord value2(java.lang.Integer value) {
		setBankaccountnumber(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BankaccountRecord value3(java.lang.Integer value) {
		setPerson(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BankaccountRecord values(java.lang.Integer value1, java.lang.Integer value2, java.lang.Integer value3) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached BankaccountRecord
	 */
	public BankaccountRecord() {
		super(ru.amazing.bank.jooq.tables.Bankaccount.BANKACCOUNT);
	}

	/**
	 * Create a detached, initialised BankaccountRecord
	 */
	public BankaccountRecord(java.lang.Integer id, java.lang.Integer bankaccountnumber, java.lang.Integer person) {
		super(ru.amazing.bank.jooq.tables.Bankaccount.BANKACCOUNT);

		setValue(0, id);
		setValue(1, bankaccountnumber);
		setValue(2, person);
	}
}
