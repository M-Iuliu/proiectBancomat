package bancomat;

import java.util.InputMismatchException;
import java.util.Scanner;

public class User {
	
	private String name;
	private int accountBalance;
	private int pin;
	private int mainLoop = 0;
	private int secLoop = 0;
	static Scanner inputBancomat = new Scanner(System.in);
	
	public User() {

	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAccountBalance() {
		return accountBalance;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public void setAccountBalance(int accountMoney) {
		this.accountBalance = accountMoney;
	}
// metoda pentru vizualizare rapida a detelor contului	
	public void getaccountInfo(User user) {
		System.out.println("Account info:");
		System.out.println("Balance: "+user.getAccountBalance());
		System.out.println("User Name: "+user.getName());
		System.out.println("Pin: "+user.getPin());
	}
// creare user, pin si initializarea sumei de bani alocati userului	
	public void createUser() {
		while (mainLoop == 0) {
// generam un username cu loop	pana cand se da un input corect de la tastatura	
		while (secLoop == 0) {
			try {
				System.out.println("Set up Username: ");
				String userName = inputBancomat.nextLine();
				setName(userName);
				secLoop = 1;
			}
			catch(InputMismatchException e) {
				System.out.println("An Error has occured:Invalide imput! Pin not generathed!");
				System.out.println("Enter a valid input!" + "\n");
				inputBancomat.next();
			}
		}
// generam pin cu loop	pana cand se da un input corect de la tastatura		
		System.out.println("Set up a new pin of 4 numbers ranging from 1 to 9: ");
		secLoop = 0;
		while (secLoop == 0) {
			try {
				int newPin = inputBancomat.nextInt();
				setPin(newPin);
				secLoop = 1;
			}
			catch(InputMismatchException e) {
				System.out.println("An Error has occured:Invalide imput! Pin not generathed!");
				System.out.println("Enter a valid input!" + "\n");
				inputBancomat.next();
				
			}
		}
// generam suma de bani disponibila pe cont		
		System.out.println("Initilize account money: ");
		secLoop = 0;
		while (secLoop == 0) {
				try {
					int userMoney = inputBancomat.nextInt();
					setAccountBalance(userMoney);
					secLoop = 1;
				}
				catch(InputMismatchException e) {
					System.out.println("An Error has occured:Invalide imput! Money amount not generathed!");
					System.out.println("Enter a valid input!" + "\n");
					inputBancomat.next();
				}
			}
		System.out.println("User account has been set up!" + "\n");
		mainLoop = 1; 
		
		} // end primary loop
	} // end create user
} // end


