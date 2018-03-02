/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.markConsult.gui;

import br.com.markConsult.classesMetodos.FixedLengthDocument;
import br.com.markConsult.classesMetodos.IntegerDocument;
import br.com.markConsult.dao.CadEspecialiDAO;
import br.com.markConsult.dao.entidades.Especialidade;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author jeferson
 */
public class CadEspecialidade extends javax.swing.JInternalFrame {
int inserir_alterar = 0;
    /**
     * Creates new form CadEspecialidade
     */
    public CadEspecialidade() {
        initComponents();
        
        estadoBotoes("inicial");
        tf_codigo.setDocument(new IntegerDocument(10));
        tfEspeciali.setDocument(new  FixedLengthDocument(80));
        bt_buscar.requestFocus();
        atualizaTela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        bt_sair2 = new javax.swing.JButton();
        bt_editar = new javax.swing.JButton();
        bt_salvar = new javax.swing.JButton();
        bt_novo = new javax.swing.JButton();
        bt_excluir = new javax.swing.JButton();
        bt_cancelar = new javax.swing.JButton();
        bt_buscar = new javax.swing.JButton();
        bt_ultimo = new javax.swing.JButton();
        bt_avançar = new javax.swing.JButton();
        bt_voltar = new javax.swing.JButton();
        bt_primeiro = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tf_codigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tfEspeciali = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Especialidades");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/markConsult/imagens/help.png"))); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setToolTipText("");

        bt_sair2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/markConsult/imagens/Log-Out-icon.png"))); // NOI18N
        bt_sair2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sair", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Arial", 0, 11))); // NOI18N
        bt_sair2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sair2ActionPerformed(evt);
            }
        });

        bt_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/markConsult/imagens/Action-edit-icon.png"))); // NOI18N
        bt_editar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Editar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Arial", 0, 11))); // NOI18N
        bt_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_editarActionPerformed(evt);
            }
        });

        bt_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/markConsult/imagens/App-floppy-icon.png"))); // NOI18N
        bt_salvar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Salvar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Arial", 0, 11))); // NOI18N
        bt_salvar.setIconTextGap(2);
        bt_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_salvarActionPerformed(evt);
            }
        });

        bt_novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/markConsult/imagens/new-file-icon.png"))); // NOI18N
        bt_novo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Novo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Arial", 0, 11))); // NOI18N
        bt_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_novoActionPerformed(evt);
            }
        });

        bt_excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/markConsult/imagens/trash-icon.png"))); // NOI18N
        bt_excluir.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Excluir", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Arial", 0, 11))); // NOI18N
        bt_excluir.setIconTextGap(2);
        bt_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_excluirActionPerformed(evt);
            }
        });

        bt_cancelar.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        bt_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/markConsult/imagens/Extras-Close-icon.png"))); // NOI18N
        bt_cancelar.setAutoscrolls(true);
        bt_cancelar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cancelar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Arial", 0, 11))); // NOI18N
        bt_cancelar.setIconTextGap(2);
        bt_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelarActionPerformed(evt);
            }
        });

        bt_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/markConsult/imagens/Search-icon.png"))); // NOI18N
        bt_buscar.setToolTipText("");
        bt_buscar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Arial", 0, 11))); // NOI18N
        bt_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_buscarActionPerformed(evt);
            }
        });
        bt_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bt_buscarKeyPressed(evt);
            }
        });

        bt_ultimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/markConsult/imagens/hide-right-icon.png"))); // NOI18N
        bt_ultimo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ultimo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Arial", 0, 11))); // NOI18N
        bt_ultimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ultimoActionPerformed(evt);
            }
        });

        bt_avançar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/markConsult/imagens/navigate-right-icon.png"))); // NOI18N
        bt_avançar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Avançar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Arial", 0, 11))); // NOI18N
        bt_avançar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_avançarActionPerformed(evt);
            }
        });

        bt_voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/markConsult/imagens/navigate-left-icon.png"))); // NOI18N
        bt_voltar.setToolTipText("");
        bt_voltar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Voltar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Arial", 0, 11))); // NOI18N
        bt_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltarActionPerformed(evt);
            }
        });

        bt_primeiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/markConsult/imagens/hide-left-icon.png"))); // NOI18N
        bt_primeiro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Primeiro", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Arial", 0, 11))); // NOI18N
        bt_primeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_primeiroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(bt_primeiro, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(bt_voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(bt_avançar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(bt_ultimo, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(bt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(bt_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(bt_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(bt_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(bt_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(bt_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(bt_sair2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bt_buscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(bt_excluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(bt_novo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(bt_sair2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(bt_editar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(bt_salvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(bt_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(bt_ultimo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(bt_avançar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(bt_voltar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(bt_primeiro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Especialidades Médicas", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jLabel4.setText("Código:");

        tf_codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_codigoActionPerformed(evt);
            }
        });
        tf_codigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_codigoFocusLost(evt);
            }
        });
        tf_codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_codigoKeyPressed(evt);
            }
        });

        jLabel1.setText("Descrição:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfEspeciali, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tf_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfEspeciali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_sair2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sair2ActionPerformed
        dispose();
    }//GEN-LAST:event_bt_sair2ActionPerformed

    private void bt_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_editarActionPerformed
        inserir_alterar = 1;
        estadoBotoes("novo");
    }//GEN-LAST:event_bt_editarActionPerformed

    private void bt_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_salvarActionPerformed

        String especiali = tfEspeciali.getText();

        if (inserir_alterar == 0) {
            CadEspecialiDAO dao = new CadEspecialiDAO();

            Especialidade p = new Especialidade(null, especiali);

            int id = dao.inserir(p);

            p.setId(id);
            mostrar_dados(p);

        }else

        if (inserir_alterar == 1) {

            Integer id = Integer.parseInt(tf_codigo.getText());

            CadEspecialiDAO dao = new CadEspecialiDAO();
            Especialidade med = new Especialidade(id, especiali);
            dao.alterar(med);

        }
        inserir_alterar = 0;

        estadoBotoes("salvar");
    }//GEN-LAST:event_bt_salvarActionPerformed

    private void bt_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoActionPerformed
        tf_codigo.setText("");
        tfEspeciali.setText("");

        estadoBotoes("novo");
        tfEspeciali.requestFocus();
    }//GEN-LAST:event_bt_novoActionPerformed

    private void bt_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_excluirActionPerformed
        int opcao_escolhida = JOptionPane.showConfirmDialog(null, "Excluir " + tfEspeciali.getText() + "?", "Exclusão ", JOptionPane.YES_NO_OPTION);
        if (opcao_escolhida == JOptionPane.YES_OPTION) {
            int id = Integer.parseInt(tf_codigo.getText());
            CadEspecialiDAO dao = new CadEspecialiDAO();
            boolean excludo = dao.remover(id);
            if (excludo) {
                atualizaTela();
                estadoBotoes("inicial");
            }else{
                JOptionPane.showMessageDialog(null, "Especialidade não pode ser excluído porque está sendo utilizado em outra tabela");
            }
        }

    }//GEN-LAST:event_bt_excluirActionPerformed

    private void bt_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelarActionPerformed
        String nome = "Deseja realmente cancelar?";
        int opcao_escolhida = JOptionPane.showConfirmDialog(null, nome, "Cancelar ", JOptionPane.YES_NO_OPTION);
        if (opcao_escolhida == JOptionPane.YES_OPTION) {
            estadoBotoes("cancelar");
            inserir_alterar = 0;
        }
    }//GEN-LAST:event_bt_cancelarActionPerformed

    private void bt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_buscarActionPerformed
        telBuscEsp();
    }//GEN-LAST:event_bt_buscarActionPerformed

    private void bt_buscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bt_buscarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            telBuscEsp();
        }
    }//GEN-LAST:event_bt_buscarKeyPressed

    private void bt_ultimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ultimoActionPerformed
        CadEspecialiDAO dao = new CadEspecialiDAO();
        Especialidade m = dao.mostrarUltimo();
        mostrar_dados(m);
    }//GEN-LAST:event_bt_ultimoActionPerformed

    private void bt_avançarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_avançarActionPerformed
        CadEspecialiDAO dao = new CadEspecialiDAO();
        Especialidade m = dao.mostrarProximo(Integer.parseInt(tf_codigo.getText()));
        mostrar_dados(m);
    }//GEN-LAST:event_bt_avançarActionPerformed

    private void bt_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltarActionPerformed
        CadEspecialiDAO dao = new CadEspecialiDAO();
        Especialidade m = dao.mostrarAnterior(Integer.parseInt(tf_codigo.getText()));
        mostrar_dados(m);
    }//GEN-LAST:event_bt_voltarActionPerformed

    private void bt_primeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_primeiroActionPerformed
        CadEspecialiDAO dao = new CadEspecialiDAO();
        Especialidade m = dao.mostrarPrimeiro();
        mostrar_dados(m);
    }//GEN-LAST:event_bt_primeiroActionPerformed

    private void tf_codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_codigoActionPerformed
        tfEspeciali.requestFocus();
    }//GEN-LAST:event_tf_codigoActionPerformed

    private void tf_codigoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_codigoFocusLost
        if (tf_codigo.isEditable()) {
        String id = tf_codigo.getText();
        if (id.equals("")) {
            atualizaTela();
        }else{
            buscaPorId(id);
        }}
    }//GEN-LAST:event_tf_codigoFocusLost

    private void tf_codigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_codigoKeyPressed
          if (tf_codigo.isEditable()) {
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            telBuscEsp();
        }
          }
    }//GEN-LAST:event_tf_codigoKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_avançar;
    private javax.swing.JButton bt_buscar;
    private javax.swing.JButton bt_cancelar;
    private javax.swing.JButton bt_editar;
    private javax.swing.JButton bt_excluir;
    private javax.swing.JButton bt_novo;
    private javax.swing.JButton bt_primeiro;
    private javax.swing.JButton bt_sair2;
    private javax.swing.JButton bt_salvar;
    private javax.swing.JButton bt_ultimo;
    private javax.swing.JButton bt_voltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField tfEspeciali;
    private javax.swing.JTextField tf_codigo;
    // End of variables declaration//GEN-END:variables
