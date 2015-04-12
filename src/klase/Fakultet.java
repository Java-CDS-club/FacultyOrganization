/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klase;

import java.util.LinkedList;

/**
 *
 * @author Andreja
 */
public class Fakultet {
    private String ime;
    private LinkedList<Katedra> katedre;
    private LinkedList<LaboratorijaCentar> lab;
    private LinkedList<Sluzba> sluzbe;
    private LinkedList<Uprava> uprave;
    private LinkedList<Ostalo> ostalo;
    
    
    public Fakultet() {
        katedre = new LinkedList<>();
        lab = new LinkedList<>();
        sluzbe = new LinkedList<>();
        uprave = new LinkedList<>();
        ostalo = new LinkedList<>();
    }
    public Fakultet(String ime) {
        this.ime = ime;
        katedre = new LinkedList<>();
        lab = new LinkedList<>();
        sluzbe = new LinkedList<>();
        uprave = new LinkedList<>();
        ostalo = new LinkedList<>();
    }
    
    public LinkedList<Katedra> getKatedre() {
        return katedre;
    }

//    public void setKatedre(LinkedList<Katedra> katedre) {
//        this.katedre = katedre;
//    }

    public LinkedList<LaboratorijaCentar> getLab() {
        return lab;
    }

//    public void setLab(LinkedList<LaboratorijaCentar> lab) {
//        this.lab = lab;
//    }

    public LinkedList<Sluzba> getSluzbe() {
        return sluzbe;
    }

//    public void setSluzbe(LinkedList<Sluzba> sluzbe) {
//        this.sluzbe = sluzbe;
//    }

    public LinkedList<Uprava> getUprave() {
        return uprave;
    }

//    public void setUprave(LinkedList<Uprava> uprave) {
//        this.uprave = uprave;
//    }

    public LinkedList<Ostalo> getOstalo() {
        return ostalo;
    }

//    public void setOstalo(LinkedList<Ostalo> ostalo) {
//        this.ostalo = ostalo;
//    }

    
    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    

    @Override
    public String toString() {
        return ime; //To change body of generated methods, choose Tools | Templates.
    }
    
    public void dodajKatedru(Katedra kat){
        katedre.add(kat);
    }
    
    public void dodajLabCentar(LaboratorijaCentar laboratorijaCentar){
        lab.add(laboratorijaCentar);
    }
    
    public void dodajSluzbu(Sluzba sluzba){
        sluzbe.add(sluzba);
    }
    
    public void dodajUpravu(Uprava up){
        uprave.add(up);
    }
    
    public void dodajOstalo(Ostalo os){
        ostalo.add(os);
    }
    
}
