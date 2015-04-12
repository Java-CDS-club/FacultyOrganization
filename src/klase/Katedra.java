package klase;

import java.util.LinkedList;

public class Katedra {
	/*String sefKatedre;
	String zamenikSefa;*/
        
	String nazivKatedre;
	LinkedList<LaboratorijaCentar> laboratorije;
        public Katedra(String naziv) {
            nazivKatedre=naziv;
        }
	public String getNazivKatedre() {
		return nazivKatedre;
	}
	public void setNazivKatedre(String nazivKatedre) {
		this.nazivKatedre = nazivKatedre;
	}
	public LinkedList<LaboratorijaCentar> getLaboratorije() {
		return laboratorije;
	}
	public void setLaboratorije(LinkedList<LaboratorijaCentar> laboratorije) {
		this.laboratorije = laboratorije;
	}

    @Override
    public String toString() {
        return nazivKatedre; //To change body of generated methods, choose Tools | Templates.
    }
	
}
