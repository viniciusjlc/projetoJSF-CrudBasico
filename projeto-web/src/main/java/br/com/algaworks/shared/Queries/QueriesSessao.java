package br.com.algaworks.shared.Queries;

public class QueriesSessao {
    public static final String QUERY_CONSULTAR_VERIFICA_SENHA =
            "select * from public.usuarios u where u.email like ? and u.senha like ?";



}
