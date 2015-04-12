package klase;

public class LaboratorijaCentar {
	String nazivLabCentra;
	//String rukovodilac;
	String sajt;
	String kabinet;
	String email;
	String telefon;
	/*public String getRukovodilac() {
		return rukovodilac;
	}
	public void setRukovodilac(String rukovodilac) {
		this.rukovodilac = rukovodilac;
	}*/
	public LaboratorijaCentar(String naziv) {
            nazivLabCentra=naziv;
        }
	public String getSajt() {
		return sajt;
	}
	public String getNazivLabCentra() {
		return nazivLabCentra;
	}
	public void setNazivLabCentra(String nazivLabCentra) {
		this.nazivLabCentra = nazivLabCentra;
	}
	public void setSajt(String sajt) {
		this.sajt = sajt;
	}
	public String getKabinet() {
		return kabinet;
	}
	public void setKabinet(String kabinet) {
		this.kabinet = kabinet;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

    @Override
    public String toString() {
        return nazivLabCentra; //To change body of generated methods, choose Tools | Templates.
    }
	 
}
