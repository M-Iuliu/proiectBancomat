package bancomat;

public class BancnoteChain {
	public Bancnote c1;
	
	public BancnoteChain() {
// initializam sir
		this.c1 = new Bancnota100();
		Bancnote c2 = new Bancnota50();
		Bancnote c3 = new Bancnota10();
		Bancnote c4 = new Bancnota5();
		Bancnote c5 = new Bancnota1();

// setam legaturile intre elementele sirului
// practic  bancnotele (ca obiecte) formeaza o structura asemanatoare cu un linked list	in cap fiind cea mai mare
// bancnota iar in coada cea mai mica
		c1.setNextInChain(c2);
		c2.setNextInChain(c3);
		c3.setNextInChain(c4);
		c4.setNextInChain(c5);
	}
}
