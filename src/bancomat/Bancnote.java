package bancomat;

public interface Bancnote {
// se creaza interfata ce va contine 2 metode
// prima defineste urmatorul element din inlanturie
// a doua proceseaza cererea userului	

	void setNextInChain(Bancnote nextInChain); 
	
// daca nu poate va trimite la urmatorul element din sir
// fiecare implementare a Bancnote va incerca sa proceseze complet cererea
	
	void dispense(SumaCeruta summ); // procesarea se opreste cand suma ceruta este complet dispensata
}


