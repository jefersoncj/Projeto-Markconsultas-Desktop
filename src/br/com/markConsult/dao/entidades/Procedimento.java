/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.markConsult.dao.entidades;

/**
 *
 * @author jeferson
 */
public class Procedimento {
    
    private Integer id;
    private String dsProcedimento;
    private double valorProced;
    
    public Procedimento(){
        
    }

    public Procedimento(Integer id) {
        this.id = id;
    }

    public Procedimento(Integer id, String dsProcedimento) {
        this.id = id;
        this.dsProcedimento = dsProcedimento;
    }

      
    public Procedimento(Integer id, String dsProcedimento, double valorProced) {
        this.id = id;
        this.dsProcedimento = dsProcedimento;
        this.valorProced = valorProced;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDsProcedimento() {
        return dsProcedimento;
    }

    public void setDsProcedimento(String dsProcedimento) {
        this.dsProcedimento = dsProcedimento;
    }

    public double getValorProced() {
        return valorProced;
    }

    public void setValorProced(double valorProced) {
        this.valorProced = valorProced;
    }

  
}
