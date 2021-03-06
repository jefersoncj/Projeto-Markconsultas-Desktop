/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.markConsult.gui;

import br.com.markConsult.classesMetodos.ConsPcliTableModel;
import br.com.markConsult.classesMetodos.ConsultaProcedimentosTableModel;
import br.com.markConsult.classesMetodos.FixedLengthDocument;
import br.com.markConsult.classesMetodos.FormatacaoConteudo;
import br.com.markConsult.classesMetodos.IntegerDocument;
import br.com.markConsult.classesMetodos.Mascaras;
import br.com.markConsult.dao.CadPacienteDAO;
import br.com.markConsult.dao.CadCondPagtoDAO;
import br.com.markConsult.dao.CadConsultasDAO;
import br.com.markConsult.dao.CadConvenioDAO;
import br.com.markConsult.dao.CadEmpresaDAO;
import br.com.markConsult.dao.CadUsuarioDAO;
import br.com.markConsult.dao.ICadPacienteDAO;
import br.com.markConsult.dao.ICadCondPagtoDAO;
import br.com.markConsult.entidades.CondPagto;
import br.com.markConsult.entidades.Consulta;
import br.com.markConsult.entidades.ConsultaProcedimento;
import br.com.markConsult.entidades.Convenio;
import br.com.markConsult.entidades.Empresa;
import br.com.markConsult.entidades.EmpresaProcedimento;
import br.com.markConsult.entidades.Paciente;
import br.com.markConsult.entidades.Procedimento;
import br.com.markConsult.entidades.Tipo;
import br.com.markConsult.entidades.Usuario;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Jeferson1
 */
