/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.markConsult.gui;

import br.com.markConsult.Tetes.Utils;
import br.com.markConsult.dao.CadAlbunsPacienteDAO;
import br.com.markConsult.dao.CadImagensPacienteDAO;
import br.com.markConsult.dao.entidades.Album;
import br.com.markConsult.dao.entidades.ArquivosPaciente;
import br.com.markConsult.dao.entidades.Paciente;
import br.com.markConsult.utils.ImagePreview;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Jeferson
 */
public class CadImagensPaciente extends javax.swing.JDialog {

    private final Properties confBanco = new Properties();
    Paciente paciente;
    DefaultListModel listImg = new DefaultListModel();
    ArrayList<File> imgSelecionadas = new ArrayList<>();

    String data = (new java.text.SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date(System.currentTimeMillis())));
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    CadAlbunsPacienteDAO daoAbuns = new CadAlbunsPacienteDAO();

    /**
     * Creates new form CadImagem
     *
     * @param parent
     * @param modal
     */
    public CadImagensPaciente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        try {
            confBanco.load(new FileInputStream("/markconsultas/banco.ini"));
        } catch (IOException ex) {
            Logger.getLogger(CadImagensPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JButton jButton1 = new javax.swing.JButton();
        bt_importar = new javax.swing.JButton();
        jL_imagem = new javax.swing.JLabel();
        jC_albuns = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        tf_descAlbum = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jL_imgSele = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("Buscar Imagem");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        bt_importar.setText("IMPORTAR IMAGENS SELECIONADAS");
        bt_importar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_importarActionPerformed(evt);
            }
        });

        jL_imagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jL_imagem.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jLabel1.setText("Pastas:");

        jButton3.setText("CRIAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setText("Novo Album:");

        jL_imgSele.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jL_imgSeleMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(jL_imgSele);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(tf_descAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jC_albuns, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jL_imagem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_importar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jL_imagem, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jC_albuns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(tf_descAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_importar)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser jfc = new JFileChooser();
        jfc.setDialogTitle("Importar imagem");
        jfc.setFileFilter(new FileNameExtensionFilter("Arquivos, jpg, gif, png, pdf, xls","jpg", "jpeg", "gif", "png","pdf","xls"));
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jfc.setAcceptAllFileFilterUsed(false);
        jfc.setMultiSelectionEnabled(true);
        jfc.setAccessory(new ImagePreview(jfc));
        int retorno = jfc.showDialog(jfc, "Selecione");
        if (retorno == JFileChooser.APPROVE_OPTION) {

            List<File> imgSele = Arrays.asList(jfc.getSelectedFiles());
            for (File imgSele1 : imgSele) {
                if (accept(imgSele1)) {
                    imgSelecionadas.add(imgSele1);
                    listImg.addElement(imgSele1.getName());
                } else {
                    JOptionPane.showMessageDialog(null, "imagem inválida!");
                }
            }

            try {
                BufferedImage imagem = ImageIO.read(imgSelecionadas.get(imgSelecionadas.size() - 1));
                mostraImagem(imagem);
            } catch (IOException ex) {
                Logger.getLogger(CadImagensPaciente.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (listImg != null) {
                jL_imgSele.removeAll();
                jL_imgSele.setModel(listImg);
                
            }
//           imgSele.stream().forEach((imgSele1) -> {
//               imgSelecionadas.add(imgSele1);
//            });
//           
//           endImgem = jfc.getSelectedFile().toString();
//           listImg.clear();
//            
//            for (File imgSelecionada : imgSelecionadas) {
//            listImg.addElement(imgSelecionada.getName());
//            if (accept(imgSelecionada)) {
//                try {
//                    BufferedImage imagem = ImageIO.read(imgSelecionada);
//                    mostraImagem(imagem);
//                } catch (IOException ex) {
//                    Logger.getLogger(CadImagensPaciente.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            } else {
//                JOptionPane.showMessageDialog(null, "imagem inválida!");
//            }  
//            }if (listImg != null) {
//            jL_imgSele.removeAll();
//            jL_imgSele.setModel(listImg);
//        }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bt_importarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_importarActionPerformed
        Date dt = null;
        try {
            dt = (Date) converte(data);
        } catch (ParseException ex) {
            Logger.getLogger(CadConsultaModal.class.getName()).log(Level.SEVERE, null, ex);
        }
        CadImagensPacienteDAO dao = new CadImagensPacienteDAO();
        Album abAlbum = (Album) jC_albuns.getSelectedItem();
        for (File imgSelecionada : imgSelecionadas) {
            ArquivosPaciente imp = new ArquivosPaciente(null, paciente, dt, "", imgSelecionada.getName(),abAlbum);
            dao.inseImagensPaciente(imp);
            criarDiretorio(imgSelecionada.getName(),imgSelecionada);
            
        }
    }//GEN-LAST:event_bt_importarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String descAlbum = tf_descAlbum.getText();
        if (!descAlbum.equals("")) {

            Album ab = new Album(null, paciente, descAlbum);
            daoAbuns.inseAlbum(ab);
            buscaAbunsPaciente(paciente);
            JOptionPane.showMessageDialog(null, "Album criado com sucesso!");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jL_imgSeleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jL_imgSeleMousePressed
        int sele = jL_imgSele.getSelectedIndex();
        if (sele >= 0) {
            try {
                BufferedImage imagem = ImageIO.read(imgSelecionadas.get(sele));
                mostraImagem(imagem);
            } catch (IOException ex) {
                Logger.getLogger(CadImagensPaciente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jL_imgSeleMousePressed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadImagensPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadImagensPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadImagensPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadImagensPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CadImagensPaciente dialog = new CadImagensPaciente(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_importar;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jC_albuns;
    private javax.swing.JLabel jL_imagem;
    private javax.swing.JList jL_imgSele;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField tf_descAlbum;
    // End of variables declaration//GEN-END:variables
public final java.util.Date converte(String dataConsul) throws ParseException {
        DateFormat forma = new SimpleDateFormat("dd/MM/yyyy");
        java.sql.Date dat = new java.sql.Date(forma.parse(dataConsul).getTime());

        return dat;
    }

    public void setPaciente(Paciente p) {
        paciente = p;
    }

    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }

        String extension = Utils.getExtension(f);
        if (extension != null) {
            if (extension.equals(Utils.gif)
                    || extension.equals(Utils.jpeg)
                    || extension.equals(Utils.jpg)
                    || extension.equals(Utils.png) 
                    || extension.equals(Utils.pdf) 
                    || extension.equals(Utils.xls)) {
                return true;
            } else {
                return false;
            }
        }

        return false;
    }

    public void mostraImagem(BufferedImage imagem) {
        if (imagem != null) {
            try {
                ImageIcon jpg = new ImageIcon(redimenImagem(imagem, 314, 235));
                jL_imagem.setIcon(jpg);
            } catch (IOException ex) {
                Logger.getLogger(VerImagens.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static BufferedImage redimenImagem(BufferedImage imagem, Integer imgLargura, Integer imgAltura) throws IOException {

        Double novaImgLargura = (double) imagem.getWidth();
        Double novaImgAltura = (double) imagem.getHeight();
        Double imgProporcao;
        if (novaImgLargura >= imgLargura) {
            imgProporcao = (novaImgAltura / novaImgLargura);
            novaImgLargura = (double) imgLargura;
            novaImgAltura = (novaImgLargura * imgProporcao);
            while (novaImgAltura > imgAltura) {
                novaImgLargura = (double) (--imgLargura);
                novaImgAltura = (novaImgLargura * imgProporcao);
            }
        } else if (novaImgAltura >= imgAltura) {
            imgProporcao = (novaImgLargura / novaImgAltura);
            novaImgAltura = (double) imgAltura;
            while (novaImgLargura > imgLargura) {
                novaImgAltura = (double) (--imgAltura);
                novaImgLargura = (novaImgAltura * imgProporcao);
            }
        }
        BufferedImage novaImagem = new BufferedImage(novaImgLargura.intValue(), novaImgAltura.intValue(), BufferedImage.TYPE_INT_RGB);
        Graphics g = novaImagem.getGraphics();
        g.drawImage(imagem.getScaledInstance(novaImgLargura.intValue(), novaImgAltura.intValue(), 10000), 0, 0, null);
        g.dispose();
        return novaImagem;
        //ImageIO.write(novaImagem, "JPG", new File(caminhoImg));
    }

     public void criarDiretorio(String nomIMG,File file ) {
        try {
            // File arquivo = new File(confBanco.getProperty("ip")+imp.getPaciente().getId()+"/"+imp.getImagem());
            Album abAlbum = (Album) jC_albuns.getSelectedItem();
            File diretorio = new File(confBanco.getProperty("ip") + paciente.getId() + "/" + abAlbum.getId() + "/");
            String endImgem = diretorio.toString() + "/" + nomIMG;
            if (!diretorio.exists()) {
                diretorio.mkdirs();
            }
            BufferedImage imagem = ImageIO.read(file);
            salvaImagem(imagem, 800, 600,endImgem);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao criar o diretorio");
            System.out.println(ex);
        }
    }
    public void salvaImagem(BufferedImage imagem, Integer imgLargura, Integer imgAltura,String endImgem) throws IOException {

        Double novaImgLargura = (double) imagem.getWidth();
        Double novaImgAltura = (double) imagem.getHeight();
        Double imgProporcao;
        if (novaImgLargura >= imgLargura) {
            imgProporcao = (novaImgAltura / novaImgLargura);
            novaImgLargura = (double) imgLargura;
            novaImgAltura = (novaImgLargura * imgProporcao);
            while (novaImgAltura > imgAltura) {
                novaImgLargura = (double) (--imgLargura);
                novaImgAltura = (novaImgLargura * imgProporcao);
            }
        } else if (novaImgAltura >= imgAltura) {
            imgProporcao = (novaImgLargura / novaImgAltura);
            novaImgAltura = (double) imgAltura;
            while (novaImgLargura > imgLargura) {
                novaImgAltura = (double) (--imgAltura);
                novaImgLargura = (novaImgAltura * imgProporcao);
            }
        }
        BufferedImage novaImagem = new BufferedImage(novaImgLargura.intValue(), novaImgAltura.intValue(), BufferedImage.TYPE_INT_RGB);
        Graphics g = novaImagem.getGraphics();
        g.drawImage(imagem.getScaledInstance(novaImgLargura.intValue(), novaImgAltura.intValue(), 10000), 0, 0, null);
        g.dispose();

        ImageIO.write(novaImagem, "JPG", new File(endImgem));
    }

   

    public void buscaAbunsPaciente(Paciente p) {

        List<Album> albuns = daoAbuns.buscaAlbum(p);
        if (!albuns.isEmpty()) {
            jC_albuns.removeAllItems();
            albuns.stream().forEach((albun) -> {
                jC_albuns.addItem(albun);
            });
        }
    }
}