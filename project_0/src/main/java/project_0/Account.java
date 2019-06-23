package project_0;

public class Account {
	private int balance = 0;
	private int accountNumber;
	private static int generateAccountNum = 1000000;

	public Account() {
		accountNumber = generateAccountNum++;
	}

	public Account(int balance, int accountNumber) {
		super();
		this.balance = balance;
		this.accountNumber = accountNumber;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void deposit(int amount) {
		if (amount >= 0) {
			balance += amount;
			System.out.println("You deposited $ " + amount);
			System.out.println("Now, your balance is: $ " + balance);
		} else {
			System.err.println("You entered the wrong number. Please, enter the positive number only");
		}
	}
	
	public void withdraw(int amount) {
		if (amount >= 0) {
			balance -= amount;
			System.out.println("You withdraw $ " + amount);
			System.out.println("Now, your balance is: $ " + balance);
		} else if (amount > balance) {
			System.err.println("You don't have enough money to withdraw this amount of money. Please, enter the valid number.");
		} else {
			System.err.println("You entered the wrong number. Please, enter the positive number only");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountNumber;
		result = prime * result + balance;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountNumber != other.accountNumber)
			return false;
		if (balance != other.balance)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Account [balance=" + balance + ", accountNumber=" + accountNumber + "]";
	}

}
