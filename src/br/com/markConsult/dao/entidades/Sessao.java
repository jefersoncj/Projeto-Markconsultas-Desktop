/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.markConsult.dao.entidades;

/**
 *
 * @author jeferson
 */
public class Sessao {
    private static Sessao instance = null;  
   private Usuario usuario;  
   private Empresa empresa;  
  
   private Sessao(){  
   }  
  
   public void setUsuario(Usuario usuario){  
      this.usuario = usuario;  
   }  
   public void setEmpresa(Empresa empresa){  
      this.empresa = empresa;  
   }
   public Usuario getUsuario(){  
       return usuario;  
   }  
   public Empresa getEmpresa(){  
       return empresa;  
   }  
   public static Sessao getInstance(){  
         if(instance == null){  
               instance = new Sessao();  
         }  
        return instance;  
   }  
}
