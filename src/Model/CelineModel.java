/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import klase.Katedra;
import klase.LaboratorijaCentar;
import klase.Ostalo;
import klase.Sluzba;
import klase.Uprava;

/**
 *
 * @author stefan
 */
public class CelineModel extends AbstractTableModel{
    List<Katedra> katedre;
    List<LaboratorijaCentar> laboratorije;
    List<Sluzba> sluzbe;
    List<Uprava> uprave;
    List<Ostalo> ost;

    public CelineModel(List<Katedra> katedre, List<LaboratorijaCentar> laboratorije, List<Sluzba> sluzbe, List<Uprava> uprave, List<Ostalo> ost) {
        this.katedre = katedre;
        this.laboratorije = laboratorije;
        this.sluzbe = sluzbe;
        this.uprave = uprave;
        this.ost = ost;
    }
    
    @Override
    public int getRowCount() {
         return katedre.size()+laboratorije.size()+sluzbe.size()+uprave.size()+ost.size();
    }

    @Override
    public int getColumnCount() {
        return 2; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
