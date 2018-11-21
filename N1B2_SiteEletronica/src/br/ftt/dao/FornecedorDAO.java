package br.ftt.dao;

import br.ftt.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author @Doriedson L. Silva
 * 
 */

public class FornecedorDAO {
    
       //insere um novo fornecedor
      public void insere(FornecedorVO fornecedor) throws SQLException {
        Connection cx = ConexaoBD.getConexao();
        try {
            String sql = "insert into tbl_fornecedor (cnpj, razao_s, endereco"
                       + ", bairro, cidade, cep) values (?,?,?,?,?,?)";

            PreparedStatement p = cx.prepareStatement(sql);
                        p.setString(1, fornecedor.getCnpj());
            p.setString(2, fornecedor.getRazaoSocial());
            p.setString(3, fornecedor.getEndereco());
            p.setString(4, fornecedor.getBairro());
            p.setString(5, fornecedor.getCidade());
            p.execute();
            p.close();
            
        } finally {
            cx.close();
        }
    }
      
      public void excluir(String cnpj) {
          Connection cx = ConexaoBD.getConexao();
          try{
              String sql = "delete from tbl_Fornecedor where cnpj=?";
              PreparedStatement p = cx.prepareStatement(sql);
              p.setString(1, cnpj);
              p.execute();
              p.close();
              cx.close();
          }
          catch (SQLException ex) {
              ex.printStackTrace();
          }
      }
      
      //altera os dados de um fornecedor
      public void alterar(FornecedorVO fornecedor) throws SQLException {
        Connection cx = ConexaoBD.getConexao();
        
        try {
            String sql = "update tbl_fornecedor set cnpj=?, razao_s=?, endereco=?, bairro=?, "
                          + "cidade=? where cnpj=?";
            
            PreparedStatement p = cx.prepareStatement(sql);
            
            p.setString(1, fornecedor.getCnpj()); 
            p.setString(2, fornecedor.getRazaoSocial());
            p.setString(3, fornecedor.getEndereco());
            p.setString(4, fornecedor.getBairro());
            p.setString(5, fornecedor.getCidade());
                               
            p.execute();
            p.close();
        } finally {
            cx.close();
        }
    }
      
          
    
    //consulta um cliente pelo cpf    
    public FornecedorVO consulta(String cnpj) throws SQLException {
        Connection cx = ConexaoBD.getConexao();
        
        try{
            String sql ="select * from tbl_fornecedpr where cnpj=?";
            
            PreparedStatement p = cx.prepareStatement(sql);
            p.setString(1,cnpj);
            ResultSet rs = p.executeQuery();
            
            FornecedorVO fornecedor = null;
            if(rs.next()){
               fornecedor = MontaFornecedorVO(rs);
            }
                   
            return fornecedor;    
        }finally{
            cx.close();
        }
    }
    
    
    //monta os dados do objeto cliente
    private static FornecedorVO MontaFornecedorVO(ResultSet rs) throws SQLException {
        FornecedorVO fr = new FornecedorVO();
        fr.setCnpj(rs.getString("cnpj"));
        fr.setRazaoSocial(rs.getString("razao_s"));
        fr.setEndereco(rs.getString("endereco"));
        fr.setBairro(rs.getString("bairro"));
        fr.setCidade(rs.getString("cidade"));
        return fr;
    }

}
