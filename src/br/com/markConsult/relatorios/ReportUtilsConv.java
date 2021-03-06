/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.markConsult.relatorios;

import java.awt.BorderLayout;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;





/**
 * Classe com métodos utilitários para executar e abrir relatórios.
 *
 * @author David Buzatto
 */
public class ReportUtilsConv {
 
    /**
     * Abre um relatório usando uma conexão como datasource.
     *
     * @param titulo Título usado na janela do relatório.
     * @param inputStream InputStream que contém o relatório.
     * @param parametros Parâmetros utilizados pelo relatório.
     * @param conexao Conexão utilizada para a execução da query.
     * @throws JRException Caso ocorra algum problema na execução do relatório
     */
   public static void openReport(
            String titulo,
            InputStream inputStream,
            Map parametros,
            Connection conex ) throws JRException {
 
//        /*
//         * Cria um JasperPrint, que é a versão preenchida do relatório,
//         * usando uma conexão.
//         */
        JasperPrint print = JasperFillManager.fillReport(
                inputStream, parametros, conex );
 
        // abre o JasperPrint em um JFrame
        viewReportFrame( titulo, print );
 
    }
// 
    /**
     * Abre um relatório usando um datasource genérico.
     *
     * @param titulo Título usado na janela do relatório.
     * @param inputStream InputStream que contém o relatório.
     * @param parametros Parâmetros utilizados pelo relatório.
     * @param dataSource Datasource a ser utilizado pelo relatório.
     * @throws JRException Caso ocorra algum problema na execução do relatório
     */
//  public static void openReport(
//            String titulo,
//            InputStream inputStream,
//            Map parametros,
//            JRDataSource dat ) throws JRException {
// 
//        /*
//         * Cria um JasperPrint, que é a versão preenchida do relatório,
//         * usando um datasource genérico.
//         */
//        JasperPrint print = JasperFillManager.fillReport(inputStream, parametros, dat );
// 
//        // abre o JasperPrint em um JFrame
//        
//        JasperViewer viewer = new JasperViewer(print, false);  
//            viewer.setVisible(true); 
// 
//    }
 
//    /**
//     * Cria um JFrame para exibir o relatório representado pelo JasperPrint.
//     *
//     * @param titulo Título do JFrame.
//     * @param print JasperPrint do relatório.
//     */
    private static void viewReportFrame( String titulo, JasperPrint print ) {
 
        /*
         * Cria um JRViewer para exibir o relatório.
         * Um JRViewer é uma JPanel.
         */
        JRViewer viewer = new JRViewer( print );
 
        // cria o JFrame
        JFrame frameRelatorio = new JFrame( titulo );
 
        // adiciona o JRViewer no JFrame
        frameRelatorio.add( viewer, BorderLayout.CENTER );
 
        // configura o tamanho padrão do JFrame
        frameRelatorio.setSize( 500, 500 );
 
        // maximiza o JFrame para ocupar a tela toda.
        frameRelatorio.setExtendedState( JFrame.MAXIMIZED_BOTH );
 
        // configura a operação padrão quando o JFrame for fechado.
        frameRelatorio.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        
        ImageIcon icone = new ImageIcon("report.png");
        frameRelatorio.setIconImage(icone.getImage());
        // exibe o JFrame
        frameRelatorio.setVisible(true);
 
    }
 
}