public class CadConsultaModal extends javax.swing.JDialog {
    List<Consulta> consultas;
    private final ConsPcliTableModel model;
    private int ins_alt = 0;
    String data = (new java.text.SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date(System.currentTimeMillis())));
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    List<Procedimento> tipoConsultas;
    private ConsultaProcedimentosTableModel modelProcedimento;
    ArrayList<ConsultaProcedimento> procedimentoExcluir = new ArrayList<>();

    /**
     * Creates new form CadConsulta
     *
     * @param parent
     * @param modal
     */
    public CadConsultaModal(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        model = new ConsPcliTableModel();
        jTConsultas.setModel(model);
        jTConsultas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        ajusTabela();
        FormatacaoConteudo corNomes = new FormatacaoConteudo();
        jTConsultas.getColumnModel().getColumn(7).setCellRenderer(corNomes);
        
        modelProcedimento = new ConsultaProcedimentosTableModel();
        jt_empresaProcedimento.setModel(modelProcedimento);
        
        Date dt = null;

        tf_dataConsul.addPropertyChangeListener((java.beans.PropertyChangeEvent evt) -> {
            try {
                //GERA EVENTO
                buscaPorData();
            } catch (ParseException ex) {
                Logger.getLogger(CadRetorno.class.getName()).log(Level.SEVERE, null, ex);
            }
        } //GERA A AÇÃO PRA TROCA DE PROPRIEDADE
        );

        try {
            dt = (Date) converte(data);
        } catch (ParseException ex) {
            Logger.getLogger(CadConsultaModal.class.getName()).log(Level.SEVERE, null, ex);
        }

        tf_dataConsul.setDate(dt);
        tf_nomPaciente.setDocument(new FixedLengthDocument(100));
        tf_numConve.setDocument(new FixedLengthDocument(20));
        tf_obs.setDocument(new FixedLengthDocument(110));
        tf_valor.setDocument(new Mascaras(10));
        tf_idMedico.setDocument(new IntegerDocument(10));
        tf_codCondPagt.setDocument(new IntegerDocument(10));
        tf_idPaciente.setDocument(new IntegerDocument(10));
        tf_autoriza.setDocument(new IntegerDocument(15));
        estadoBotoes("inicial");
        
        jC_prioritario.setVisible(false);
        tf_naFila.setVisible(false);
        
        jLabel11.setVisible(false);
        jLabel10.setVisible(false);
        
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

        jPanel2 = new javax.swing.JPanel();
        bt_buscar = new javax.swing.JButton();
        bt_novo = new javax.swing.JButton();
        bt_cancelar = new javax.swing.JButton();
        bt_excluir = new javax.swing.JButton();
        bt_salvar = new javax.swing.JButton();
        bt_editar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTConsultas = new javax.swing.JTable();
        bt_data_proxima = new javax.swing.JButton();
        bt_data_anterior = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lbmedico = new javax.swing.JLabel();
        tf_nomPaciente = new javax.swing.JTextField();
        bt_buscCli = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        tf_idPaciente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tf_valor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tf_idconve = new javax.swing.JTextField();
        tf_nomeConve = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        tf_codCondPagt = new javax.swing.JTextField();
        tf_condpagt = new javax.swing.JTextField();
        bt_condPagto = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        tf_numConve = new javax.swing.JTextField();
        tf_dataConsul = new com.toedter.calendar.JDateChooser("dd/MM/yyyy" , "##/##/####" , ' ');
        bt_buscMed = new javax.swing.JButton();
        tf_nomedico = new javax.swing.JTextField();
        tf_idMedico = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lbCli = new javax.swing.JLabel();
        lb_med = new javax.swing.JLabel();
        lbCodPag = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tf_codigo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tf_nomeEmpresa = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tf_naFila = new javax.swing.JTextField();
        jC_prioritario = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tf_autoriza = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jC_status = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jC_tipo_cons = new javax.swing.JComboBox();
        tf_idEMpresa = new javax.swing.JTextField();
        bt_empresa = new javax.swing.JButton();
        bt_convenio = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tf_obs = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jt_empresaProcedimento = new javax.swing.JTable();
        bt_inserirProcedimento = new javax.swing.JButton();
        bt_removeProcedimento = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Consulta");
        setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        bt_buscar.setFont(new java.awt.Font("Ubuntu", 0, 10)); // NOI18N
        bt_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/markConsult/imagens/Search-icon (1).png"))); // NOI18N
        bt_buscar.setToolTipText("");
        bt_buscar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consultas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Ubuntu", 0, 11))); // NOI18N
        bt_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_buscarActionPerformed(evt);
            }
        });

        bt_novo.setFont(new java.awt.Font("Ubuntu", 0, 10)); // NOI18N
        bt_novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/markConsult/imagens/new-file-icon (2).png"))); // NOI18N
        bt_novo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Novo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Ubuntu", 0, 11))); // NOI18N
        bt_novo.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        bt_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_novoActionPerformed(evt);
            }
        });

        bt_cancelar.setFont(new java.awt.Font("Ubuntu", 0, 8)); // NOI18N
        bt_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/markConsult/imagens/Action-edit-icon (3).png"))); // NOI18N
        bt_cancelar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cancelar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Ubuntu", 0, 11))); // NOI18N
        bt_cancelar.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        bt_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelarActionPerformed(evt);
            }
        });

        bt_excluir.setFont(new java.awt.Font("Ubuntu", 0, 8)); // NOI18N
        bt_excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/markConsult/imagens/trash-icon (2).png"))); // NOI18N
        bt_excluir.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Excluir", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Ubuntu", 0, 11))); // NOI18N
        bt_excluir.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        bt_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_excluirActionPerformed(evt);
            }
        });

        bt_salvar.setFont(bt_salvar.getFont().deriveFont(bt_salvar.getFont().getSize()-7f));
        bt_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/markConsult/imagens/salvaIt.png"))); // NOI18N
        bt_salvar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Salvar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Ubuntu", 0, 11))); // NOI18N
        bt_salvar.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        bt_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_salvarActionPerformed(evt);
            }
        });

        bt_editar.setFont(new java.awt.Font("Ubuntu", 0, 8)); // NOI18N
        bt_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/markConsult/imagens/Action-edit-icon (2).png"))); // NOI18N
        bt_editar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Editar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Ubuntu", 0, 11))); // NOI18N
        bt_editar.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        bt_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_editarActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/markConsult/imagens/Log-Out-icon (1).png"))); // NOI18N
        jButton2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sair", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Ubuntu", 0, 11))); // NOI18N
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTConsultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Título 1"
            }
        ));
        jTConsultas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTConsultasMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTConsultas);

        bt_data_proxima.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/markConsult/imagens/navigate-right-icon2.png"))); // NOI18N
        bt_data_proxima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_data_proximaActionPerformed(evt);
            }
        });

        bt_data_anterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/markConsult/imagens/navigate-left-icon (1).png"))); // NOI18N
        bt_data_anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_data_anteriorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(bt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(bt_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(bt_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(bt_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(bt_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(bt_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_data_anterior, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_data_proxima, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1)
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bt_buscar, bt_cancelar, bt_editar, bt_excluir, bt_novo, bt_salvar, jButton2});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bt_buscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_novo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_excluir, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(bt_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_salvar, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(bt_editar, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(bt_data_anterior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_data_proxima, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_buscar, bt_cancelar, bt_editar, bt_excluir, bt_novo, bt_salvar, jButton2});

        lbmedico.setText("Médico: ");

        tf_nomPaciente.setFocusable(false);

        bt_buscCli.setText("...");
        bt_buscCli.setFocusable(false);
        bt_buscCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_buscCliActionPerformed(evt);
            }
        });

        jLabel3.setText("Data:");

        tf_idPaciente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_idPacienteFocusLost(evt);
            }
        });
        tf_idPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_idPacienteActionPerformed(evt);
            }
        });
        tf_idPaciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_idPacienteKeyPressed(evt);
            }
        });

        jLabel2.setText("Valor:");

        tf_valor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_valorActionPerformed(evt);
            }
        });
        tf_valor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_valorFocusGained(evt);
            }
        });

        jLabel4.setText("Convênio:");

        tf_idconve.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_idconveFocusLost(evt);
            }
        });
        tf_idconve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_idconveActionPerformed(evt);
            }
        });

        tf_nomeConve.setEditable(false);

        jLabel19.setText("Pagamento: ");

        tf_codCondPagt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_codCondPagtFocusLost(evt);
            }
        });
        tf_codCondPagt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_codCondPagtActionPerformed(evt);
            }
        });
        tf_codCondPagt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_codCondPagtKeyPressed(evt);
            }
        });

        tf_condpagt.setFocusable(false);

        bt_condPagto.setText("...");
        bt_condPagto.setFocusable(false);
        bt_condPagto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_condPagtoActionPerformed(evt);
            }
        });

        jLabel6.setText("Nº convênio:");

        tf_numConve.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_numConveFocusLost(evt);
            }
        });
        tf_numConve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_numConveActionPerformed(evt);
            }
        });

        bt_buscMed.setText("...");
        bt_buscMed.setFocusable(false);
        bt_buscMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_buscMedActionPerformed(evt);
            }
        });

        tf_nomedico.setFocusable(false);

        tf_idMedico.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_idMedicoFocusLost(evt);
            }
        });
        tf_idMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_idMedicoActionPerformed(evt);
            }
        });
        tf_idMedico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_idMedicoKeyPressed(evt);
            }
        });

        jLabel1.setText("Paciente:");

        lbCli.setText("*");

        lb_med.setText("*");

        lbCodPag.setText("*");

        jLabel5.setText("Código:");

        tf_codigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_codigoFocusLost(evt);
            }
        });

        jLabel8.setText("Empresa:");

        tf_nomeEmpresa.setEditable(false);

        jLabel10.setText("Na fila:");

        tf_naFila.setEditable(false);

        jC_prioritario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NÃO", "SIM" }));

        jLabel11.setText("Prioritário");

        jLabel12.setText("Autorização:");

        jLabel7.setText("Status:");

        jC_status.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ABERTA", "ENCERRADA", "CANCELADA", "FALTOU", "AGUARDANDO", "EM CONSULTA" }));

        jLabel9.setText("Tipo Consulta:");

        jC_tipo_cons.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Consulta", "Retorno", "Procedimento" }));

        tf_idEMpresa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_idEMpresaFocusLost(evt);
            }
        });
        tf_idEMpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_idEMpresaActionPerformed(evt);
            }
        });

        bt_empresa.setText("...");
        bt_empresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_empresaActionPerformed(evt);
            }
        });

        bt_convenio.setText("...");
        bt_convenio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_convenioActionPerformed(evt);
            }
        });

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Observação:");

        tf_obs.setColumns(20);
        tf_obs.setRows(3);
        jScrollPane3.setViewportView(tf_obs);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lbmedico)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lb_med, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbCodPag, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbCli, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 11, Short.MAX_VALUE)))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tf_numConve, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jC_tipo_cons, 0, 100, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_autoriza, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tf_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jC_status, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jC_prioritario, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_naFila, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_dataConsul, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(bt_condPagto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bt_buscCli, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bt_buscMed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bt_convenio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bt_empresa))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(tf_codCondPagt, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(tf_condpagt)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tf_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(tf_idPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                                            .addComponent(tf_idMedico)
                                            .addComponent(tf_idEMpresa, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(tf_idconve))
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tf_nomeConve, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(tf_nomeEmpresa, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(tf_nomPaciente)
                                            .addComponent(tf_nomedico)))))))
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jC_prioritario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(jLabel11)
                        .addComponent(tf_naFila, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jC_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(tf_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tf_dataConsul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jC_tipo_cons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tf_numConve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel12)
                        .addComponent(tf_autoriza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbmedico)
                    .addComponent(tf_idMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_nomedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_buscMed)
                    .addComponent(lb_med))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_nomPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(lbCli)
                    .addComponent(bt_buscCli)
                    .addComponent(tf_idPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tf_nomeEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tf_idEMpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(bt_empresa)
                                .addComponent(jLabel8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tf_idconve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tf_nomeConve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(bt_convenio))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(tf_codCondPagt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_condpagt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_condPagto)
                    .addComponent(lbCodPag)
                    .addComponent(tf_valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        jTabbedPane1.addTab("Dados", jPanel1);

        jt_empresaProcedimento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jt_empresaProcedimento);

        bt_inserirProcedimento.setText("Inserir");
        bt_inserirProcedimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_inserirProcedimentoActionPerformed(evt);
            }
        });

        bt_removeProcedimento.setText("Remover");
        bt_removeProcedimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_removeProcedimentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(bt_inserirProcedimento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_removeProcedimento)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_inserirProcedimento)
                    .addComponent(bt_removeProcedimento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Procedimentos", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_salvarActionPerformed
        if (verificaCampos() == false) {
            try {
                CadConsultasDAO dao = new CadConsultasDAO();
                Date dataConve;
                Convenio convenio = new Convenio();
                Empresa empresa = new Empresa();
                String idconv = tf_idconve.getText();
                if (!idconv.equals("")) {
                    convenio.setId(Integer.parseInt(idconv));
                }
                String idEmp= tf_idEMpresa.getText();
                if (!idEmp.equals("")) {
                    empresa.setId(Integer.parseInt(idEmp));
                }
                int idPaciente = Integer.parseInt(tf_idPaciente.getText());
                int idUsuario = Integer.parseInt(tf_idMedico.getText());
                java.util.Date data_consul = tf_dataConsul.getDate();
                Integer status = jC_status.getSelectedIndex() + 1;
                String obs = tf_obs.getText();
                String autoriza = tf_autoriza.getText();
                double valor = Double.parseDouble(tf_valor.getText().replaceAll("\\.", "").replace(",", "."));

                String dataAtual = formato.format(data_consul);
                dataConve = (Date) converte(dataAtual);

                CondPagto condPagto = new CondPagto();
                Usuario usuario = new Usuario();
                usuario.setId(idUsuario);
                Paciente Paciente = new Paciente();
                Paciente.setId(idPaciente);
                Paciente.setEmpresa(empresa);
                condPagto.setId(Integer.parseInt(tf_codCondPagt.getText()));
                Tipo tipo = new Tipo(jC_tipo_cons.getSelectedIndex() + 1, null);

                String sele = tf_naFila.getText();
                boolean naFila;
                switch (sele) {
                    case "NÃO":
                    naFila = false;
                    break;
                    case "SIM":
                    naFila = true;
                    break;
                    default:
                    throw new AssertionError();
                }
                int pri = jC_prioritario.getSelectedIndex();
                boolean prioritario;
                switch (pri) {
                    case 0:
                    prioritario = false;
                    break;
                    case 1:
                    prioritario = true;
                    break;
                    default:
                    prioritario = false;
                }

                if (ins_alt == 0) {

                    Consulta consulta = new Consulta(null, convenio, Paciente, usuario, dataConve, status, null, obs, valor, condPagto, tipo, modelProcedimento.getProcedimentos(), naFila, prioritario, autoriza);
                    int id = dao.inseConsult(consulta);
                    tf_codigo.setText("" + id);

                } else if (ins_alt == 1) {

                    int id = Integer.parseInt(tf_codigo.getText());
                    Consulta consulta = new Consulta(id, convenio, Paciente, usuario, dataConve, status, null, obs, valor, condPagto, tipo, modelProcedimento.getProcedimentos(), naFila, prioritario, autoriza);
                   boolean alterado = dao.altConsult(consulta);
           
                    if (alterado) {
                        dao.removerConsultaProcedimento(procedimentoExcluir);
                    }
                }
                estadoBotoes("inicial");
                buscaConsultaPorId(tf_codigo.getText());
                ins_alt = 0;
            } catch (NumberFormatException | ParseException ex) {
                JOptionPane.showMessageDialog(null, "Data inválida!");
            }
        }
    }//GEN-LAST:event_bt_salvarActionPerformed

    private void bt_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_editarActionPerformed
        ins_alt = 1;
        estadoBotoes("novo");
        tf_numConve.setEditable(false);
        tf_idPaciente.setEditable(false);
        bt_buscCli.setEnabled(false);
    }//GEN-LAST:event_bt_editarActionPerformed

    private void bt_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_novoActionPerformed

        estadoBotoes("novo");
        limpCampos();
