package bancomat;
//cream elementele din insiruire
//bancnota 50

public class Bancnota50 implements Bancnote{
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
		if(summ.getSumm(user, atm) >= 50) {
			int num = summ.getSumm(user, atm)/50;
			int nrBancnote = maxNrBancnote - num;
			if (nrBancnote >= 0) {
				int remainder = summ.getSumm(user, atm) % 50;
				System.out.println("Dispensing "+ num +" 50 note(s)");
				if(remainder !=0) this.chain.dispense(new SumaCeruta(remainder));	
			}
			else {
				int diference = nrBancnote * (-1) * 50;
				int remainder = summ.getSumm(user, atm) % 50 + diference;
				System.out.println("Dispensing "+ maxNrBancnote +" 50 note(s)");
				if(remainder !=0) this.chain.dispense(new SumaCeruta(remainder));
			}

		}
		else{
			this.chain.dispense(summ);
		}
	}

}