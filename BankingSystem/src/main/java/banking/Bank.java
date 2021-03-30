package banking;

import java.util.LinkedHashMap;
import java.util.Random;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
	private LinkedHashMap<Long, Account> accounts;
	static int i = 0;
	 static int getNext() {
	        i = i+1;
	        return i;
	    }
	
	Long accNumber;
	Random randInt = new Random();
	
	public Bank() {
		this.accounts = new LinkedHashMap<Long, Account>(); 
		accNumber = (long) randInt.nextInt();
	}

	private Account getAccount(Long accountNumber) {
        return accounts.get(accountNumber);
	}

	public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
		Long l = (long) getNext();
		CommercialAccount cAcc = new CommercialAccount(company, l, pin, startingDeposit);
		accounts.put(l, cAcc);
        return l;
	}

	public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
		Long l = (long) getNext();
		ConsumerAccount cAcc = new ConsumerAccount(person, l, pin, startingDeposit);
		accounts.put(l,cAcc);
		return l;
    }

	public boolean authenticateUser(Long accountNumber, int pin) {
		if(accounts.containsKey(accountNumber)) {
			Account acc = accounts.get(accountNumber);
			return acc.validatePin(pin);
		}
        return false;
	}

	public double getBalance(Long accountNumber) {	
		Account acc = accounts.get(accountNumber);
        return acc.getBalance();
	}

	public void credit(Long accountNumber, double amount) {
		// complete the function
		accounts.get(accountNumber).creditAccount(amount);
		
	}

	public boolean debit(Long accountNumber, double amount) {
        return accounts.get(accountNumber).debitAccount(amount);
	}
}
