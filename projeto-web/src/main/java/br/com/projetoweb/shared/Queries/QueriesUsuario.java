package br.com.projetoweb.shared.Queries;

public class QueriesUsuario {

    public static final String QUERY_CONSULTAR_RETORNAR_LISTA_COM_USUARIOS =
            "SELECT nome, data_nascimento, cpf, email, senha, celular, genero, rg_numero, rg_uf, " +
            "rg_data_emissao, cep, cidade, estado, bairro, numero, logradouro, complemento, foto, administrador " +
            "FROM public.usuarios where ativo = true ORDER BY id";

    public static final String QUERY_CONSULTAR_RETORNAR_LISTA_COM_ESTADOS =
            "SELECT nome, uf as sigla FROM public.estados order by nome";

    public static final String QUERY_CONSULTAR_VERIFICAR_EMAIL =
            "select * from public.usuarios u where u.email like ?";


    public static final String QUERY_INSERIR_GRAVAR_USUARIO =
            "INSERT INTO public.usuarios " +
            "(nome, data_nascimento, cpf, email, senha, celular, genero, rg_numero, rg_uf, rg_data_emissao, " +
            "cep, cidade, estado, bairro, numero, logradouro, complemento) " +
            "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public static final String QUERY_ALTERAR_USUARIO =
            "UPDATE public.usuarios " +
                    "SET nome=?, data_nascimento=?, cpf=?, email=?, senha=?, celular=?, genero=?, rg_numero=?, rg_uf=?, rg_data_emissao=?, cep=?, cidade=?, " +
                    "estado=?, bairro=?, numero=?, logradouro=?, complemento=?, data_hora_ultima_modificacao=CURRENT_TIMESTAMP " +
                    "WHERE email like ?";

    public static final String QUERY_ALTERAR_DELETAR_USUARIO =
            "UPDATE public.usuarios SET ativo=false, data_hora_ultima_modificacao=CURRENT_TIMESTAMP WHERE email like ?";

    public static final String QUERY_ALTERAR_SENHA =
            "UPDATE public.usuarios SET senha=?, data_hora_ultima_modificacao=CURRENT_TIMESTAMP WHERE email like ?";

}
