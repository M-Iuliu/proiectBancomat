package bancomat;

public class Bancnota1 implements Bancnote{
	private Bancnote chain;
	int maxNrBancnote = 100;
	private User user;
	private Bancomat atm;
	
	@Override
	public void setNextInChain(Bancnote nextInChain) {
		this.chain = nextInChain;
	}

	@Override
	public void dispense(SumaCeruta summ) {
		if(summ.getSumm(user, atm) >= 1) {
			int num = summ.getSumm(user, atm)/1;
			int nrBancnote = maxNrBancnote - num;
			if (nrBancnote >= 0) {
				int remainder = summ.getSumm(user, atm) % 1;
				System.out.println("Dispensing "+ num +" 100 note(s)");
				if(remainder !=0) this.chain.dispense(new SumaCeruta(remainder));	
			}
			else {
				int diference = nrBancnote * (-1) * 1;
				int remainder = summ.getSumm(user, atm) % 1 + diference;
				System.out.println("Dispensing "+ maxNrBancnote +" 100 note(s)");
				if(remainder !=0) { 
				System.out.println("ATM has not egough money!");
				System.out.println("Try again laiter.");
				System.exit(0);
				}
			}

		}
		else{
			this.chain.dispense(summ);
		}
	}

}