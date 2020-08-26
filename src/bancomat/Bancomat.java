package bancomat;

import java.util.Scanner;

public class Bancomat {
	 
	 private static int totalMoneyAvilable = 0;
	 private static int withdraw, balance;
	 static Scanner inputBancomat = new Scanner(System.in);
	 private static boolean loop1 = false;
	 private static boolean loop2 = false;
	 

// bancomat object	 
	 public Bancomat() {
		 
	 }

// verificam bancnotele ramase
	public int seeAvilableMoney() {
		
		return totalMoneyAvilable; 
		} // end method

// metoda de retragere numerar	
	public void Withdraw(User user) {
	System.out.println("Enter money to be withdrawn:");	
    withdraw = inputBancomat.nextInt();
    balance = user.getAccountBalance();
	BancnoteChain chain = new BancnoteChain();
	chain.c1.dispense(new SumaCeruta(withdraw));
		
    	if(balance >= withdraw){
        balance = balance - withdraw;
        user.setAccountBalance(balance);
        System.out.println("Collect your " + withdraw + " RON");
    	}
    	else{
        System.out.println("Error:Insufficient Balance!");
        System.out.println("Suspending transaction!" + "\n");
    	}
   	} // end method
	
// metoda ce afiseaza suma ramasa a unui Cont
	public void seeBalance(User user) {
		balance = user.getAccountBalance();
		System.out.println("Balance is: "+ balance);
        System.out.println("");
  	} // end method

//metoda pentru inserat card	
	public void insertCard(User user) {
		while (loop1 == false) {
// generam meniu log in			
				System.out.println("Type 1 to exit.");
				System.out.println("Type 2 to perform more opperations.");
				int acces = inputBancomat.nextInt();
				switch(acces) {
				case 1:
					System.exit(0);
					
				case 2:
					
					System.out.println("Enter pin to acces account:");
					int pin = inputBancomat.nextInt();
					
					if(pin != user.getPin()) {
						System.out.println("Invalid pin.");
						System.out.println("Enter a valid pin!");
						inputBancomat.next();
					}
//generam meniul principal						
					else {
						while (loop2 == false) {
						System.out.println("");
						System.out.println("Options Menu:");
						System.out.println("Type 1 for Withdraw");
			            System.out.println("Type 2 for Check Balance");
			            System.out.println("Type 3 for Account Information");
			            System.out.println("Type 4 for EXIT");
			            int cases = inputBancomat.nextInt();
			            switch(cases) 
			            {   
			            case 1:
			            	Withdraw(user);
			                break;          
						case 2:
							seeBalance(user);
			                break;
						case 3:
							user.getaccountInfo(user);
							break;
		                case 4:
		                	loop2 = true; // conditie pentru exit loop
			            }
					} // end secondary loop
				}
			}

		} // end primary loop
			
	} // end card insertion
}// end
