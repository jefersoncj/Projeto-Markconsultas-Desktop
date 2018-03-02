/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.markConsult.dao;

import br.com.markConsult.dao.entidades.Paciente;
import br.com.markConsult.dao.entidades.CondPagto;
import br.com.markConsult.dao.entidades.Consulta;
import br.com.markConsult.dao.entidades.Convenio;
import br.com.markConsult.dao.entidades.Usuario;
import br.com.markConsult.dao.entidades.Procedimento;
import br.com.markConsult.dao.entidades.Tipo;
import br.com.markConsult.relatorios.ReportUtils;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author jeferson
 */
public class CadConsultasDAO extends AbstractConecxaoDAO implements ICadConsultasDAO{
    /**
	 * @uml.property  name="idInserido"
	 */
	Integer idInserido = null;
	/**
	 * @uml.property  name="consulta"
	 * @uml.associationEnd  
	 */
	Consulta consulta = null;
        boolean idAlterado;
	/**
	 * @uml.property  name="consultas"
	 */
	

    public CadConsultasDAO() {
        this.idAlterado = false;
    }
    private final ArrayList<Consulta> consultas = new ArrayList<>();
    @Override
    public Integer inseConsult(Consulta consulta) {
                Connection connection = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			// pegar a connection
			connection = getConnection();
			beginTransaction(connection);
			// GERAR O ID UNICO
			
                        String selectMaxSEQ = "SELECT MAX(sequencia) AS maxSEQ FROM consultas WHERE data_consulta = '"+consulta.getDataConsulta()+"' ";
                        int maxSEQ = 0;
                        
                        pstm = connection.prepareStatement(selectMaxSEQ);
			rs = pstm.executeQuery();
			while (rs.next()) {
				maxSEQ = rs.getInt(1);
			}
                        
                        String sql;
                        Integer idConv = consulta.getConvenio().getId();
                        Integer idProc = consulta.getProcedimento().getId();
                         if (idConv == null && idProc == null) {
                             sql = "INSERT INTO consultas (id_paciente, data_consulta, status, sequencia, "
                                     + "obs, valor, id_cond_pagto, id_medico,cod_tipo,prioritario,cod_autorizacao)VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)";
                             pstm = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                             int index = 0;
                            pstm.setInt(++index, consulta.getPaciente().getId());
                            pstm.setDate(++index, consulta.getDataConsulta());
                            pstm.setInt(++index, consulta.getStatus());
                            pstm.setInt(++index, ++maxSEQ);
                            pstm.setString(++index, consulta.getObs());
                            pstm.setDouble(++index, consulta.getValor());
                            pstm.setInt(++index, consulta.getCondPagt().getId());
                            pstm.setInt(++index, consulta.getUsuario().getId());
                            pstm.setInt(++index, consulta.getTipo().getId());
                            pstm.setBoolean(++index, consulta.isPrioritario());
                            pstm.setString(++index, consulta.getCodAutorizacao());
                            
                            
                        }else if(idConv != null && idProc == null){
			
			 sql = "INSERT INTO consultas (id_convenio, id_paciente, data_consulta, status, sequencia,"
                                 + " obs, valor, id_cond_pagto, id_medico, cod_tipo, prioritario,cod_autorizacao)"
                                 + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                         pstm = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                         
                            int index = 0;
                            pstm.setInt(++index, idConv);
                            pstm.setInt(++index, consulta.getPaciente().getId());
                            pstm.setDate(++index, consulta.getDataConsulta());
                            pstm.setInt(++index, consulta.getStatus());
                            pstm.setInt(++index, ++maxSEQ);
                            pstm.setString(++index, consulta.getObs());
                            pstm.setDouble(++index, consulta.getValor());
                            pstm.setInt(++index, consulta.getCondPagt().getId());
                            pstm.setInt(++index, consulta.getUsuario().getId());
                            pstm.setInt(++index, consulta.getTipo().getId());
                            pstm.setBoolean(++index, consulta.isPrioritario());
                            pstm.setString(++index, consulta.getCodAutorizacao());
                         }
                         else if(idProc != null && idConv == null){
			
			 sql = "INSERT INTO consultas (id_paciente, data_consulta, status, sequencia,"
                                 + " obs, valor, id_cond_pagto, id_medico, cod_tipo, cod_procedimento,prioritario,cod_autorizacao)"
                                 + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?)";
                         pstm = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                         
                            int index = 0;
                            pstm.setInt(++index, consulta.getPaciente().getId());
                            pstm.setDate(++index, consulta.getDataConsulta());
                            pstm.setInt(++index, consulta.getStatus());
                            pstm.setInt(++index, ++maxSEQ);
                            pstm.setString(++index, consulta.getObs());
                            pstm.setDouble(++index, consulta.getValor());
                            pstm.setInt(++index, consulta.getCondPagt().getId());
                            pstm.setInt(++index, consulta.getUsuario().getId());
                            pstm.setInt(++index, consulta.getTipo().getId());
                            pstm.setInt(++index, consulta.getProcedimento().getId());
                            pstm.setBoolean(++index, consulta.isPrioritario());
                            pstm.setString(++index, consulta.getCodAutorizacao());
                         }
                           else if(idConv != null && idProc != null ){
			
			 sql = "INSERT INTO consultas (id_convenio, id_paciente, data_consulta, status, sequencia, "
                                 + "obs, valor, id_cond_pagto, id_medico, cod_tipo, cod_procedimento, prioritario, cod_autorizacao)"
                                 + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                         pstm = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                         
                            int index = 0;
                            pstm.setInt(++index, idConv);
                            pstm.setInt(++index, consulta.getPaciente().getId());
                            pstm.setDate(++index, consulta.getDataConsulta());
                            pstm.setInt(++index, consulta.getStatus());
                            pstm.setInt(++index, ++maxSEQ);
                            pstm.setString(++index, consulta.getObs());
                            pstm.setDouble(++index, consulta.getValor());
                            pstm.setInt(++index, consulta.getCondPagt().getId());
                            pstm.setInt(++index, consulta.getUsuario().getId());
                            pstm.setInt(++index, consulta.getTipo().getId());
                            pstm.setInt(++index, consulta.getProcedimento().getId());
                            pstm.setBoolean(++index, consulta.isPrioritario());
                            pstm.setString(++index, consulta.getCodAutorizacao());
                         }
			