//            Date dt = (Date) converte(data);
//            novoCad(dt);


    }//GEN-LAST:event_bt_novoActionPerformed

    private void bt_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelarActionPerformed

        String nome = "Deseja realmente cancelar?";
        int opcao_escolhida = JOptionPane.showConfirmDialog(null, nome, "Cancelar ", JOptionPane.YES_NO_OPTION);
        if (opcao_escolhida == JOptionPane.YES_OPTION) {
            estadoBotoes("inicial");
            ins_alt = 0;
            String id = tf_codigo.getText();
            if (!id.equals("")) {
                buscaConsultaPorId(id);
            } else {
                limpCampos();
            }
        }
    }//GEN-LAST:event_bt_cancelarActionPerformed

    private void bt_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_excluirActionPerformed
        int opcao_escolhida = JOptionPane.showConfirmDialog(null, "Excluir consulta selecionada?", "Exclusão ", JOptionPane.YES_NO_OPTION, 3);
        if (opcao_escolhida == JOptionPane.YES_OPTION) {
            CadConsultasDAO dao = new CadConsultasDAO();
            dao.removerConsultaProcedimento(dao.BuscaProcedimetoEmpresa("", 'e', Integer.parseInt(tf_codigo.getText())));
            dao.rmConsult(Integer.parseInt(tf_codigo.getText()));
            limpCampos();
            estadoBotoes("inicial");
            try {
                buscaPorData();
            } catch (ParseException ex) {
                Logger.getLogger(CadConsultaModal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_bt_excluirActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void bt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_buscarActionPerformed

        ConsPorPaciente tela_busca = new ConsPorPaciente(null, true);
        tela_busca.setVisible(true);

    }//GEN-LAST:event_bt_buscarActionPerformed

    private void bt_data_anteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_data_anteriorActionPerformed
        if (bt_novo.isEnabled()) {
            limpCampos();
        }
        Date atu = pegaDataAnterior();
        if (atu != null) {
             tf_dataConsul.setDate(atu);
        }
       
    }//GEN-LAST:event_bt_data_anteriorActionPerformed

    private void bt_data_proximaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_data_proximaActionPerformed
        if (bt_novo.isEnabled()) {
            limpCampos();
        }
        Date atu = pegaProximaData();
         if (atu != null) {
        tf_dataConsul.setDate(atu);
         }
    }//GEN-LAST:event_bt_data_proximaActionPerformed

    private void jTConsultasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTConsultasMousePressed
        if (jTConsultas.isEnabled()) {

            if (evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() == 1) {
                mostra_dados(model.getItem(jTConsultas.getSelectedRow()));
            } else if (evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() == 2) {

            }
        }
    }//GEN-LAST:event_jTConsultasMousePressed

    private void bt_buscCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_buscCliActionPerformed
        telaBuscaPaciente();
    }//GEN-LAST:event_bt_buscCliActionPerformed

    private void tf_idPacienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_idPacienteFocusLost
