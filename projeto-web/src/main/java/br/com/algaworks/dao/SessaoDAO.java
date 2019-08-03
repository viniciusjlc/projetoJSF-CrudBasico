package br.com.algaworks.dao;

import br.com.algaworks.model.Usuario;
import br.com.algaworks.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SessaoDAO {
    private Connection conexao = null;

    public Boolean verificaSenha(Usuario u) {
        boolean retorno = false;
        conexao = ConnectionFactory.getConnection();
        String sql = "select * from public.usuarios u where u.email like ? and u.senha like ?";
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, u.getEmail());
            ps.setString(2, u.getSenha());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               retorno = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return retorno;
    }
}