			// executar
			pstm.executeUpdate();
                        rs = pstm.getGeneratedKeys();  
                        int id = 0;  
                        if(rs.next()){  
                         id = rs.getInt(1);  
                        }
			commitTransaction(connection);
			idInserido = id;
			
		} catch (Exception e) {
			
			try {
				rollbackTransaction(connection);
			} catch (SQLException e1) {
				throw new IllegalStateException();
			}
		} finally {
			cleanup(rs, pstm, connection);
		}
		return idInserido; 
    }

    @Override
    public boolean altConsult(Consulta consulta) {
                Connection connection = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
                    
            // pegar a connection
                connection = getConnection();
                beginTransaction(connection);
              
                        // criar o sql
                String sql;
                Integer codProce = consulta.getProcedimento().getId();
                    if (codProce == null || codProce == 0) {
                        sql = "UPDATE consultas SET id_convenio = ? , id_paciente = ?, obs = ?, data_consulta = ?, "
                        + "valor = ?, id_cond_pagto = ? , id_medico = ?, status = ?, cod_tipo = ?, cod_procedimento = ?, fila = ?, prioritario = ?, cod_autorizacao = ?  WHERE id = ?"; 
                         pstm = connection.prepareStatement(sql);
                          // setar os params      
                        int index = 0;
                        pstm.setInt(++index, consulta.getConvenio().getId());
                        pstm.setInt(++index, consulta.getPaciente().getId());
                        pstm.setString(++index, consulta.getObs());
                        pstm.setDate(++index, consulta.getDataConsulta());
                        pstm.setDouble(++index, consulta.getValor());
                        pstm.setInt(++index, consulta.getCondPagt().getId());
                        pstm.setInt(++index, consulta.getUsuario().getId());
                        pstm.setInt(++index, consulta.getStatus());
                        pstm.setInt(++index, consulta.getTipo().getId());
                        pstm.setNull(++index, java.sql.Types.INTEGER );
                        pstm.setBoolean(++index, consulta.isFila());
                        pstm.setBoolean(++index, consulta.isPrioritario());
                        pstm.setString(++index, consulta.getCodAutorizacao());
                        pstm.setInt(++index, consulta.getId());
                    }else{
                           sql = "UPDATE consultas SET id_convenio = ? , id_paciente = ?, obs = ?, data_consulta = ?, "
                        + "valor = ?, id_cond_pagto = ? , id_medico = ?, status = ?, cod_tipo = ?, cod_procedimento = ?, fila = ?, prioritario = ?, cod_autorizacao = ? WHERE id = ?"; 
                         pstm = connection.prepareStatement(sql);
                          // setar os params      
                        int index = 0;
                        pstm.setInt(++index, consulta.getConvenio().getId());
                        pstm.setInt(++index, consulta.getPaciente().getId());
                        pstm.setString(++index, consulta.getObs());
                        pstm.setDate(++index, consulta.getDataConsulta());
                        pstm.setDouble(++index, consulta.getValor());
                        pstm.setInt(++index, consulta.getCondPagt().getId());
                        pstm.setInt(++index, consulta.getUsuario().getId());
                        pstm.setInt(++index, consulta.getStatus());
                        pstm.setInt(++index, consulta.getTipo().getId());
                        pstm.setInt(++index, consulta.getProcedimento().getId());
                        pstm.setBoolean(++index, consulta.isFila());
                        pstm.setBoolean(++index, consulta.isPrioritario());
                        pstm.setString(++index, consulta.getCodAutorizacao());
                        pstm.setInt(++index, consulta.getId());  
                    }

                // executar
                pstm.execute();

                commitTransaction(connection);
                idAlterado = true;

        } catch (Exception e) {
                idAlterado = false;
                try {
                        rollbackTransaction(connection);
                } catch (SQLException e1) {
                        throw new IllegalStateException();
                }
        } finally {
                cleanup(rs, pstm, connection);
        }
        return idAlterado;
    
    
    } 
    
       
        @Override
    public boolean altStatConsult(List<Consulta> consulta) {
                Connection connection = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
                    
            // pegar a connection
                connection = getConnection();
                beginTransaction(connection);
                // criar o sql
                String sql = "UPDATE consultas SET status = ?  WHERE id = ?";
                
                
                // criar o statement
                pstm = connection.prepareStatement(sql);
                    for (Consulta consulta1 : consulta) {
                        // setar os params
                        pstm.setInt(1, consulta1.getStatus());
                        pstm.setInt(2, consulta1.getId());
                        
                        
                        // executar
                        pstm.execute();
                        
                        commitTransaction(connection);
                        idAlterado = true;
                    }
               
                
               

        } catch (Exception e) {
                idAlterado = false;
                try {
                        rollbackTransaction(connection);
                } catch (SQLException e1) {
                        throw new IllegalStateException();
                }
        } finally {
                cleanup(rs, pstm, connection);
        }
        return idAlterado;
    
    
    } 
    
        @Override
    public boolean altSeqConsult(List<Consulta> consulta) {
                Connection connection = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
                    
            // pegar a connection
                connection = getConnection();
                beginTransaction(connection);
                // criar o sql
                String sql = "UPDATE consultas SET fila = ?,status = ?, sequencia = ?  WHERE id = ?";
                
                
                // criar o statement
                pstm = connection.prepareStatement(sql);
                    for (Consulta consulta1 : consulta) {
                        // setar os params
                        pstm.setBoolean(1, consulta1.isFila());
                        pstm.setInt(2, consulta1.getStatus());
                        pstm.setInt(3, consulta1.getSequencia());
                        pstm.setInt(4, consulta1.getId());
                        
                        
                        // executar
                        pstm.execute();
                        
                        commitTransaction(connection);
                        idAlterado = true;
                    }
               
                
               

        } catch (Exception e) {
                idAlterado = false;
                try {
                        rollbackTransaction(connection);
                } catch (SQLException e1) {
                        throw new IllegalStateException();
                }
        } finally {
                cleanup(rs, pstm, connection);
        }
        return idAlterado;
    
    
    }
        @Override
         public boolean altStatConsult2(Consulta consulta) {
                Connection connection = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
                    
            // pegar a connection
                connection = getConnection();
                beginTransaction(connection);
                // criar o sql
                String sql = "UPDATE consultas SET status = ?  WHERE id = ?";
                
                
                // criar o statement
                pstm = connection.prepareStatement(sql);
               
                    // setar os params      
                    pstm.setInt(1, consulta.getStatus());
                    pstm.setInt(2, consulta.getId());
                    
                 
                 // executar
                pstm.execute();

                commitTransaction(connection);
                idAlterado = true;

                
               
                
               

        } catch (Exception e) {
                idAlterado = false;
                try {
                        rollbackTransaction(connection);
                } catch (SQLException e1) {
                        throw new IllegalStateException();
                }
        } finally {
                cleanup(rs, pstm, connection);
        }
        return idAlterado;
    
    
    } 


    @Override
    public void rmConsult(int id) {
      
		Connection connection = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			// pegar a connection
			connection = getConnection();
			beginTransaction(connection);
			//tempItem = procuraPorIDItem(id);
			
			String sql = "DELETE FROM consultas WHERE id = ?";

			pstm = connection.prepareStatement(sql);	
			pstm.setInt(1, id);
			pstm.execute();
			commitTransaction(connection);

		} catch (Exception e) {
			try {
				rollbackTransaction(connection);
			} catch (SQLException e1) {
				throw new IllegalStateException();
			}
		} finally {
			cleanup(rs, pstm, connection);
		}
    
    }

     public Consulta procuraPorID(Integer id) {
       
                Consulta con = null;
		Connection connection = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			// pegar a connection
			connection = getConnection();
			beginTransaction(connection);

			// CRIAR SQL
			String sql = "SELECT  consultas.*,pacientes.nome,num_convenio, convenios.ds_convenio, cond_pagto.descricao, usuarios.usuario, tipo_consulta.*, procedimento.* "
                                + " FROM pacientes "
                                + "LEFT JOIN consultas ON consultas.id_paciente = pacientes.id "
                                + "LEFT JOIN convenios ON convenios.id = consultas.id_convenio "
                                + "LEFT JOIN cond_pagto ON cond_pagto.id = consultas.id_cond_pagto "
                                + "LEFT JOIN usuarios ON usuarios.id = consultas.id_medico "
                                + "LEFT JOIN tipo_consulta ON tipo_consulta.id = consultas.cod_tipo "
                                + "LEFT JOIN procedimento ON procedimento.id = consultas.cod_procedimento "
                                + "WHERE consultas.id = ? ";

			// criar o statement
			pstm = connection.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
	
			con = retornObj(rs);
			}
		} catch (Exception e) {
			try {
				rollbackTransaction(connection);
			} catch (SQLException e1) {
				throw new IllegalStateException();
			}
		} finally {
			cleanup(rs, pstm, connection);
		}
		return con;
    
    }
    @Override
    public List<Consulta> buscaConsultas(String dado, char tipo, String status) {
        if (status.equals("7")) {
            status = "1,2,3,4,5,6";
        }
        Consulta con;
        Connection connection = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
                // pegar a connection
                connection = getConnection();
                beginTransaction(connection);
                // CRIAR SQL
                String sql="";
                switch (tipo) {
                case 'e':
                    sql = "SELECT  consultas.*,pacientes.nome,num_convenio, convenios.ds_convenio, cond_pagto.descricao, usuarios.usuario, tipo_consulta.*, procedimento.* "
                                + "FROM pacientes "
                                + "LEFT JOIN consultas ON consultas.id_paciente = pacientes.id "
                                + "LEFT JOIN convenios ON convenios.id = consultas.id_convenio "
                                + "LEFT JOIN cond_pagto ON cond_pagto.id = consultas.id_cond_pagto "
                                + "LEFT JOIN usuarios ON usuarios.id = consultas.id_medico "
                                + "LEFT JOIN tipo_consulta ON tipo_consulta.id = consultas.cod_tipo "
                                + "LEFT JOIN procedimento ON procedimento.id = consultas.cod_procedimento "
                                + "WHERE nome LIKE '%"+dado+"%' AND status IN ("+status+") ORDER BY data_consulta ASC";
                        break;
                case 'i':
                        sql = "SELECT  consultas.*,pacientes.nome,num_convenio, convenios.ds_convenio, cond_pagto.descricao, usuarios.usuario, tipo_consulta.*, procedimento.* "
                                + "FROM pacientes "
                                + "LEFT JOIN consultas ON consultas.id_paciente = pacientes.id "
                                + "LEFT JOIN convenios ON convenios.id = consultas.id_convenio "
                                + "LEFT JOIN cond_pagto ON cond_pagto.id = consultas.id_cond_pagto "
                                + "LEFT JOIN usuarios ON usuarios.id = consultas.id_medico "
                                + "LEFT JOIN tipo_consulta ON tipo_consulta.id = consultas.cod_tipo "
                                + "LEFT JOIN procedimento ON procedimento.id = consultas.cod_procedimento "
                                + "WHERE data_consulta = '"+dado+"' AND status IN ("+status+") ORDER BY data_consulta ASC";
                        break;
                case 't':
                    sql = "SELECT  consultas.*,pacientes.nome,num_convenio, convenios.ds_convenio, cond_pagto.descricao, usuarios.usuario, tipo_consulta.*, procedimento.* "
                                + "FROM pacientes "
                                + "LEFT JOIN consultas ON consultas.id_paciente = pacientes.id "
                                + "LEFT JOIN convenios ON convenios.id = consultas.id_convenio "
                                + "LEFT JOIN cond_pagto ON cond_pagto.id = consultas.id_cond_pagto "
                                + "LEFT JOIN usuarios ON usuarios.id = consultas.id_medico "
                                + "LEFT JOIN tipo_consulta ON tipo_consulta.id = consultas.cod_tipo "
                                + "LEFT JOIN procedimento ON procedimento.id = consultas.cod_procedimento "
                                + "WHERE status IN ("+status+")  ORDER BY data_consulta ASC";
                       
                        break;
                case 'a':
                    sql = "SELECT  consultas.*,pacientes.nome,num_convenio, convenios.ds_convenio, cond_pagto.descricao, usuarios.usuario, tipo_consulta.*, procedimento.* "
                                + "FROM pacientes "
                                + "LEFT JOIN consultas ON consultas.id_paciente = pacientes.id "
                                + "LEFT JOIN convenios ON convenios.id = consultas.id_convenio "
                                + "LEFT JOIN cond_pagto ON cond_pagto.id = consultas.id_cond_pagto "
                                + "LEFT JOIN usuarios ON usuarios.id = consultas.id_medico "
                                + "LEFT JOIN tipo_consulta ON tipo_consulta.id = consultas.cod_tipo "
                                + "LEFT JOIN procedimento ON procedimento.id = consultas.cod_procedimento "
                                + "WHERE id_paciente = '"+dado+"' OR num_convenio = '"+dado+"' AND status IN ("+status+") ORDER BY data_consulta ASC";
                    break;
           

                default:
                        break;
                }

                // criar o statement
                stm = connection.createStatement();
                rs = stm.executeQuery(sql);
                while (rs.next()) {
                 
                 con = retornObj(rs);
                 consultas.add(con);
                }

        } catch (Exception e) {
                try {
                        rollbackTransaction(connection);
                } catch (SQLException e1) {
                        throw new IllegalStateException();
                }
        } finally {
                cleanup(rs, stm, connection);
        }
        return consultas;
    }
    
    @Override
     public List<Consulta> buscaConPstat(int coluna ,String dados, String status) {
        Consulta con;
        Connection connection = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
                // pegar a connection
                connection = getConnection();
                beginTransaction(connection);
                // CRIAR SQL
                String sql="";
                switch (coluna) {
                case 0:
                    sql = "SELECT  consultas.*,pacientes.nome,num_convenio, convenios.ds_convenio, cond_pagto.descricao, usuarios.usuario, tipo_consulta.*, procedimento.* "
                                + "FROM pacientes "
                                + "LEFT JOIN consultas ON consultas.id_paciente = pacientes.id "
                                + "LEFT JOIN convenios ON convenios.id = consultas.id_convenio "
                                + "LEFT JOIN cond_pagto ON cond_pagto.id = consultas.id_cond_pagto "
                                + "LEFT JOIN usuarios ON usuarios.id = consultas.id_medico "
                                + "LEFT JOIN tipo_consulta ON tipo_consulta.id = consultas.cod_tipo "
                                + "LEFT JOIN procedimento ON procedimento.id = consultas.cod_procedimento "
                                + "WHERE nome LIKE '%"+dados+"%' AND status IN ("+status+") ORDER BY data_consulta ASC";
                        break;
                case 1:
                    sql = "SELECT  consultas.*,pacientes.nome,num_convenio, convenios.ds_convenio, cond_pagto.descricao, usuarios.usuario, tipo_consulta.*, procedimento.* "
                                + "FROM pacientes "
                                + "LEFT JOIN consultas ON consultas.id_paciente = pacientes.id "
                                + "LEFT JOIN convenios ON convenios.id = consultas.id_convenio "
                                + "LEFT JOIN cond_pagto ON cond_pagto.id = consultas.id_cond_pagto "
                                + "LEFT JOIN usuarios ON usuarios.id = consultas.id_medico "
                                + "LEFT JOIN tipo_consulta ON tipo_consulta.id = consultas.cod_tipo "
                                + "LEFT JOIN procedimento ON procedimento.id = consultas.cod_procedimento "
                                + "WHERE data_consulta = '"+dados+"' AND status IN ("+status+") ORDER BY data_consulta ASC";
                        break;
               
           

                default:
                        break;
                }

                // criar o statement
                stm = connection.createStatement();
                rs = stm.executeQuery(sql);
                while (rs.next()) {         
                 con = retornObj(rs);
                 consultas.add(con);
                }

        } catch (Exception e) {
                try {
                        rollbackTransaction(connection);
                } catch (SQLException e1) {
                        throw new IllegalStateException();
                }
        } finally {
                cleanup(rs, stm, connection);
        }
        return consultas;
    }
    
    public List<Consulta> buscaConDataPstat(String dados, String status) {
        Consulta con;
        Connection connection = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
                // pegar a connection
                connection = getConnection();
                beginTransaction(connection);
                // CRIAR SQL
               
            
              
                   String   sql = "SELECT  consultas.*,pacientes.nome,num_convenio, convenios.ds_convenio, cond_pagto.descricao, usuarios.usuario, tipo_consulta.*, procedimento.* "
                                + "FROM pacientes "
                                + "LEFT JOIN consultas ON consultas.id_paciente = pacientes.id "
                                + "LEFT JOIN convenios ON convenios.id = consultas.id_convenio "
                                + "LEFT JOIN cond_pagto ON cond_pagto.id = consultas.id_cond_pagto "
                                + "LEFT JOIN usuarios ON usuarios.id = consultas.id_medico "
                                + "LEFT JOIN tipo_consulta ON tipo_consulta.id = consultas.cod_tipo "
                                + "LEFT JOIN procedimento ON procedimento.id = consultas.cod_procedimento "
                                + "WHERE data_consulta = '"+dados+"' AND status IN ("+status+")  AND consultas.fila = true ORDER BY sequencia ASC";
                

                // criar o statement
                stm = connection.createStatement();
                rs = stm.executeQuery(sql);
                while (rs.next()) {         
                 con = retornObj(rs);
                 consultas.add(con);
                }

        } catch (Exception e) {
                try {
                        rollbackTransaction(connection);
                } catch (SQLException e1) {
                        throw new IllegalStateException();
                }
        } finally {
                cleanup(rs, stm, connection);
        }
        return consultas;
    }
    
        @Override
        public List<Consulta> buscConsPdata(Date data) {
                Connection connection = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			// pegar a connection
			connection = getConnection();
			beginTransaction(connection);

			// CRIAR SQL
			String sql = "SELECT  consultas.*,pacientes.nome,num_convenio, convenios.ds_convenio, cond_pagto.descricao, usuarios.usuario, tipo_consulta.*, procedimento.* "
                                + "FROM pacientes "
                                + "LEFT JOIN consultas ON consultas.id_paciente = pacientes.id "
                                + "LEFT JOIN convenios ON convenios.id = consultas.id_convenio "
                                + "LEFT JOIN cond_pagto ON cond_pagto.id = consultas.id_cond_pagto "
                                + "LEFT JOIN usuarios ON usuarios.id = consultas.id_medico "
                                + "LEFT JOIN tipo_consulta ON tipo_consulta.id = consultas.cod_tipo "
                                + "LEFT JOIN procedimento ON procedimento.id = consultas.cod_procedimento "
                                + "WHERE data_consulta = '"+data+"' ORDER BY sequencia ASC";

			// criar o statement
			pstm = connection.prepareStatement(sql);
			rs = pstm.executeQuery();
	
			while (rs.next()) {
                        
                        Consulta c = retornObj(rs);
               
                                consultas.add(c);
								
			}

		} catch (Exception e) {
			try {
				rollbackTransaction(connection);
			} catch (SQLException e1) {
				throw new IllegalStateException();
			}
		} finally {
			cleanup(rs, pstm, connection);
		}
		return consultas;    
        }
    


    @Override
    public Consulta buscConsPCli(int idPaciente) {
        Consulta con = null;
        Connection connection = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			// pegar a connection
			connection = getConnection();
			beginTransaction(connection);

			// CRIAR SQL
			String selectMaxData = "SELECT MAX(data_consulta) AS maxDATA from consultas ";
                        Date maxData = null;
                        pstm = connection.prepareStatement(selectMaxData);
			rs = pstm.executeQuery();
			while (rs.next()) {
                            
				maxData = rs.getDate(1);
			}
                        
                        String sql = "SELECT * FROM consultas WHERE data_consulta = '"+maxData+"' ";
			// criar o statement
			pstm = connection.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while (rs.next()) {	
                          con = new Consulta(rs.getDate("data_consulta"), rs.getInt("status"), rs.getString("obs"));
			}

		} catch (Exception e) {
			try {
				rollbackTransaction(connection);
			} catch (SQLException e1) {
				throw new IllegalStateException();
			}
		} finally {
			cleanup(rs, pstm, connection);
		}
            return con;
    }
    
         public Consulta retornObj(ResultSet rs) throws SQLException{
             Consulta c = null;
             if (rs != null) {
                        Convenio conv = new Convenio();
                        CondPagto  condPagto = new CondPagto();
                        condPagto.setId(rs.getInt("id_cond_pagto"));
                        condPagto.setCondPagt(rs.getString("descricao"));
                        conv.setId(rs.getInt("id_convenio"));
                        conv.setDsConvenio(rs.getString("ds_convenio"));
                        Procedimento proce = new Procedimento(rs.getInt("cod_procedimento"), rs.getString("ds_procedimento"));
                        Paciente  paciente = new Paciente(rs.getInt("id_paciente"),rs.getString("num_convenio"), rs.getString("nome"));
                        Usuario  usuario = new Usuario(rs.getInt("id_medico"),rs.getString("usuario"));
                       
                        Tipo tipo = new Tipo(rs.getInt("cod_tipo"), rs.getString("tipo"));
                         c = new Consulta(rs.getInt("id"), conv,paciente, usuario,rs.getDate("data_consulta"), rs.getInt("status"),
                                rs.getInt("sequencia"), rs.getString("obs"), rs.getDouble("valor"),condPagto, 
                                 tipo,proce,rs.getBoolean("fila"),rs.getBoolean("prioritario"),rs.getString("cod_autorizacao"));
                         
             }
            return c;
         }
         
         
         
         public void ConectRelatorio(Date init ,Date fin, String clien, String status, String convenio, String condPagt,String usuario, String ordem, int id_empresa){
		Connection connection = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			// pegar a connection
			connection = getConnection();
			beginTransaction(connection);
			InputStream inputStream = getClass().getResourceAsStream("/consultas.jasper");
            
           
                // mapa de parâmetros do relatório
                Map parametros = new HashMap();
                parametros.put("clie", clien);
                parametros.put("stat", status);
                parametros.put("conv", convenio);
                parametros.put("dataIn", init);
                parametros.put("dataFin", fin);
                parametros.put("condPg", condPagt);
                parametros.put("med", usuario);
                parametros.put("ordem", ordem);
                parametros.put("id_empresa", id_empresa);
               
              
               
               
                    // abre o relatório
                    ReportUtils.openReport("Relatório de consultas", inputStream, parametros, connection);                    
                    

		} catch (Exception e) {
			try {
                            System.out.println(e.getMessage());
				rollbackTransaction(connection);
			} catch (SQLException e1) {
				throw new IllegalStateException();
			}
		} finally {
			cleanup(rs, stm, connection);
		}  
     }
}
