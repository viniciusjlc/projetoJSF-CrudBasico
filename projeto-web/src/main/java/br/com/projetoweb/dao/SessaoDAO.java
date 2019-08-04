package br.com.projetoweb.dao;

import br.com.projetoweb.model.Usuario;
import br.com.projetoweb.factory.ConnectionFactory;

import static br.com.projetoweb.shared.Queries.QueriesSessao.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SessaoDAO {
    public Boolean verificaSenha(Usuario u) {
        boolean retorno = false;
        Connection conexao = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = conexao.prepareStatement(QUERY_CONSULTAR_VERIFICA_SENHA);
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
