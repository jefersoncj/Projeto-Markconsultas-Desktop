package br.com.markConsult.classesMetodos;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import br.com.markConsult.dao.entidades.Procedimento;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;




/**
 *
 * @author jeferson
 */
public class ProcedimentosTableModel extends AbstractTableModel{
     NumberFormat nf = new DecimalFormat("#,##0.00");
//constantes que vão representar as colunas
    private final int COL_ID = 0;
    private final int COL_CONV = 1;
    private final int COL_VALOR = 2;

    
    //lista dos produtos que serão exibidos
    private List<Procedimento> procedimentos;
            
    
     public ProcedimentosTableModel() {
        procedimentos = new ArrayList();
    }
     
      public ProcedimentosTableModel(List<Procedimento> lista) {
        this();
        procedimentos.addAll(lista);
    }
            
            
            
    @Override
    public int getRowCount() {
      //cada produto na lista será uma linha
    
        return procedimentos.size();    
    }

    @Override
    public int getColumnCount() {
       
      //Quantidade de colunas
        return 3;
    }

    
      @Override
    public String getColumnName(int column) {
        //qual o nome da coluna
        if (column == COL_ID) {
            return "Código";
        
        }else if (column == COL_CONV) {
            return "Convênio";
        
        }else if (column == COL_VALOR) {
            return "Valor";
        
        }
        
        return "";
    }
      
      @Override
    public Class getColumnClass(int columnIndex) {
       // retorna a classe que representa a coluna
        if (columnIndex == COL_ID) {
            return int.class;
        } else if (columnIndex == COL_CONV) {
            return String.class;
        } else if (columnIndex == COL_VALOR) {
            return String.class;
       }
       
        return String.class;
      }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //pega o produto da linha
        Procedimento u = procedimentos.get(rowIndex);
 
        //verifica qual valor deve ser retornado
        if (columnIndex == COL_ID){
            return u.getId();
        } 
        else if (columnIndex == COL_CONV) {
            return u.getDsProcedimento();
        }
        else if (columnIndex == COL_VALOR) {
            return nf.format(u.getValorProced());
        }
      
        return "";
    
    }
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

        fireTableDataChanged();
    }
      
    
     @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        //no nosso caso todas não vão ser editáveis, entao retorna false pra todas
        return false;
    }
     
     public void listar(List<Procedimento> c) {
        procedimentos.clear();
        procedimentos = c;
 
        fireTableDataChanged();
    }
 
    public Procedimento getItem(int pos) {
        if (pos < 0 || pos >= procedimentos.size()) {
            return null;
        }
 
        return procedimentos.get(pos);
    }
}