if (tf_idPaciente.isEditable()) {
        if (!tf_idPaciente.getText().equals("")) {
            buscaPaciente();
        } else {
            tf_nomPaciente.setText("");
            tf_numConve.setText("");
            tf_idconve.setText("");
            tf_nomeConve.setText("");
            tf_valor.setText("");

        }
}
    }//GEN-LAST:event_tf_idPacienteFocusLost

    private void tf_idPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_idPacienteActionPerformed

        tf_codCondPagt.requestFocus();
    }//GEN-LAST:event_tf_idPacienteActionPerformed

    private void tf_idPacienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_idPacienteKeyPressed
        if (tf_idPaciente.isEditable()) {
            if (evt.getKeyCode() == KeyEvent.VK_F2) {
                telaBuscaPaciente();
            }
        }
    }//GEN-LAST:event_tf_idPacienteKeyPressed

    private void tf_valorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_valorActionPerformed
        tf_obs.requestFocus();
    }//GEN-LAST:event_tf_valorActionPerformed

    private void tf_valorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_valorFocusGained
        tf_valor.setSelectionStart(0);
        tf_valor.setSelectionEnd(tf_valor.getText().length());
    }//GEN-LAST:event_tf_valorFocusGained

    private void tf_codCondPagtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_codCondPagtFocusLost
        if (!tf_codCondPagt.getText().equals("")) {
            buscaCondPgto();
        } else {
            tf_condpagt.setText("");
        }
    }//GEN-LAST:event_tf_codCondPagtFocusLost

    private void tf_codCondPagtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_codCondPagtActionPerformed
        tf_valor.requestFocus();
    }//GEN-LAST:event_tf_codCondPagtActionPerformed

    private void tf_codCondPagtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_codCondPagtKeyPressed
        if (tf_codCondPagt.isEditable()) {
            if (evt.getKeyCode() == KeyEvent.VK_F2) {
                telBuscaConpagt();

            }
        }
    }//GEN-LAST:event_tf_codCondPagtKeyPressed

    private void bt_condPagtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_condPagtoActionPerformed
        telBuscaConpagt();
    }//GEN-LAST:event_bt_condPagtoActionPerformed

    private void tf_numConveFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_numConveFocusLost
        if (tf_numConve.isEditable() && !tf_numConve.getText().equals("")) {
            buscPacientePorConvenio();
        }
    }//GEN-LAST:event_tf_numConveFocusLost

    private void tf_numConveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_numConveActionPerformed

        tf_idMedico.requestFocus();
    }//GEN-LAST:event_tf_numConveActionPerformed

    private void bt_buscMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_buscMedActionPerformed
        telaBuscaUsuario();
    }//GEN-LAST:event_bt_buscMedActionPerformed

    private void tf_idMedicoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_idMedicoFocusLost
        if (!tf_idMedico.getText().equals("")) {
            buscaUsuario();
        } else {
            tf_idMedico.setText("");
        }
    }//GEN-LAST:event_tf_idMedicoFocusLost

    private void tf_idMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_idMedicoActionPerformed

        tf_idPaciente.requestFocus();
    }//GEN-LAST:event_tf_idMedicoActionPerformed

    private void tf_idMedicoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_idMedicoKeyPressed
        if (tf_idMedico.isEditable()) {
            if (evt.getKeyCode() == KeyEvent.VK_F2) {
                telaBuscaUsuario();

            }
        }
    }//GEN-LAST:event_tf_idMedicoKeyPressed

    private void tf_codigoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_codigoFocusLost
        if (tf_codigo.isEditable() && !tf_codigo.getText().equals("")) {
            buscaConsultaPorId(tf_codigo.getText());
        } else {
            //            limpCampos();
        }
    }//GEN-LAST:event_tf_codigoFocusLost

    private void bt_inserirProcedimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_inserirProcedimentoActionPerformed
        telaBuscaProced();
    }//GEN-LAST:event_bt_inserirProcedimentoActionPerformed

    private void bt_removeProcedimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_removeProcedimentoActionPerformed
           List<ConsultaProcedimento> emp = modelProcedimento.removeProcedimentosSelecionados();
        if (!emp.isEmpty()) {
            procedimentoExcluir.addAll(emp);
             calculaTotal();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um procedimento");
        }
    }//GEN-LAST:event_bt_removeProcedimentoActionPerformed

    private void bt_empresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_empresaActionPerformed
        telBuscaEmpresa();
    }//GEN-LAST:event_bt_empresaActionPerformed

    private void bt_convenioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_convenioActionPerformed
        telBuscaConvenio();
    }//GEN-LAST:event_bt_convenioActionPerformed

    private void tf_idEMpresaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_idEMpresaFocusLost
      if (tf_idEMpresa.isEditable()) {
        if (!tf_idEMpresa.getText().equals("")) {
            buscaEmpresaPorId(tf_idEMpresa.getText());
        } else {
            tf_nomeEmpresa.setText("");
        }
       }
    }//GEN-LAST:event_tf_idEMpresaFocusLost

    private void tf_idconveFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_idconveFocusLost
      if (tf_idconve.isEditable()) {
        if (!tf_idconve.getText().equals("")) {
            buscaConvenioPorId(tf_idconve.getText());
        } else {
            tf_nomeConve.setText("");
        }
       }
    }//GEN-LAST:event_tf_idconveFocusLost

    private void tf_idEMpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_idEMpresaActionPerformed
        tf_idconve.requestFocus();
    }//GEN-LAST:event_tf_idEMpresaActionPerformed

    private void tf_idconveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_idconveActionPerformed
         tf_codCondPagt.requestFocus();
    }//GEN-LAST:event_tf_idconveActionPerformed

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
            java.util.logging.Logger.getLogger(CadConsultaModal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>        //</editor-fold>
        //</editor-fold>        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            CadConsultaModal dialog = new CadConsultaModal(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton bt_buscCli;
    private javax.swing.JButton bt_buscMed;
    private javax.swing.JButton bt_buscar;
    private javax.swing.JButton bt_cancelar;
    private javax.swing.JButton bt_condPagto;
    private javax.swing.JButton bt_convenio;
    private javax.swing.JButton bt_data_anterior;
    private javax.swing.JButton bt_data_proxima;
    private javax.swing.JButton bt_editar;
    private javax.swing.JButton bt_empresa;
    private javax.swing.JButton bt_excluir;
    private javax.swing.JButton bt_inserirProcedimento;
    private javax.swing.JButton bt_novo;
    private javax.swing.JButton bt_removeProcedimento;
    private javax.swing.JButton bt_salvar;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jC_prioritario;
    private javax.swing.JComboBox jC_status;
    private javax.swing.JComboBox jC_tipo_cons;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTConsultas;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jt_empresaProcedimento;
    private javax.swing.JLabel lbCli;
    private javax.swing.JLabel lbCodPag;
    private javax.swing.JLabel lb_med;
    private javax.swing.JLabel lbmedico;
    private javax.swing.JTextField tf_autoriza;
    private javax.swing.JTextField tf_codCondPagt;
    private javax.swing.JTextField tf_codigo;
    private javax.swing.JTextField tf_condpagt;
    private com.toedter.calendar.JDateChooser tf_dataConsul;
    private javax.swing.JTextField tf_idEMpresa;
    private javax.swing.JTextField tf_idMedico;
    private javax.swing.JTextField tf_idPaciente;
    private javax.swing.JTextField tf_idconve;
    private javax.swing.JTextField tf_naFila;
    private javax.swing.JTextField tf_nomPaciente;
    private javax.swing.JTextField tf_nomeConve;
    private javax.swing.JTextField tf_nomeEmpresa;
    private javax.swing.JTextField tf_nomedico;
    private javax.swing.JTextField tf_numConve;
    private javax.swing.JTextArea tf_obs;
    private javax.swing.JTextField tf_valor;
    // End of variables declaration//GEN-END:variables
public final java.util.Date converte(String dataConsul) throws ParseException {
        DateFormat forma = new SimpleDateFormat("dd/MM/yyyy");
        java.sql.Date dat = new java.sql.Date(forma.parse(dataConsul).getTime());

        return dat;
    }

    public void telaBuscaPaciente() {
        BuscaPacientesModal telBuscClie = new BuscaPacientesModal(null, true);
        telBuscClie.setVisible(true);

        if (telBuscClie.okselecionado()) {
            Paciente p = telBuscClie.retornCliSele();
                mostraPaciente(p);
        }

    }
    
     public void telBuscaEmpresa() {
        BuscaEmpresas pcp = new BuscaEmpresas(null, true);
        pcp.getRootPane().setWindowDecorationStyle(JRootPane.COLOR_CHOOSER_DIALOG);
        pcp.setVisible(true);

        if (pcp.okselecionado()) {

            Empresa emp = pcp.retornCliSele();
            mostrar_dados_empresa(emp);
        }

    }

    public void buscaEmpresaPorId(String id) {
        CadEmpresaDAO dao = new CadEmpresaDAO();
        Empresa empresa = dao.buscaEmpresaPorId(Integer.parseInt(id));
        if (empresa == null) {
            JOptionPane.showMessageDialog(null, "Empresa não cadastrada!");
            tf_idEMpresa.requestFocus();
        }
        mostrar_dados_empresa(empresa);
    }
    private void mostrar_dados_empresa(Empresa emp) {
        if (emp != null) {
            tf_idEMpresa.setText(emp.getId().toString());
            tf_nomeEmpresa.setText(emp.getFantasia());
        }
    }
    
    
public void telBuscaConvenio(){
         BuscaConvenios tc = new BuscaConvenios(null, true);
        tc.setVisible(true);

        if (tc.okselecionado()) {
            Convenio c = tc.retornEspSele();
            mostrar_dados_convenio(c);
        }
        tc.dispose();
}
   public void buscaConvenioPorId(String id) {
    if (!id.equals("")) {
      CadConvenioDAO dao = new CadConvenioDAO();
        Convenio convenio = dao.procuraPorID(Integer.parseInt(id));
        if(convenio==null){
            JOptionPane.showMessageDialog(null, "Convênio "+id+" não existe!");
             tf_idconve.requestFocus();
        }
        mostrar_dados_convenio(convenio);
    }
}
    public void mostrar_dados_convenio(Convenio convenio) {
        if(convenio!=null){
                tf_idconve.setText("" + convenio.getId());
                tf_nomeConve.setText(convenio.getDsConvenio());

        }
    }
    private void mostraPaciente(Paciente p ){
        if (p != null) {
            tf_numConve.setText(p.getNumConvenio());
            tf_idPaciente.setText(p.getId().toString());
            tf_nomPaciente.setText(p.getNome());
            if (p.getConvenio() != null) {
                tf_idconve.setText(p.getConvenio().getId().toString());
                tf_nomeConve.setText(p.getConvenio().getDsConvenio());
            }
            tf_idEMpresa.setText(p.getEmpresa().getId().toString());
            tf_nomeEmpresa.setText(p.getEmpresa().getFantasia());
            lbCli.setForeground(Color.BLACK);
        }
    }
    public void telaBuscaProced() {
        if(tf_idEMpresa.getText().equals("0") || tf_idEMpresa.getText().equals("")){
              JOptionPane.showMessageDialog(null, "Paciente sem empresa!");
        }else{
            BuscaProcedimentosSelecao telBuscProc = new BuscaProcedimentosSelecao(null, true);
            telBuscProc.setIdEmpresa(Integer.parseInt(tf_idEMpresa.getText()));
            ArrayList<EmpresaProcedimento> procedimentos = new ArrayList<>();
            
            modelProcedimento.getProcedimentos().stream().forEach((consultaProcedimento) -> {
                procedimentos.add(consultaProcedimento.getEmpresaProcedimento());
            });
            telBuscProc.jaContem(procedimentos);
            telBuscProc.setVisible(true);
            if (telBuscProc.okselecionado()) {
                ArrayList<EmpresaProcedimento> p = telBuscProc.getValorSelecionado();
                if (p != null) {
                    p.stream().map((empresaProcedimento) -> {
                        ConsultaProcedimento consultaProcedimento = new ConsultaProcedimento();
                        consultaProcedimento.setEmpresaProcedimento(empresaProcedimento);
                        consultaProcedimento.setValor(empresaProcedimento.getValor());
                        return consultaProcedimento;
                    }).map((consultaProcedimento) -> {
                        consultaProcedimento.setSelecao(false);
                        return consultaProcedimento;
                    }).map((consultaProcedimento) -> {
                        consultaProcedimento.setStatus("FALTA");
                        return consultaProcedimento;
                    }).map((consultaProcedimento) -> {
                        modelProcedimento.inserir(consultaProcedimento);
                        return consultaProcedimento;
                    }).forEach((_item) -> {
                        calculaTotal();
                    });

                }
            }
        }
    }
    private void calculaTotal() {
        BigDecimal total = new BigDecimal(BigInteger.ZERO);
        List<ConsultaProcedimento> con = modelProcedimento.getProcedimentos();
        for (ConsultaProcedimento consultaProcedimento : con) {
            total = total.add(new BigDecimal(consultaProcedimento.getValor()));
        }
        DecimalFormat decFormat = new DecimalFormat("#,###,##0.00");
        tf_valor.setText(decFormat.format(total));
    }
    public void telaBuscaUsuario() {
        BuscaMedicos telBuscClie = new BuscaMedicos(null, true);
        telBuscClie.setVisible(true);

        if (telBuscClie.okselecionado()) {
            Usuario cm = telBuscClie.retornMedSele();
            if (cm != null) {
                tf_idMedico.setText(cm.getId().toString());
                tf_nomedico.setText(cm.getNome());
                lb_med.setForeground(Color.BLACK);

            }
        }

    }

    public void telBuscaConpagt() {
        BuscaCondPagt cp = new BuscaCondPagt(null, true);
        cp.setVisible(true);

        if (cp.okselecionado()) {
            CondPagto c = cp.retornEspSele();
            tf_codCondPagt.setText(c.getId().toString());
            tf_condpagt.setText(c.getCondPagt());
        }
        cp.dispose();

    }

    private Date pegadataAtual() {
        Date dataConve = null;
        try {
            java.util.Date data_consul = tf_dataConsul.getDate();
            String dataAtual = formato.format(data_consul);

            dataConve = (Date) converte(dataAtual);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Data inválida");
        }

        return dataConve;

    }

    public void mostra_dados(Consulta c) {
        if (c != null) {
            CadConsultasDAO dao = new CadConsultasDAO();
            modelProcedimento.listar(dao.BuscaProcedimetoEmpresa("",'e',c.getId()));
            tf_codigo.setText(c.getId().toString());
            mostraPaciente(c.getPaciente());
            tf_codCondPagt.setText("" + c.getCondPagt().getId());
            tf_condpagt.setText(c.getCondPagt().getCondPagt());
            tf_idMedico.setText(c.getUsuario().getId().toString());
            tf_nomedico.setText(c.getUsuario().getNome());
            tf_obs.setText(c.getObs());
            jC_status.setSelectedIndex(c.getStatus() - 1);
            jC_tipo_cons.setSelectedIndex(c.getTipo().getId() - 1);
            tf_dataConsul.setDate(c.getDataConsulta());

            if (c.isFila()) {
                tf_naFila.setText("SIM");
            } else {
                tf_naFila.setText("NÃO");
            }
            if (c.getConvenio().getId() != 0) {
                tf_idconve.setText(c.getConvenio().getId().toString());
                tf_nomeConve.setText(c.getConvenio().getDsConvenio());
            } else {
                tf_idconve.setText("");
                tf_nomeConve.setText("");
            }

            if (c.isPrioritario()) {
                jC_prioritario.setSelectedIndex(1);
            } else {
                jC_prioritario.setSelectedIndex(0);
            }
            tf_valor.setText("" + c.getValor());
            tf_obs.setText(c.getObs());
            tf_autoriza.setText(c.getCodAutorizacao());
           
                
            
        }
    }

    public void limpCampos() {
        if (ins_alt != 1) {
            tf_codigo.setText("");
            tf_numConve.setText("");
            tf_idPaciente.setText("");
            tf_nomPaciente.setText("");
            tf_codCondPagt.setText("");
            tf_condpagt.setText("");
            tf_idconve.setText("");
            tf_nomeConve.setText("");
            tf_obs.setText("");
            tf_valor.setText("0,00");
            tf_idMedico.setText("");
            tf_nomedico.setText("");
            jC_status.setSelectedIndex(0);
            jC_tipo_cons.setSelectedIndex(0);
            tf_naFila.setText("NÃO");
            tf_idEMpresa.setText("");
            tf_nomeEmpresa.setText("");
            jC_prioritario.setSelectedIndex(0);
            //tf_dataConsul.setDate(null);
            tf_autoriza.setText("");
            modelProcedimento.limparTabela();
        }
    }

    public void buscaCondPgto() {
        ICadCondPagtoDAO dao = new CadCondPagtoDAO();
        CondPagto condPagto = dao.procuraPorID(Integer.parseInt(tf_codCondPagt.getText()));
        if (condPagto != null) {
            tf_codCondPagt.setText(condPagto.getId().toString());
            tf_condpagt.setText(condPagto.getCondPagt());
            lbCodPag.setForeground(Color.BLACK);
            tf_valor.requestFocus();

        } else {
            JOptionPane.showMessageDialog(null, "Condição de Pagamento não cadastrada!", "Informação", JOptionPane.INFORMATION_MESSAGE);
            tf_codCondPagt.requestFocus();
        }

    }

    public void buscaPaciente() {
        ICadPacienteDAO dao = new CadPacienteDAO();

        Paciente paciente = dao.buscaPacientePorId(Integer.parseInt(tf_idPaciente.getText()));
        if (paciente != null) {
            mostraPaciente(paciente);

        } else {
            JOptionPane.showMessageDialog(null, "Paciente não cadastrado!", "Informação", JOptionPane.INFORMATION_MESSAGE);
            tf_idPaciente.requestFocus();

        }

    }

    public void buscaUsuario() {
        CadUsuarioDAO dao = new CadUsuarioDAO();

        Usuario usuario = dao.procuraPorID(Integer.parseInt(tf_idMedico.getText()));
        if (usuario != null) {
            tf_idMedico.setText(usuario.getId().toString());
            tf_nomedico.setText(usuario.getNome());
            lb_med.setForeground(Color.BLACK);

        } else {
            JOptionPane.showMessageDialog(null, "Médico não cadastrado!", "Informação", JOptionPane.INFORMATION_MESSAGE);
            tf_idMedico.requestFocus();

        }

    }

    public void buscPacientePorConvenio() {
        ICadPacienteDAO dao = new CadPacienteDAO();

        Paciente paciente = dao.buscaPacientePorConsulta(tf_numConve.getText());
        if (paciente != null) {
            mostraPaciente(paciente);
            tf_nomPaciente.setForeground(Color.BLACK);

        } else {
            JOptionPane.showMessageDialog(null, "Paciente não cadastrado ou sem Convênio!", "Informação", JOptionPane.INFORMATION_MESSAGE);
            tf_numConve.requestFocus();

        }
    }

    public final  void estadoBotoes(String botao) {
        if ("inicial".equals(botao)) {
            bt_novo.setEnabled(true);
            bt_cancelar.setEnabled(false);
            bt_editar.setEnabled(true);
            bt_salvar.setEnabled(false);
            bt_excluir.setEnabled(true);
            bt_buscCli.setEnabled(false);
            bt_condPagto.setEnabled(false);
            bt_buscMed.setEnabled(false);
            bt_empresa.setEnabled(false);
            bt_convenio.setEnabled(false);
            jC_status.setEnabled(false);
            jC_tipo_cons.setEnabled(false);
            jC_prioritario.setEnabled(false);
            jTConsultas.setEnabled(true);
            bt_removeProcedimento.setEnabled(false);
            bt_inserirProcedimento.setEnabled(false);

            tf_codigo.setEditable(true);
            tf_numConve.setEditable(false);
            tf_idPaciente.setEditable(false);
            tf_nomPaciente.setEditable(false);
            tf_idEMpresa.setEditable(false);
            tf_idconve.setEditable(false);
            tf_nomeConve.setEditable(false);
            tf_obs.setEditable(false);
            tf_valor.setEditable(false);
            tf_codCondPagt.setEditable(false);
            tf_condpagt.setEditable(false);
            tf_idMedico.setEditable(false);
            tf_idPaciente.setEditable(false);
            tf_dataConsul.setEnabled(false);
            tf_nomeEmpresa.setEditable(false);
            tf_autoriza.setEditable(false);

            lb_med.setForeground(Color.black);
            lbCli.setForeground(Color.black);
            lbCodPag.setForeground(Color.black);
        }

        if ("novo".equals(botao)) {
            bt_novo.setEnabled(false);
            bt_cancelar.setEnabled(true);
            bt_editar.setEnabled(true);
            bt_excluir.setEnabled(false);
            bt_editar.setEnabled(false);
            bt_salvar.setEnabled(true);
            bt_buscCli.setEnabled(true);
            bt_condPagto.setEnabled(true);
            bt_buscMed.setEnabled(true);
            bt_empresa.setEnabled(true);
            bt_convenio.setEnabled(true);
            jC_status.setEnabled(true);
            jC_tipo_cons.setEnabled(true);
            jC_prioritario.setEnabled(true);
            jTConsultas.setEnabled(false);
            bt_removeProcedimento.setEnabled(true);
            bt_inserirProcedimento.setEnabled(true);
            
            tf_codigo.setEditable(false);
            tf_numConve.setEditable(true);
            tf_idPaciente.setEditable(true);
            tf_idEMpresa.setEditable(true);
            tf_idconve.setEditable(true);
            tf_obs.setEditable(true);
            tf_valor.setEditable(true);
            tf_codCondPagt.setEditable(true);
            tf_codCondPagt.setEnabled(true);
            tf_idMedico.setEditable(true);
            tf_idPaciente.setEditable(true);
            tf_dataConsul.setEnabled(true);
            tf_autoriza.setEditable(true);

        }

        if ("cancelar".equals(botao)) {

            estadoBotoes("inicial");
        }
        if ("salvar".equals(botao)) {
            estadoBotoes("inicial");

        }

        if ("buscar".equals(botao)) {
            estadoBotoes("inicial");

        }

    }

    public boolean verificaCampos() {
        boolean ok = false;
        if (tf_idMedico.getText().equals("")) {
            lb_med.requestFocus();
            lb_med.setForeground(Color.red);
            ok = true;
        }
        if (tf_idPaciente.getText().equals("")) {
            lbCli.requestFocus();
            lbCli.setForeground(Color.red);
            ok = true;
        }
        if (tf_codCondPagt.getText().equals("")) {

            lbCodPag.setForeground(Color.red);
            ok = true;
        }

        return ok;
    }

    public void buscaConsultaPorId(String id) {
        CadConsultasDAO dao = new CadConsultasDAO();
        Consulta c = dao.procuraPorID(Integer.parseInt(id));
        if (c != null) {
            mostra_dados(c);
        } else {
            JOptionPane.showMessageDialog(null, "Cadastro " + id + " não existe!");
            tf_codigo.requestFocus();
            limpCampos();
        }

    }

    public void mudaIserirAlt(int valor) {
        ins_alt = valor;
    }

    public void novoCad(Date data) throws ParseException {
        limpCampos();
        tf_numConve.setEditable(true);
        tf_numConve.requestFocus();
        tf_dataConsul.setDate(data);
        estadoBotoes("novo");
        ins_alt = 0;

    }

    private void ajusTabela() {
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
        direita.setHorizontalAlignment(SwingConstants.RIGHT);

        jTConsultas.getColumnModel().getColumn(0).setMinWidth(60);
        jTConsultas.getColumnModel().getColumn(0).setMaxWidth(60);
        jTConsultas.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTConsultas.getColumnModel().getColumn(2).setPreferredWidth(140);
        jTConsultas.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTConsultas.getColumnModel().getColumn(4).setPreferredWidth(60);
        jTConsultas.getColumnModel().getColumn(4).setCellRenderer(direita);
        jTConsultas.getColumnModel().getColumn(5).setPreferredWidth(100);
        jTConsultas.getColumnModel().getColumn(6).setPreferredWidth(100);
        jTConsultas.getColumnModel().getColumn(7).setPreferredWidth(100);
        jTConsultas.getColumnModel().getColumn(8).setPreferredWidth(100);
        jTConsultas.getColumnModel().getColumn(9).setPreferredWidth(200);
        jTConsultas.getColumnModel().getColumn(10).setPreferredWidth(1000);
    }

    private void buscaPorData() throws ParseException {

        CadConsultasDAO dao = new CadConsultasDAO();

        model.listar(dao.buscConsEProcedimentoPorData(pegadataAtual()));

    }

    private Date pegaProximaData() {
        Date dataConve = null;
        try {
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(pegadataAtual());
            calendar.add(Calendar.DAY_OF_MONTH, +1);

            dataConve = (Date) converte(new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime()));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Data inválida!");
        }
        return dataConve;

    }

    private Date pegaDataAnterior() {
        Date dataConve = null;
        try {
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(pegadataAtual());
            calendar.add(Calendar.DAY_OF_MONTH, -1);

            dataConve = (Date) converte(new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime()));
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Data inválida!");
        }
        return dataConve;

    }


    void setPaciente(Paciente cliente) {
        tf_idPaciente.setText(cliente.getId().toString());
        tf_idMedico.requestFocus();
      }

}
