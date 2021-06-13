package br.com.dimension.dao;

import br.com.dimension.conexao.DimensionConexao;
import br.com.dimension.insercao.Insercao;
import br.com.dimension.usuario.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DimensionDAO {
    public List<Usuario> pegarUsuario(){
        String sql = "Select * from funcionarios;";
        List<Usuario> usuarios = new ArrayList<Usuario>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet resultSet = null;
        try{
            conn = DimensionConexao.createConnectionToSQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            resultSet = pstm.executeQuery();
            while(resultSet.next()){
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(resultSet.getInt("idFuncionarios"));
                usuario.setUsuario(resultSet.getString("login"));
                usuario.setSenha(resultSet.getString("senha"));

                usuarios.add(usuario);
            }


        }
        catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return usuarios;
    }

    public void inserirBD (Insercao insercao){
        String sql = "INSERT INTO registro(nomeComponente, data,dadosColetados) VALUES (?, ?, ?) ";
        Connection conn = null;
        PreparedStatement pstm = null;
        try{
            conn = DimensionConexao.createConnectionToSQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, insercao.getNomeComponente());
            pstm.setDate(2, new Date(insercao.getData().getTime()));
            pstm.setDouble(3, insercao.getDadosColetados());
            pstm.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try{
                if (pstm!=null){
                    pstm.close();
                }
                if (conn!=null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
