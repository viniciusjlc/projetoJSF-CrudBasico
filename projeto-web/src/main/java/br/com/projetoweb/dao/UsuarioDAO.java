package br.com.projetoweb.dao;

import br.com.projetoweb.model.Estado;
import br.com.projetoweb.model.Usuario;
import br.com.projetoweb.factory.ConnectionFactory;
import br.com.projetoweb.util.StringUtil;
import br.com.projetoweb.util.VerificadorUtil;
import static  br.com.projetoweb.shared.Queries.QueriesUsuario.*;

import java.sql.*;
import java.util.ArrayList;

public class UsuarioDAO {
    private Connection conexao = null;

    public ArrayList<Usuario> retornarListaComUsuarios() {
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        conexao = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = conexao.prepareStatement(QUERY_CONSULTAR_RETORNAR_LISTA_COM_USUARIOS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Usuario user = new Usuario();
                user.setNome(rs.getString("nome"));
                user.setDataNascimento(rs.getDate("data_nascimento"));
                user.setCpf(rs.getString("cpf"));
                user.setEmail(rs.getString("email"));
                user.setSenha(rs.getString("senha"));
                user.setCelular(rs.getString("celular"));
                user.setGenero(rs.getString("genero"));
                user.setRgNumero(rs.getString("rg_numero"));
                user.setRgEstado(rs.getString("rg_uf"));
                user.setRgDataEmissao(rs.getDate("rg_data_emissao"));
                user.setFoto(rs.getByte("foto"));
                user.setAdministrador(rs.getBoolean("administrador"));
                user.getEndereco().setCep(rs.getString("cep"));
                user.getEndereco().setCidade(rs.getString("cidade"));
                user.getEndereco().setEstado(rs.getString("estado"));
                user.getEndereco().setBairro(rs.getString("bairro"));
                user.getEndereco().setNumero(rs.getInt("numero"));
                user.getEndereco().setLogradouro(rs.getString("logradouro"));
                user.getEndereco().setComplemento(rs.getString("complemento"));
                listaUsuarios.add(user);
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
        return listaUsuarios;
    }

    public ArrayList<Estado> retornarListaComEstados() {
        ArrayList<Estado> listaEstados = new ArrayList<>();
        conexao = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = conexao.prepareStatement(QUERY_CONSULTAR_RETORNAR_LISTA_COM_ESTADOS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Estado estado = new Estado();
                estado.setNome(rs.getString("nome"));
                estado.setSigla(rs.getString("sigla"));
                listaEstados.add(estado);
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
        return listaEstados;
    }

    public Boolean verificarEmail(Usuario u) {
        boolean retorno = false;
        conexao = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = conexao.prepareStatement(QUERY_CONSULTAR_VERIFICAR_EMAIL);
            ps.setString(1, u.getEmail());
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

    public boolean gravarUsuario(Usuario usuario) {
        boolean salvou = false;
        conexao = ConnectionFactory.getConnection();
        PreparedStatement ps;
        try {
            ps = conexao.prepareStatement(QUERY_INSERIR_GRAVAR_USUARIO);
            mapearPrepareStatementGravacao(usuario, ps);
            ps.executeUpdate();
            salvou = true;
            conexao.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return salvou;
    }

    public boolean alterarUsuario(Usuario usuario, String emailAntigo) {
        boolean salvou = false;
        conexao = ConnectionFactory.getConnection();
        PreparedStatement ps;
        try {
            ps = conexao.prepareStatement(QUERY_ALTERAR_USUARIO);
            mapearPrepareStatementGravacao(usuario, ps);
            ps.setString(18, emailAntigo);
            ps.executeUpdate();
            salvou = true;
            conexao.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return salvou;
    }

    public boolean alterarSenha(String senhaNova, String emailAntigo) {
        boolean salvou = false;
        conexao = ConnectionFactory.getConnection();
        PreparedStatement ps;
        try {
            ps = conexao.prepareStatement(QUERY_ALTERAR_SENHA);
            ps.setString(1, senhaNova);
            ps.setString(2, emailAntigo);
            ps.executeUpdate();
            salvou = true;
            conexao.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return salvou;
    }

    public boolean deletarUsuario(String email) {
        boolean salvou = false;
        conexao = ConnectionFactory.getConnection();
        PreparedStatement ps;
        try {
            ps = conexao.prepareStatement(QUERY_ALTERAR_DELETAR_USUARIO);
            ps.setString(1, email);
            ps.executeUpdate();
            salvou = true;
            conexao.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return salvou;
    }

    private void mapearPrepareStatementGravacao(Usuario usuario, PreparedStatement ps) throws SQLException {
        if (VerificadorUtil.naoEstaNuloOuVazio(usuario.getNome())) {
            ps.setString(1, usuario.getNome());
        } else {
            ps.setNull(1, java.sql.Types.NULL);
        }
        if (VerificadorUtil.naoEstaNulo(usuario.getDataNascimento())) {
            ps.setDate(2, new Date(usuario.getDataNascimento().getTime()));
        } else {
            ps.setNull(2, java.sql.Types.NULL);
        }
        if (VerificadorUtil.naoEstaNuloOuVazio(usuario.getCpf())) {
            ps.setString(3, StringUtil.retirarMascara(usuario.getCpf()));
        } else {
            ps.setNull(3, java.sql.Types.NULL);
        }
        if (VerificadorUtil.naoEstaNuloOuVazio(usuario.getEmail())) {
            ps.setString(4, usuario.getEmail());
        } else {
            ps.setNull(4, java.sql.Types.NULL);
        }
        if (VerificadorUtil.naoEstaNuloOuVazio(usuario.getSenha())) {
            ps.setString(5, usuario.getSenha());
        } else {
            ps.setNull(5, java.sql.Types.NULL);
        }
        if (VerificadorUtil.naoEstaNuloOuVazio(usuario.getCelular())) {
            ps.setString(6, StringUtil.retirarMascara(usuario.getCelular()));
        } else {
            ps.setNull(6, java.sql.Types.NULL);
        }
        if (VerificadorUtil.naoEstaNuloOuVazio(usuario.getGenero())) {
            ps.setString(7, usuario.getGenero());
        } else {
            ps.setNull(7, java.sql.Types.NULL);
        }
        if (VerificadorUtil.naoEstaNuloOuVazio(usuario.getRgNumero())) {
            ps.setString(8, usuario.getRgNumero());
        } else {
            ps.setNull(8, java.sql.Types.NULL);
        }
        if (VerificadorUtil.naoEstaNuloOuVazio(usuario.getRgEstado())) {
            ps.setString(9, usuario.getRgEstado());
        } else {
            ps.setNull(9, java.sql.Types.NULL);
        }
        if (VerificadorUtil.naoEstaNulo(usuario.getRgDataEmissao())) {
            ps.setDate(10, new Date(usuario.getRgDataEmissao().getTime()));
        } else {
            ps.setNull(10, java.sql.Types.NULL);
        }
        if (VerificadorUtil.naoEstaNuloOuVazio(usuario.getEndereco().getCep())) {
            ps.setString(11, StringUtil.retirarMascara(usuario.getEndereco().getCep()));
        } else {
            ps.setNull(11, java.sql.Types.NULL);
        }
        if (VerificadorUtil.naoEstaNuloOuVazio(usuario.getEndereco().getCidade())) {
            ps.setString(12, usuario.getEndereco().getCidade());
        } else {
            ps.setNull(12, java.sql.Types.NULL);
        }
        if (VerificadorUtil.naoEstaNuloOuVazio(usuario.getEndereco().getEstado())) {
            ps.setString(13, usuario.getEndereco().getEstado());
        } else {
            ps.setNull(13, java.sql.Types.NULL);
        }
        if (VerificadorUtil.naoEstaNuloOuVazio(usuario.getEndereco().getBairro())) {
            ps.setString(14, usuario.getEndereco().getBairro());
        } else {
            ps.setNull(14, java.sql.Types.NULL);
        }
        if (VerificadorUtil.naoEstaNulo(usuario.getEndereco().getNumero())) {
            ps.setInt(15, usuario.getEndereco().getNumero());
        } else {
            ps.setNull(15, java.sql.Types.NULL);
        }
        if (VerificadorUtil.naoEstaNuloOuVazio(usuario.getEndereco().getLogradouro())) {
            ps.setString(16, usuario.getEndereco().getLogradouro());
        } else {
            ps.setNull(16, java.sql.Types.NULL);
        }
        if (VerificadorUtil.naoEstaNuloOuVazio(usuario.getEndereco().getLogradouro())) {
            ps.setString(17, usuario.getEndereco().getComplemento());
        } else {
            ps.setNull(17, java.sql.Types.NULL);
        }

    }
}