private void estadoBotoes(String botao) {
if ("inicial".equals(botao)) {
            bt_novo.setEnabled(true);
            bt_cancelar.setEnabled(false);
            bt_editar.setEnabled(true);
            bt_buscar.setEnabled(true);
            bt_salvar.setEnabled(false);
            bt_excluir.setEnabled(true);
            bt_primeiro.setEnabled(true);
            bt_voltar.setEnabled(true);
            bt_avançar.setEnabled(true);
            bt_ultimo.setEnabled(true);

            tf_codigo.setEditable(true);
            tfEspeciali.setEditable(false);
            
           

        }

        if ("novo".equals(botao)) {
            bt_novo.setEnabled(false);
            bt_cancelar.setEnabled(true);
            bt_editar.setEnabled(true);
            bt_buscar.setEnabled(false);
            bt_excluir.setEnabled(false);
            bt_editar.setEnabled(false);
            bt_salvar.setEnabled(true);
            bt_primeiro.setEnabled(false);
            bt_voltar.setEnabled(false);
            bt_avançar.setEnabled(false);
            bt_ultimo.setEnabled(false);

            tf_codigo.setEditable(false);
            tfEspeciali.setEditable(true);
         

        }


        if ("cancelar".equals(botao)) {
           atualizaTela();
            estadoBotoes("inicial");
        }
        if ("salvar".equals(botao)) {
            estadoBotoes("inicial");

        }

        if ("buscar".equals(botao)) {
            estadoBotoes("inicial");

        }

 }


 public void mostrar_dados(Especialidade med) {
if(med!=null){
        tf_codigo.setText("" + med.getId());
        tfEspeciali.setText(med.getEspecialidade());   
        
       
}
    }
public final void atualizaTela() {
      CadEspecialiDAO dao = new CadEspecialiDAO();
       Especialidade m = dao.mostrarUltimo();

           mostrar_dados(m);
        
}

public void buscaPorId(String id) {
    if (!tf_codigo.getText().equals("")) {
        
    
     CadEspecialiDAO dao = new CadEspecialiDAO();
        Especialidade p = dao.procuraPorID(Integer.parseInt(id));
        if(p==null){
            JOptionPane.showMessageDialog(null, "Cadastro "+tf_codigo.getText()+" não existe!");
            tf_codigo.requestFocus();
        }
        mostrar_dados(p);
    }
}

public void telBuscEsp(){
     BuscEspecialidades b = new BuscEspecialidades(null, true);
      b.setVisible(true);
        if (b.okselecionado()) {
            Especialidade m = b.retornEspSele();
        if (m != null) {
            mostrar_dados(m);
            
        }
        }
}
}
