package klase;

public class Sluzba {
	String nazivSluzbe;
	//String rukovodilac;
	String radnoVreme;
	String kabinet;
	String email;
	String telefon;
	public Sluzba(String naziv) {
            nazivSluzbe = naziv;
        }
	public String getNazivSluzbe() {
		return nazivSluzbe;
	}
	public void setNazivSluzbe(String nazivSluzbe) {
		this.nazivSluzbe = nazivSluzbe;
	}
	/*public String getRukovodilac() {
		return rukovodilac;
	}
	public void setRukovodilac(String rukovodilac) {
		this.rukovodilac = rukovodilac;
	}*/
	public String getRadnoVreme() {
		return radnoVreme;
	}
	public void setRadnoVreme(String radnoVreme) {
		this.radnoVreme = radnoVreme;
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
        return nazivSluzbe; //To change body of generated methods, choose Tools | Templates.
    }
	
}
