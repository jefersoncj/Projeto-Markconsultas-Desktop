/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.markConsult.gui;

import br.com.markConsult.classesMetodos.FuncaoTableModel;
import br.com.markConsult.classesMetodos.FixedLengthDocument;
import br.com.markConsult.dao.CadFuncaoDAO;
import br.com.markConsult.entidades.Funcao;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author jeferson
 */
public class BuscaFuncao extends javax.swing.JDialog {

    private boolean okselecionado = false;
    List<Funcao> tipoConsultas;
    private FuncaoTableModel model;

    /**
     * Creates new form ConsPorClientes
     * @param parent
     * @param modal
     */
    public BuscaFuncao(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        URL url = this.getClass().getResource("/br/com/markConsult/imagens/help.png");  
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);  
        this.setIconImage(imagemTitulo); 
        model = new FuncaoTableModel();
        jTFuncaos.setModel(model);

        CadFuncaoDAO dao = new CadFuncaoDAO();
        List<Funcao> usu = dao.BuscaFuncaos("", 'e');
        model.listar(usu);

        tf_dado.setDocument(new FixedLengthDocument(70));
        jTFuncaos.getColumnModel().getColumn(0).setMinWidth(15);
        jTFuncaos.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTFuncaos.getSelectionModel().setSelectionInterval(0, 0);
        
        
        jTFuncaos.setAutoCreateRowSorter(true);
        
        TableRowSorter<FuncaoTableModel> sorter = new TableRowSorter<>((FuncaoTableModel) jTFuncaos.getModel());  
            jTFuncaos.setRowSorter(sorter);
        
        
        JTableHeader header = jTFuncaos.getTableHeader();  
        header.addMouseListener(new MouseAdapter() {  
  
            @Override  
            public void mouseClicked(MouseEvent e) {  
                JTable table = ((JTableHeader) e.getSource()).getTable();  
                TableColumnModel colModel = table.getColumnModel();  
                int vColIndex = colModel.getColumnIndexAtX(e.getX());  
                int mColIndex = table.convertColumnIndexToModel(vColIndex);  
                if (vColIndex == -1) {  
                    return;  
                }  
                int ordenacao = mColIndex; //criei esta váriavel ordenacao;  
            }  
        }); 
        
         tf_dado.requestFocus();
        KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);

        Action escapeAction = new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        };
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke, "ESCAPE");
        getRootPane().getActionMap().put("ESCAPE", escapeAction);
   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt_sair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTFuncaos = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        tf_dado = new javax.swing.JTextField();
        cb_campo = new javax.swing.JComboBox();
        bt_busca2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cbx_complete = new java.awt.Checkbox();
        Ok = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Busca Funções");
        setResizable(false);

        bt_sair.setText("Fechar");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });

        jTFuncaos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTFuncaos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTFuncaosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTFuncaos);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Busca Funções", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        tf_dado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_dadoActionPerformed(evt);
            }
        });
        tf_dado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_dadoKeyReleased(evt);
            }
        });

        cb_campo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nome", "Código" }));

        bt_busca2.setText("Buscar");
        bt_busca2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_busca2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Campos:");

        cbx_complete.setLabel("Auto Complete");
        cbx_complete.setState(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_campo, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(tf_dado, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_busca2))
                    .addComponent(cbx_complete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(cbx_complete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_campo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_dado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_busca2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Ok.setText("OK");
        Ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bt_sair)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Ok, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Ok)
                    .addComponent(bt_sair))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void tf_dadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_dadoActionPerformed
        pesquisa();
    }//GEN-LAST:event_tf_dadoActionPerformed

    private void bt_busca2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_busca2ActionPerformed
        pesquisa();
    }//GEN-LAST:event_bt_busca2ActionPerformed

    private void tf_dadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_dadoKeyReleased
        if (cbx_complete.getState() == true) {
            pesquisa();
        }
    }//GEN-LAST:event_tf_dadoKeyReleased

    private void jTFuncaosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFuncaosMouseClicked
       if (evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() == 2) {
            okselecionado = true;
            dispose();
            
        }
       
    
    }//GEN-LAST:event_jTFuncaosMouseClicked

    private void OkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkActionPerformed
      okselecionado = true;
      dispose();
    }//GEN-LAST:event_OkActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscaFuncao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            BuscaFuncao dialog = new BuscaFuncao(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Ok;
    private javax.swing.JButton bt_busca2;
    private javax.swing.JButton bt_sair;
    private javax.swing.JComboBox cb_campo;
    private java.awt.Checkbox cbx_complete;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTFuncaos;
    private javax.swing.JTextField tf_dado;
    // End of variables declaration//GEN-END:variables

 
    public Funcao retornEspSele() {
        int sele = jTFuncaos.getSelectedRow();
        Funcao p = null;
        if (sele >= 0) {
            sele = jTFuncaos.convertRowIndexToModel(sele);
            p = model.getItem(sele);
        }
        return p;
    }

    public boolean okselecionado() {

        return okselecionado;
        

    }

    public void pesquisa() {
        CadFuncaoDAO dao = new CadFuncaoDAO();
        String valor = tf_dado.getText();
   
        switch (cb_campo.getSelectedIndex()) {
            case 0:
                tipoConsultas = dao.BuscaFuncaos(valor, 'e');
                break;
            case 1:
                tipoConsultas = dao.BuscaFuncaos(valor, 'i');
                break;


        }

        model.listar(tipoConsultas);
        
        
    }
}
