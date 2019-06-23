package project_0;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.AccountService;

public class Menu {
	
	static List<Customer> list;
	
	Scanner sc = new Scanner(System.in);
	boolean exit;
	Bank bank = new Bank();

	
	public static void main(String[] args) throws Exception {

		
		list = new ArrayList<Customer>();
		try {
			list = AccountService.getAllCustomer();
			System.out.println("this is from db" + list);
		} catch (Exception e) {
			System.out.println("Unable to connect");
			return;
		}
		
		Menu menu = new Menu();
		menu.runMenu();
	}

	public void runMenu() {
		printGreet();
		checkFirstVisit();
		
		System.out.println("Enter the user name: ");
		String username = sc.nextLine();
		System.out.println("Enter the user password: ");
		String password = sc.nextLine();
		
		if (checkLogin(username, password)) {
			exit = false;
			while (!exit) {
				printMenu();
				int choice = selectChoice();
				action(choice);
			}
			printBye();
		} else {
			System.out.println("You entered the wrong information.");
			System.out.println("Please, run this again to retry. Thanks.");
			printBye();
		}
	}

	private void printGreet() {
		System.out.println("*------------------------------------------------------*");
		System.out.println("|                                                      |");
		System.out.println("|         Welcome to Ronald's Bank Application         |");
		System.out.println("|                                                      |");
		System.out.println("*------------------------------------------------------*");
	}
	
	private void printBye() {
		System.out.println("*------------------------------------------------------*");
		System.out.println("|                                                      |");
		System.out.println("|    Thank you for using Ronald's Bank Application     |");
		System.out.println("|                                                      |");
		System.out.println("*------------------------------------------------------*");
	}
	
	private void printMenu() {
		System.out.println("1. Create an Account");
		System.out.println("2. Balance");
		System.out.println("3. Deposit");
		System.out.println("4. Withdraw");
		System.out.println("5. Close an account");
		System.out.println("0. Exit");
	}
	
	private void checkFirstVisit() {

		int answer;
		System.out.println("Are you visiting first time?");
		System.out.println("1. Yes    2. No");
		System.out.println("Please, enter only number: ");
		answer = Integer.parseInt(sc.nextLine());

		exit = false;
		while (!exit) {
			if (answer == 1) {
				createAccount();
				exit = true;
			} else if (answer == 2) {
				exit = true;
			} else {
				System.out.println("You entered the wrong number. Please, choose again.");
			}
		}
	}

	private boolean checkLogin(String username, String password) {
		
//		for(Customer c: list) {
//			if(c.getUser_id().equals(username) && c.getPassword().equals(password)) {
//				return true;
//			}
//		}
//		return false;
		
		return true;
	}

	private void action(int choice) {
		switch (choice) {
		case 1:
			createAccount();
			break;
		case 2:
			balance();
			break;
		case 3:
			makeDeposit();
			break;
		case 4:
			makeWithdraw();
			break;
		case 5:
			closeAccount();
			break;
		case 0:
			exit();
			break;
		default:
			System.out.println("Unexpected Error has occurred.");
			break;
		}
	}

	private void createAccount() {
		
		do {
			int answer;
			System.out.println("Are you Customer? Or, Admin?");
			System.out.println("1. Customer   2. Admin");
			System.out.println("Please, enter the number only");
			answer = Integer.parseInt(sc.nextLine());				
			
			if (answer == 1) {
				createCust();
				exit = true;
			} else if (answer == 2) {
				createAdmin();
				exit = true;
			} else {
				System.out.println("You entered the wrong number.");
			}
		} while (!exit);
	}

	private void createCust() {
		String name;
		int ssn;
		String user_id;
		String password;
		int isAdmin = 0;
		int isActivated = 1;
		
		System.out.println("Enter your full name: ");
		name = sc.nextLine();
		System.out.println("Enter your social security number");
		ssn = Integer.parseInt(sc.nextLine());
		System.out.println("Enter your user_id: ");
		user_id = sc.nextLine();
		System.out.println("Enter your password: ");
		password = sc.nextLine();

		Account acctNum = new Account();
		acctNum.setBalance(0);

		System.out.println("Congratulation! Your account has been activated.");
		System.out.println("Now, you can use banking services.");
		System.out.println("Your Account Number is: " + acctNum.getAccountNumber());
		System.out.println("Your Balance is: $ " + acctNum.getBalance());

		Customer customer = new Customer(user_id, password, name, isAdmin, isActivated, ssn, acctNum);
		bank.addCustomer(customer);
		
		try {
			AccountService.insertCustomer(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void createAdmin() {
		String name;
		int ssn;
		String user_id;
		String password;
		int isAdmin = 1;
		int isActivated = 1;
		
		System.out.println("Enter your full name: ");
		name = sc.nextLine();
		System.out.println("Enter your social security number");
		ssn = Integer.parseInt(sc.nextLine());
		System.out.println("Enter your user_id: ");
		user_id = sc.nextLine();
		System.out.println("Enter your password: ");
		password = sc.nextLine();

		System.out.println("Congratulation! Your account has been activated.");
		System.out.println("Now, you can use banking services.");

		SuperUser superuser = new SuperUser(user_id, password, name, isAdmin, isActivated, ssn);
		bank.addSuperUser(superuser);
	}

	private void balance() {
		int account = selectAccount();
		System.out.println("Your balance is: $ " + bank.getCustomer(account).getAccount().getBalance());
	}

	private void makeDeposit() {

		int amount = 0;
		boolean valid = false;
		int account = selectAccount();
		System.out.println("How much would you like to deposit?");

		while (!valid) {
			try {
				amount = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("You must enter the number only.");
			}
			if (amount > 0)
				valid = true;
			else
				System.out.println("You must put the positive number.");
			System.out.println("Please, enter the amount again");
		}

		bank.getCustomer(account).getAccount().deposit(amount);

	}

	private void makeWithdraw() {

		int amount = 0;
		boolean valid = false;
		int account = selectAccount();
		System.out.println("How much would you like to withdraw?");

		while (!valid) {
			try {
				amount = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("You must enter the number only.");
			}
			if (amount > 0)
				valid = true;
			else
				System.out.println("You must put the positive number.");
			System.out.println("Please, enter the amount again");
		}

		bank.getCustomer(account).getAccount().withdraw(amount);
	}

	private int selectAccount() {
		ArrayList<Customer> cust = bank.getCustomerInfo();
		if (cust.size() <= 0) {
			System.out.println("There is no customer in bank.");
		}
		System.out.println("Select an account: ");
		for (int i = 0; i < cust.size(); i++) {
			System.out.println((i + 1) + ") " + cust.get(i).toString());
		}
		int account = 0;
		System.out.print("Please enter your selection: ");
		try {
			account = Integer.parseInt(sc.nextLine()) - 1;
		} catch (NumberFormatException e) {
			account = -1;
		}
		if (account < 0 || account > cust.size()) {
			System.out.println("Invalid account selected.");
			account = -1;
		}
		return account;

	}

	private void closeAccount() {
		
		
	}

	private void exit() {
		exit = true;
	}

	private int selectChoice() {
		int choice = -1;
		System.out.println("Please, make a selection: ");
		do {
			try {
				choice = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Please, enter the number only");
			}
			if (choice < 0 || choice > 5) {
				System.out.println("The number is out of bound. Please, choose again");
			}
		} while (choice < 0 || choice > 5);
		return choice;
	}

}
