package bancomat;

//cream elementele din insiruire
//bancnota 10

public class Bancnota10 implements Bancnote{
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
		if(summ.getSumm(user, atm) >= 10) {
			int num = summ.getSumm(user, atm)/10;
			int nrBancnote = maxNrBancnote - num;
			if (nrBancnote >= 0) {
				int remainder = summ.getSumm(user, atm) % 10;
				System.out.println("Dispensing "+ num +" 10 note(s)");
				if(remainder !=0) this.chain.dispense(new SumaCeruta(remainder));	
			}
			else {
				int diference = nrBancnote * (-1) * 10;
				int remainder = summ.getSumm(user, atm) % 10 + diference;
				System.out.println("Dispensing "+ maxNrBancnote +" 10 note(s)");
				if(remainder !=0) this.chain.dispense(new SumaCeruta(remainder));
			}

		}
		else{
			this.chain.dispense(summ);
		}
	}

}