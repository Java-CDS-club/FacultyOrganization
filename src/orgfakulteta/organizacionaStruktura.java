/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orgfakulteta;

import connect.javaconnect;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Andreja
 */
public class organizacionaStruktura extends javax.swing.JDialog {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    /**
     * Creates new form organizacionaStruktura
     */
    public organizacionaStruktura(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        conn = javaconnect.ConnectDb();
        popuniCombo();
//        popuniTabelu();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jComboFakulteti = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtxtemail = new javax.swing.JTextField();
        jtxtNaziv = new javax.swing.JTextField();
        jtxtTelefon = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtxtWebSite = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jtxtOsoba1 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox();
        jtxtOsoba2 = new javax.swing.JTextField();
        jComboKategorija = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblOrg = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jbtnDodajNovi = new javax.swing.JButton();
        jbtnIzmeni = new javax.swing.JButton();
        jbtnObrisi = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pripada fakultetu:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 51, 51))); // NOI18N

        jComboFakulteti.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        jComboFakulteti.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboFakultetiItemStateChanged(evt);
            }
        });
        jComboFakulteti.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboFakultetiPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jComboFakulteti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboFakultetiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboFakulteti, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboFakulteti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Izvrsite izmenu:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 51, 102))); // NOI18N

        jLabel7.setText("Pripada kategoriji:");

        jLabel8.setText("E-mail:");

        jtxtemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtemailActionPerformed(evt);
            }
        });

        jLabel9.setText("Telefon:");

        jLabel6.setText("Naziv organizacije:");

        jtxtWebSite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtWebSiteActionPerformed(evt);
            }
        });

        jLabel4.setText("Web site:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nastavnik", "Šef", "Zamenik šefa" }));
        jComboBox1.setToolTipText("Odabir osobe");
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Asistent", "Saradnik", "Sekretar" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jComboKategorija.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "Savet fakulteta", "Dekanski kolegijum", "Nastavnici", "Katedre", "Laboratorije i centri", "Sluzbe" }));
        jComboKategorija.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboKategorijaPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel4))
                        .addGap(86, 86, 86)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtWebSite, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                            .addComponent(jtxtTelefon)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboKategorija, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel6))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtxtemail, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                            .addComponent(jtxtOsoba1)
                            .addComponent(jtxtOsoba2)
                            .addComponent(jtxtNaziv, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboKategorija, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtOsoba1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtOsoba2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtWebSite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Organizaciona struktura", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 51, 51))); // NOI18N

        jtblOrg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtblOrg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblOrgMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jtblOrgMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtblOrgMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtblOrg);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(158, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(" "));

        jbtnDodajNovi.setText("Unos novog");
        jbtnDodajNovi.setToolTipText("Unesite novi fakultet");
        jbtnDodajNovi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDodajNoviActionPerformed(evt);
            }
        });

        jbtnIzmeni.setText("Izmenite");
        jbtnIzmeni.setToolTipText("Izmenite selektovana polja");
        jbtnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnIzmeniActionPerformed(evt);
            }
        });

        jbtnObrisi.setText("Obrisite");
        jbtnObrisi.setToolTipText("Obrisite selektovana polja");
        jbtnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnObrisiActionPerformed(evt);
            }
        });

        jButton2.setText("Obrisite polja");
        jButton2.setToolTipText("Obrisite selektovana polja");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jbtnDodajNovi, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jbtnIzmeni, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jbtnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnDodajNovi)
                    .addComponent(jbtnIzmeni))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnObrisi)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtemailActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jtblOrgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblOrgMouseClicked
        try {
            int row = jtblOrg.getSelectedRow();
            String klik = (jtblOrg.getModel().getValueAt(row, 0).toString());
            String sql = "select * from orgStruktura where NazivOrg ='" + klik + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                String dodaj1 = rs.getString("NazivOrg");
                jtxtNaziv.setText(dodaj1);

//                String dodaj2 = rs.getString("Kategorija");
//                jtxtKategorija.setText(dodaj2);
                String dodaj3 = rs.getString("Osoba1");
                jtxtOsoba1.setText(dodaj3);
                String dodaj4 = rs.getString("Osoba2");
                jtxtOsoba2.setText(dodaj4);
                String dodaj5 = rs.getString("Email");
                jtxtemail.setText(dodaj5);
                String dodaj6 = rs.getString("Website");
                jtxtWebSite.setText(dodaj6);
                String dodaj7 = rs.getString("Telefon");
                jtxtTelefon.setText(dodaj7);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_jtblOrgMouseClicked

    private void jtxtWebSiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtWebSiteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtWebSiteActionPerformed
//    public int nadjiBrojUcombo() {
//        int item = jComboFakulteti.getItemCount();
//        int a = 1;
//        for (int i = 1; i <= item; i++) {
//
//            if (a == i) {
//                a = i;
//                a++;
//            }
//
//        }return a;
//    }
    private void jbtnDodajNoviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDodajNoviActionPerformed
//       int idprovider = Integer.parseInt((String)jComboFakulteti.getSelectedItem());
/*
id
NazivOrg
Kategorija
Osoba1
Osoba2
Email
Website
Telefon
FakultetID
   */
        try {
            String sql = "Insert into orgstruktura(NazivOrg,Osoba1,Osoba2,Email,Website,Telefon,Fakultet,KategorijaID) values (?,?,?,?,?,?,?,?)";
            pst = conn.prepareStatement(sql);
            String kategorija = jComboKategorija.getSelectedItem().toString();
            String fakultet = jComboFakulteti.getSelectedItem().toString();
            pst.setString(1, jtxtNaziv.getText());
            pst.setString(2, jtxtOsoba1.getText());
            pst.setString(3, jtxtOsoba2.getText());
            pst.setString(4, jtxtemail.getText());
            pst.setString(5, jtxtWebSite.getText());
            pst.setString(6, jtxtTelefon.getText());
            pst.setString(7, fakultet);
            pst.setInt(8, jComboKategorija.getSelectedIndex());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Uspesno ste dodali!");
            String sql2 = "insert into kategorija(Naziv,KategorijaID,Fakultet) values (?,?,?)";
            pst = conn.prepareStatement(sql2);
            pst.setString(1, kategorija);
            pst.setInt(2, jComboKategorija.getSelectedIndex());
            pst.setString(3, fakultet);
            pst.execute();
//            String sql2 = "Insert into kategorija(Naziv,FakultetID) values (?,?)";
//            pst = conn.prepareStatement(sql2);
//           pst.setString(1, kategorija);
//            pst.setInt(2, jComboFakulteti.getSelectedIndex());
//            pst.execute();
//            JOptionPane.showMessageDialog(null, "Uspesno ste dodali!");
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        }
        popuniTabelu();
        //        finally {
        //            try {
        //                rs.close();
        //                pst.close();
        //            } catch (Exception e) {
        //            }
        //        }
    }//GEN-LAST:event_jbtnDodajNoviActionPerformed

    private void jbtnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnIzmeniActionPerformed

        try {
            String nazivOrg = jtxtNaziv.getText();
//            String kategorija = jtxtKategorija.getText();
            String kategorija = jComboKategorija.getSelectedItem().toString();
            String osoba1 = jtxtOsoba1.getText();
            String osoba2 = jtxtOsoba2.getText();
            String email = jtxtemail.getText();
            String website = jtxtWebSite.getText();
            String telefon = jtxtTelefon.getText();
            String sql = "update orgStruktura set NazivOrg='" + nazivOrg + "',Kategorija='" + kategorija + "',Osoba1='" + osoba1 + "',Osoba2='" + osoba2 + "',Email='" + email + "',Website='" + website + "',Telefon='" + telefon + "'where NazivOrg='" + nazivOrg + "'";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Uspesno ste izvrsini izmenu!");
            izmeniTabelu();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

//        popuniTabelu();
        //ComboFakulteti.removeAllItems();
        //  popuniTabelu();
        // jtblOrg.removeAll();
        //        popuniTabelu();
        // TODO add your handling code here:

    }//GEN-LAST:event_jbtnIzmeniActionPerformed

    private void jbtnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnObrisiActionPerformed
        int p = JOptionPane.showConfirmDialog(null, "Da li zelite da obrisete?", "Brisanje", JOptionPane.YES_NO_OPTION);
        if (p == 0) {
            String sql = "delete from orgStruktura where NazivOrg=?";
            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1, jtxtNaziv.getText());
                pst.execute();
                JOptionPane.showMessageDialog(null, "Uspesno ste obrisali!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                try {
                    rs.close();
                    pst.close();
                } catch (Exception e) {
                }
            }
            popuniTabelu();
            izbrisiFieldove();
        }

    }//GEN-LAST:event_jbtnObrisiActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        izbrisiFieldove();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboFakultetiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboFakultetiItemStateChanged

        // TODO add your handling code here:
    }//GEN-LAST:event_jComboFakultetiItemStateChanged

    private void jComboFakultetiPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboFakultetiPopupMenuWillBecomeInvisible

    }//GEN-LAST:event_jComboFakultetiPopupMenuWillBecomeInvisible

    private void jComboFakultetiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboFakultetiActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_jComboFakultetiActionPerformed

    private void jtblOrgMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblOrgMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jtblOrgMouseEntered

    private void jtblOrgMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblOrgMousePressed

        // TODO add your handling code here:
    }//GEN-LAST:event_jtblOrgMousePressed

    private void jComboKategorijaPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboKategorijaPopupMenuWillBecomeInvisible
        int item = jComboKategorija.getSelectedIndex();
        String sql = "select * from orgstruktura where KategorijaID =?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, item);
            rs = pst.executeQuery();
            if (rs.next()) {
                String dodaj1 = rs.getString("NazivOrg");
                jtxtNaziv.setText(dodaj1);
//                String dodaj2 = rs.getString("Kategorija");
//                jtxtKategorija.setText(dodaj2);
                String dodaj3 = rs.getString("Osoba1");
                jtxtOsoba1.setText(dodaj3);
                String dodaj4 = rs.getString("Osoba2");
                jtxtOsoba2.setText(dodaj4);
                String dodaj5 = rs.getString("Email");
                jtxtemail.setText(dodaj5);
                String dodaj6 = rs.getString("Website");
                jtxtWebSite.setText(dodaj6);
                String dodaj7 = rs.getString("Telefon");
                jtxtTelefon.setText(dodaj7);
            }
            pst = conn.prepareStatement(sql);
            pst.setInt(1, item);
            rs = pst.executeQuery();
            jtblOrg.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboKategorijaPopupMenuWillBecomeInvisible

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboFakulteti;
    private javax.swing.JComboBox jComboKategorija;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnDodajNovi;
    private javax.swing.JButton jbtnIzmeni;
    private javax.swing.JButton jbtnObrisi;
    private javax.swing.JTable jtblOrg;
    private javax.swing.JTextField jtxtNaziv;
    private javax.swing.JTextField jtxtOsoba1;
    private javax.swing.JTextField jtxtOsoba2;
    private javax.swing.JTextField jtxtTelefon;
    private javax.swing.JTextField jtxtWebSite;
    private javax.swing.JTextField jtxtemail;
    // End of variables declaration//GEN-END:variables
       private void popuniCombo() {
        try {
            String sql = "select * from fakulteti";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String Naziv = rs.getString("Fakultet");
                jComboFakulteti.addItem(Naziv);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
            }
        }
    }

    private void popuniTabelu() {
        try {
            String sql = "select * from orgStruktura";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            jtblOrg.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
            }
        }
    }

    private void izbrisiFieldove() {
        jtxtNaziv.setText("");
//        jtxtKategorija.setText("");
        jtxtOsoba1.setText("");
        jtxtOsoba2.setText("");
        jtxtemail.setText("");
        jtxtWebSite.setText("");
        jtxtTelefon.setText("");
    }

    private void izmeniTabelu() {
        int item = jComboFakulteti.getSelectedIndex();
        String sql = "select * from orgstruktura where FakultetID =?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, item);
            rs = pst.executeQuery();
            jtblOrg.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {
            }
        }
    }
}
