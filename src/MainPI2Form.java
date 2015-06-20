
import IngeSoft.PI2.PI2Manager;
import IngeSoft.PI2.RandomDataGenerator;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

public class MainPI2Form extends javax.swing.JFrame {

    static private MainPI2Form mainForm;
    
    public MainPI2Form() {
        initComponents();
        
        // evento selezione liste
        tblEspositori.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
                    public void valueChanged(ListSelectionEvent event) {
                        btnDelEsp.setEnabled( tblEspositori.getSelectedRow() >= 0);
                    }
                });
        tblVisitatori.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
                    public void valueChanged(ListSelectionEvent event) {
                        btnDelVis.setEnabled( tblVisitatori.getSelectedRow() >= 0);
                        btnChgVis.setEnabled( tblVisitatori.getSelectedRow() >= 0);
                    }
                });
        
        //RandomDataGenerator.EseguiTest();
        
        // aggiornamento dati
        //AggiornaListe();        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblEspositori = new javax.swing.JTable();
        btnSave = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnAddEsp = new javax.swing.JButton();
        btnDelEsp = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnLoad = new javax.swing.JButton();
        btnTest = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVisitatori = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnAddVis = new javax.swing.JButton();
        btnChgVis = new javax.swing.JButton();
        btnDelVis = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Prova in Itinere 2");
        setResizable(false);

        tblEspositori.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Paese", "Area", "IVA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEspositori.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(tblEspositori);
        if (tblEspositori.getColumnModel().getColumnCount() > 0) {
            tblEspositori.getColumnModel().getColumn(2).setResizable(false);
            tblEspositori.getColumnModel().getColumn(2).setPreferredWidth(30);
        }

        btnSave.setText("Salva");
        btnSave.setActionCommand("SAVE");
        btnSave.setEnabled(false);
        btnSave.setPreferredSize(new java.awt.Dimension(45, 30));
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
        });

        btnExit.setText("Esci");
        btnExit.setActionCommand("EXIT");
        btnExit.setPreferredSize(new java.awt.Dimension(45, 30));
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
        });

        btnAddEsp.setText("Aggiungi");
        btnAddEsp.setActionCommand("ADDESP");

        btnDelEsp.setText("Rimuovi");
        btnDelEsp.setActionCommand("DELESP");
        btnDelEsp.setEnabled(false);
        btnDelEsp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDelEspMouseClicked(evt);
            }
        });

        jLabel1.setText("Visitatori");

        btnLoad.setText("Carica Dati");
        btnLoad.setActionCommand("LOAD");
        btnLoad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLoadMouseClicked(evt);
            }
        });

        btnTest.setText("Genera Dati Casuali");
        btnTest.setActionCommand("TEST");
        btnTest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTestMouseClicked(evt);
            }
        });

        tblVisitatori.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Cognome", "CF"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblVisitatori.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tblVisitatori);

        jLabel2.setText("Espositori");

        btnAddVis.setText("Aggiungi");
        btnAddVis.setActionCommand("ADDVIS");
        btnAddVis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddVisMouseClicked(evt);
            }
        });

        btnChgVis.setText("Modifica");
        btnChgVis.setActionCommand("CHGVIS");
        btnChgVis.setEnabled(false);
        btnChgVis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChgVisMouseClicked(evt);
            }
        });

        btnDelVis.setText("Rimuovi");
        btnDelVis.setActionCommand("DELVIS");
        btnDelVis.setEnabled(false);
        btnDelVis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDelVisMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAddVis)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnDelVis, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnChgVis, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnExit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnAddEsp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnDelEsp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTest, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoad)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTest))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(btnAddVis)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnChgVis)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelVis)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAddEsp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelEsp)
                        .addGap(78, 78, 78))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        if (btnSave.isEnabled())
        {
            if (JOptionPane.showConfirmDialog(this,
                    "Le modifiche non sono state salvate\nSei sicuro di voler uscire?", "Esci", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) return;
        }
        
        System.exit(0);
    }//GEN-LAST:event_btnExitMouseClicked

    private void btnLoadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoadMouseClicked
        FileDialog loadDialog = new FileDialog( mainForm, "Carica dati", FileDialog.LOAD );
        loadDialog.setVisible(true);
        String file = loadDialog.getFile();                 
        if (file != null) {
            if (!PI2Manager.LoadFromFile( PathFile(loadDialog) ))
                JOptionPane.showMessageDialog(mainForm, "Errore caricamento file: " + file );
            else
                AggiornaListe();
        }
    }//GEN-LAST:event_btnLoadMouseClicked

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        FileDialog saveDialog = new FileDialog( mainForm, "Carica dati", FileDialog.SAVE );
        saveDialog.setVisible(true);
        String file = saveDialog.getFile();                 
        if (file != null) {
            if (!PI2Manager.SaveOnFile( PathFile(saveDialog) ))
                JOptionPane.showMessageDialog(mainForm, "Errore salvataggio file: " + file);
            else
                btnSave.setEnabled(false);
        }
    }//GEN-LAST:event_btnSaveMouseClicked

    private void btnTestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTestMouseClicked
        if (btnSave.isEnabled())
        {
            if (JOptionPane.showConfirmDialog(this,
                    "Le modifiche non sono state salvate\nSei sicuro di voler sovrascrivere i dati?", "Esci", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) return;
        }
        
        RandomDataGenerator.EseguiTest();
        JOptionPane.showMessageDialog(mainForm, "Generazione dati di test completata");
        setPendingSave();
        AggiornaListe();
    }//GEN-LAST:event_btnTestMouseClicked

    private void btnDelVisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDelVisMouseClicked
        String szCF = tblVisitatori.getValueAt( tblVisitatori.getSelectedRow(), 2 ).toString();
        
        if (PI2Manager.deleteVisitatore(szCF)) {               
            setPendingSave();
            
            ((DefaultTableModel) tblVisitatori.getModel()).removeRow(tblVisitatori.getSelectedRow());
        }
    }//GEN-LAST:event_btnDelVisMouseClicked

    private void btnDelEspMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDelEspMouseClicked
        String szIVA = tblEspositori.getValueAt( tblEspositori.getSelectedRow(), 3 ).toString();
        
        if (PI2Manager.deleteEspositore(szIVA)) {               
            setPendingSave();
            
            ((DefaultTableModel) tblEspositori.getModel()).removeRow(tblEspositori.getSelectedRow());
        }
    }//GEN-LAST:event_btnDelEspMouseClicked

    private void btnAddVisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddVisMouseClicked
        VisitatoreForm frmVisitatore = new VisitatoreForm( this, true, this, null );
        frmVisitatore.setVisible(true);
        AggiornaVisitatori();
    }//GEN-LAST:event_btnAddVisMouseClicked

    private void btnChgVisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChgVisMouseClicked
        String szCF = tblVisitatori.getValueAt( tblVisitatori.getSelectedRow(), 2 ).toString();
        
        VisitatoreForm frmVisitatore = new VisitatoreForm( this, true, this, PI2Manager.getVisitatore(szCF) );
        
        frmVisitatore.setVisible(true);
        
        AggiornaVisitatori();
    }//GEN-LAST:event_btnChgVisMouseClicked

    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainPI2Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPI2Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPI2Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPI2Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                mainForm = new MainPI2Form();
                mainForm.setVisible(true);
            }
        });
    }
    
    private void AggiornaVisitatori()
    {
        btnDelVis.setEnabled(false);
        btnChgVis.setEnabled(false);
                        
        DefaultTableModel tbl = (DefaultTableModel) tblVisitatori.getModel();
        
        tbl.setRowCount(0);
        
        for ( int i=0; i<PI2Manager.getListVisitatore().size(); i++ )
        {
           tbl.addRow( new Object[]{
               PI2Manager.getListVisitatore().get(i).getNome(),
               PI2Manager.getListVisitatore().get(i).getCognome(),
               PI2Manager.getListVisitatore().get(i).getCodiceFiscale()
           });
        }
    }
    
    private void AggiornaEspositori()
    {
        btnDelEsp.setEnabled(false);
        
        DefaultTableModel tbl = (DefaultTableModel) tblEspositori.getModel();
        
        tbl.setRowCount(0);
        
        for ( int i=0; i<PI2Manager.getListEspositori().size(); i++ )
        {
           tbl.addRow( new Object[]{
               PI2Manager.getListEspositori().get(i).getNome(),
               PI2Manager.getListEspositori().get(i).getPaese(),
               PI2Manager.getListEspositori().get(i).getArea(),
               PI2Manager.getListEspositori().get(i).getIVA(),
           });
        }
    }
    
    private void AggiornaListe()
    {
        AggiornaEspositori();
        AggiornaVisitatori();
    }
    
    // restituisce la path assoluta del file selezionato
    private String PathFile( FileDialog fd )
    {
         if (fd.getFile() == null) return "";

         // correggo la path del file
         if (!fd.getDirectory().endsWith(File.separator)) return fd.getDirectory() + File.separator + fd.getFile();
         else return fd.getDirectory() + fd.getFile();
    }
    
    public void setPendingSave() {
        btnSave.setEnabled( true );
    }
            
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddEsp;
    private javax.swing.JButton btnAddVis;
    private javax.swing.JButton btnChgVis;
    private javax.swing.JButton btnDelEsp;
    private javax.swing.JButton btnDelVis;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnTest;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblEspositori;
    private javax.swing.JTable tblVisitatori;
    // End of variables declaration//GEN-END:variables
}
