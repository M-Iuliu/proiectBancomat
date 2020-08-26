package bancomat;

public class SumaCeruta {
// se va stoca informatia ceruta de user, care ulterior va fi folosita in implementare	

	private int summ;
	private User user;
	private Bancomat atm;
	
	public SumaCeruta(int summ) {
		this.summ = summ;
	}

	public int getSumm(User user, Bancomat atm) {
		return this.summ;
	}

}
