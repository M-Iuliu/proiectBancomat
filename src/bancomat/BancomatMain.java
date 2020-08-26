package bancomat;
 // main
public class BancomatMain {

	public static void main(String[] args) {
// create user	
	User user = new User();
	user.createUser();
// create Bancomat	
	Bancomat atm = new Bancomat();
	atm.insertCard(user);
	


			} 
	} 

