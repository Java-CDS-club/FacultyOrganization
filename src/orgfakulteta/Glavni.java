/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orgfakulteta;

import connect.javaconnect;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import klase.Fakultet;
import klase.Katedra;
import klase.LaboratorijaCentar;
import klase.Ostalo;
import klase.Sluzba;
import klase.Uprava;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author stefan
 */
public class Glavni extends javax.swing.JFrame {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    LinkedList<String> stavke;
    LinkedList<Fakultet> fakulteti;
    LinkedList<JComboBox> kombo;
    LinkedList<JTextField> tekst;
    JTree tree;
    private Fakultet faks;

    /**
     * Creates new form Glavni
     */
    public Glavni() {
        initComponents();
//        faks = new Fakultet();
//        stavke = new LinkedList<>();
//        tekst = new LinkedList<>();
//        fakulteti = new LinkedList<>();
//        fakulteti.add(faks);
//        jTree1.addMouseListener(ml);
        conn = javaconnect.ConnectDb();
        popuniCombo();
        
    }

    private void popuniCombo() {
        try {
            String sql = "select * from fakulteti";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String Naziv = rs.getString("Fakultet");
                jComboFax.addItem(Naziv);
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

    public final void pop_tree() {

        try {  
            String sql = "select * from kategorija";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            ArrayList list = new ArrayList();
//            String faks="select naziv from fakulteti";
            list.add("Organizaciona struktura");

            while (rs.next()) {
                Object value[] = {rs.getString(1), rs.getString(2)};
                list.add(value);
            }
            Object hierarchy[] = list.toArray();
            DefaultMutableTreeNode root = processHierarchy(hierarchy);

            DefaultTreeModel treeModel = new DefaultTreeModel(root);
            jTree1.setModel(treeModel);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @SuppressWarnings("CallToThreadDumpStack")
    public DefaultMutableTreeNode processHierarchy(Object[] hierarchy) {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(hierarchy[0]);
        try {
            int ctrow = 0;
            int i = 0;
            try {
                String item = jComboFax.getSelectedItem().toString();
                String sql = "select Naziv,KategorijaID from kategorija where Fakultet='" +item+ "'";
                pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();

                while (rs.next()) {
                    ctrow = rs.getRow();
                }
                String L1Nam[] = new String[ctrow];
                String L1Id[] = new String[ctrow];
                ResultSet rs1 = pst.executeQuery(sql);
                while (rs1.next()) {
                    L1Nam[i] = rs1.getString("Naziv");
                    L1Id[i] = rs1.getString("KategorijaID");
                    i++;
                }
                DefaultMutableTreeNode child, grandchild;
                for (int childIndex = 0; childIndex < L1Nam.length; childIndex++) {
                    child = new DefaultMutableTreeNode(L1Nam[childIndex]);
                    node.add(child);//add each created child to root
                    String sql2 = "select NazivOrg from orgstruktura where KategorijaID= '" + L1Id[childIndex] + "' and Fakultet='"+ item +"'";
                    ResultSet rs2 = pst.executeQuery(sql2);
                    while (rs2.next()) {
                        grandchild = new DefaultMutableTreeNode(rs2.getString("NazivOrg"));
                        child.add(grandchild);
                        //add each grandchild to each child
                    }
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } catch (Exception e) {
        }

        return (node);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtblItem = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jComboFax = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jBtnObrisi = new javax.swing.JButton();
        jBtnDodaj = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTree1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTree1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTree1);

        jtblItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtblItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblItemMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jtblItem);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Odaberite fakultet:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 51, 51))); // NOI18N

        jComboFax.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboFaxPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboFax, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboFax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 13, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Izvrsite izmenu:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 51, 51))); // NOI18N

        jBtnObrisi.setText("Obrisi");
        jBtnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnObrisiActionPerformed(evt);
            }
        });

        jBtnDodaj.setText("Dodaj");
        jBtnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDodajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBtnDodaj, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnObrisi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtnDodaj)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtnObrisi)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnObrisiActionPerformed
        DefaultTreeModel model = (DefaultTreeModel) jTree1.getModel();
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) jTree1.getLastSelectedPathComponent();
        if (selectedNode.isRoot()) {
            System.out.println("Ne mozete obrisati koren!");
        } else {
            if (selectedNode != null) {
                model.removeNodeFromParent(selectedNode);
            } else {
                System.out.println("Morate selektovati cvor za brisanje");
            }
        }
    }//GEN-LAST:event_jBtnObrisiActionPerformed

    private void jBtnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDodajActionPerformed
        DodajFakultet df = new DodajFakultet(this, true, faks);
        df.setVisible(true);

    }//GEN-LAST:event_jBtnDodajActionPerformed

    private void jTree1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTree1MouseClicked
        
        //        DefaultTreeModel model = (DefaultTreeModel) jTree1.getModel();
        //        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        //        for (int i = 0; i < stavke.size(); i++) {
        //            root.add(new DefaultMutableTreeNode(stavke.get(i)));
        //        }
        //        model.reload();
        // TODO add your handling code here:
    }//GEN-LAST:event_jTree1MouseClicked

    private void jtblItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblItemMouseClicked
        //        try {
            //            int row = jtblItem.getSelectedRow();
            //            String klik = (jtblItem.getModel().getValueAt(row, 0).toString());
            //            String sql = "select * from fakulteti where Naziv ='" + klik + "'";
            //            pst = conn.prepareStatement(sql);
            //            rs = pst.executeQuery();
            //            if (rs.next()) {
                //                String dodaj1 = rs.getString("Naziv");
                //                jtxtNaziv.setText(dodaj1);
                //                String dodaj2 = rs.getString("Dekan");
                //                jtxtDekan.setText(dodaj2);
                //                String dodaj3 = rs.getString("Adresa");
                //                jtxtAdresa.setText(dodaj3);
                //                String dodaj4 = rs.getString("Telefon");
                //                jtxtTelefon.setText(dodaj4);
                //            }
            //        } catch (Exception e) {
            //            JOptionPane.showMessageDialog(null, e);
            //        }finally {
            //            try {
                //                rs.close();
                //                pst.close();
                //            } catch (Exception e) {
                //            }
            //        }
    }//GEN-LAST:event_jtblItemMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void jComboFaxPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboFaxPopupMenuWillBecomeInvisible
       pop_tree();
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboFaxPopupMenuWillBecomeInvisible

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Glavni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Glavni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Glavni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Glavni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Glavni().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnDodaj;
    private javax.swing.JButton jBtnObrisi;
    private javax.swing.JComboBox jComboFax;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTree jTree1;
    private javax.swing.JTable jtblItem;
    // End of variables declaration//GEN-END:variables

    public JTree getTree() {
        return jTree1;
    }

    public void populateTree(LinkedList<String> st) {

        this.stavke = st;

        DefaultTreeModel model = (DefaultTreeModel) jTree1.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        for (int i = 0; i < faks.getKatedre().size(); i++) {
            root.add(new DefaultMutableTreeNode(faks.getKatedre().get(i).getNazivKatedre()));
        }
        model.reload();
    }

    public void prikaziFakultete(LinkedList<Fakultet> fak) {
        fakulteti = fak;
//        jComboBox1.removeAllItems();
//        for (Fakultet k : fakulteti) {
//            jComboBox1.addItem(k.getIme());
//        }

    }

    public void osvezi() {
        jPanel1.revalidate();
    }

    MouseListener ml = new MouseAdapter() {
        public void mousePressed(MouseEvent e) {
            int selRow = jTree1.getRowForLocation(e.getX(), e.getY());
            TreePath selPath = jTree1.getPathForLocation(e.getX(), e.getY());
            if (selRow != -1) {
                if (e.getClickCount() == 1) {

                } else if (e.getClickCount() == 2) {
                    myDoubleClick(selRow, selPath);
                }
            }
        }

        private void myDoubleClick(int selRow, TreePath selPath) {
            System.out.println("dupli klik");
            String s = (String) JOptionPane.showInputDialog(jPanel1, "Unesi podstavku");
            if ((s != null) && (s.length() > 0)) {
                ubaciPodstavku(s);
            }
        }
    };

    public void ubaciPodstavku(String s) {
        DefaultTreeModel model = (DefaultTreeModel) jTree1.getModel();
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) jTree1.getLastSelectedPathComponent();
        DefaultMutableTreeNode newNode;
        if (selectedNode.getUserObject() instanceof Katedra) {
            Katedra kat = new Katedra(s);
            faks.dodajKatedru(kat);
            newNode = new DefaultMutableTreeNode(kat);
        } else if (selectedNode.getUserObject() instanceof LaboratorijaCentar) {
            LaboratorijaCentar lab = new LaboratorijaCentar(s);
            faks.dodajLabCentar(lab);
            newNode = new DefaultMutableTreeNode(lab);
        } else if (selectedNode.getUserObject() instanceof Sluzba) {
            Sluzba sluzba = new Sluzba(s);
            faks.dodajSluzbu(sluzba);
            newNode = new DefaultMutableTreeNode(sluzba);
        } else if (selectedNode.getUserObject() instanceof Uprava) {
            Uprava uprava = new Uprava(s);
            faks.dodajUpravu(uprava);
            newNode = new DefaultMutableTreeNode(uprava);
        } else {
            Ostalo ostalo = new Ostalo(s);
            faks.dodajOstalo(ostalo);
            newNode = new DefaultMutableTreeNode(ostalo);
        }
        model.insertNodeInto(newNode, selectedNode, selectedNode.getChildCount());
        model.nodeStructureChanged((DefaultMutableTreeNode) model.getRoot());

//model.reload();
    }

}
