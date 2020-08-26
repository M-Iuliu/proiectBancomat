package bancomat;
// cream elementele din insiruire
// bancnota 100

public class Bancnota100 implements Bancnote{
	private Bancnote chain;
	int maxNrBancnote = 50;
	private User user;
	private Bancomat atm;
	
	@Override
	public void setNextInChain(Bancnote nextInChain) {
		this.chain = nextInChain;
	}

	@Override
	public void dispense(SumaCeruta summ) {
		if(summ.getSumm(user, atm) >= 100) {
			int num = summ.getSumm(user, atm)/100;
			int nrBancnote = maxNrBancnote - num;
			if (nrBancnote >= 0) {
				int remainder = summ.getSumm(user, atm) % 100;
				System.out.println("Dispensing "+ num +" 100 note(s)");
				if(remainder !=0) this.chain.dispense(new SumaCeruta(remainder));	
			}
			else {
				int diference = nrBancnote * (-1) * 100;
				int remainder = summ.getSumm(user, atm) % 100 + diference;
				System.out.println("Dispensing "+ maxNrBancnote +" 100 note(s)");
				if(remainder !=0) this.chain.dispense(new SumaCeruta(remainder));
			}

		}
		else{
			this.chain.dispense(summ);
		}
	}

}
