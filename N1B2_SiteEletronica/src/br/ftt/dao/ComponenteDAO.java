package br.ftt.dao;

import br.ftt.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class ComponenteDAO {

    public void insere(ComponenteVO comp) throws SQLException {
        Connection conexao = ConexaoBD.getConexao();
        try {
            String sql = "insert into tbl_Componente (id_comp, descricao, imagem) values (?,?)";

            PreparedStatement p = conexao.prepareStatement(sql);

            p.setInt(1, comp.getId());
            p.setString(2, comp.getDescricao());
            p.execute();
            p.close();
        } finally {
            conexao.close();
        }
    }

    public void alterar(ComponenteVO comp) throws SQLException {
        Connection conexao = ConexaoBD.getConexao();
        try {
            String sql = "update tbl_Componente set descricao=?, where id=?";
            PreparedStatement p = conexao.prepareStatement(sql);
            p.setString(1, comp.getDescricao());
            p.setInt(2, comp.getId());
            p.close();
        } finally {
            conexao.close();
        }

    }

    public void excluir(String id) throws SQLException {
        Connection conexao = ConexaoBD.getConexao();
        try {
            String sql = "delete tbl_Componente where id=?";
            PreparedStatement p = conexao.prepareStatement(sql);
            p.setString(1, id);
            p.execute();
            p.close();
        } finally {
            conexao.close();
        }

    }

//Consultas
    public ComponenteVO consulta(String id) throws SQLException {
        Connection cx = ConexaoBD.getConexao();

        try {
            String sql = "select * from TBL_Componente where id=?";
            PreparedStatement smt = cx.prepareStatement(sql);
            smt.setString(1, id);
            ResultSet rs = smt.executeQuery();

            ComponenteVO comp = null;
            if (rs.next()) {
                comp = MontaVO(rs);
            }
            smt.close();
            return comp;
        } finally {
            cx.close();
        }
    }

//Monta VO
    private static ComponenteVO MontaVO(ResultSet rs) throws SQLException {
        ComponenteVO cp = new ComponenteVO();
        cp.setId(rs.getString("id_comp"));
        cp.setDescricao(rs.getString("descricao"));
       
        return cp;
    }

   

    
}
