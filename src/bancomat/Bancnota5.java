package bancomat;

//cream elementele din insiruire
//bancnota 5

public class Bancnota5 implements Bancnote{
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
		if(summ.getSumm(user, atm) >= 5) {
			int num = summ.getSumm(user, atm)/5;
			int nrBancnote = maxNrBancnote - num;
			if (nrBancnote >= 0) {
				int remainder = summ.getSumm(user, atm) % 5;
				System.out.println("Dispensing "+ num +" 5 note(s)");
				if(remainder !=0) this.chain.dispense(new SumaCeruta(remainder));	
			}
			else {
				int diference = nrBancnote * (-1) * 5;
				int remainder = summ.getSumm(user, atm) % 5 + diference;
				System.out.println("Dispensing "+ maxNrBancnote +" 5 note(s)");
				if(remainder !=0) this.chain.dispense(new SumaCeruta(remainder));
			}

		}
		else{
			this.chain.dispense(summ);
		}
	}

}