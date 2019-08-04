CREATE TABLE public.usuarios (
	id serial NOT null,
	nome varchar(120) NULL,
	data_nascimento date NULL,
	cpf char(11) NULL,
	email varchar(100) NOT null,
	senha varchar(60) NULL,
	celular char(9) NULL,
	genero char null,
	rg_numero char(9) NULL,
	rg_uf char(2) NULL,
	rg_data_emissao date NULL,
	cep varchar(8) NULL,
	cidade varchar(30) NULL,
	estado char(2) NULL,
	bairro varchar(40) NULL,
	numero int NULL,
	logradouro varchar(40) NULL,
	complemento varchar(60) null,
	foto bytea NULL,
	administrador bool null default false,
	data_hora_criacao timestamp null default current_timestamp,
	data_hora_ultima_modificacao timestamp null default current_timestamp,
	ativo bool NULL DEFAULT true
);

INSERT INTO public.usuarios (id,nome,data_nascimento,cpf,email,senha,celular,genero,rg_numero, administrador)
VALUES (1,'teste','2000-01-01','59162113097','teste@teste.com','teste123','999999999','M','367506956', true);

CREATE TABLE public.estados (
    Id       serial          NOT NULL,
    CodigoUf INT          NOT NULL,
    Nome     VARCHAR (50) NOT NULL,
    Uf       CHAR 	 (2)  NOT NULL,
    Regiao   INT	      NOT NULL,
    PRIMARY KEY (Id)
);

Insert into public.estados (CodigoUf, Nome, Uf, Regiao) values (12, 'Acre', 'AC', 1);
Insert into public.estados (CodigoUf, Nome, Uf, Regiao) values (27, 'Alagoas', 'AL', 2);
Insert into public.estados (CodigoUf, Nome, Uf, Regiao) values (16, 'Amapá', 'AP', 1);
Insert into public.estados (CodigoUf, Nome, Uf, Regiao) values (13, 'Amazonas', 'AM', 1);
Insert into public.estados (CodigoUf, Nome, Uf, Regiao) values (29, 'Bahia', 'BA', 2);
Insert into public.estados (CodigoUf, Nome, Uf, Regiao) values (23, 'Ceará', 'CE', 2);
Insert into public.estados (CodigoUf, Nome, Uf, Regiao) values (53, 'Distrito Federal', 'DF', 5);
Insert into public.estados (CodigoUf, Nome, Uf, Regiao) values (32, 'Espírito Santo', 'ES', 3);
Insert into public.estados (CodigoUf, Nome, Uf, Regiao) values (52, 'Goiás', 'GO', 5);
Insert into public.estados (CodigoUf, Nome, Uf, Regiao) values (21, 'Maranhão', 'MA', 2);
Insert into public.estados (CodigoUf, Nome, Uf, Regiao) values (51, 'Mato Grosso', 'MT', 5);
Insert into public.estados (CodigoUf, Nome, Uf, Regiao) values (50, 'Mato Grosso do Sul', 'MS', 5);
Insert into public.estados (CodigoUf, Nome, Uf, Regiao) values (31, 'Minas Gerais', 'MG', 3);
Insert into public.estados (CodigoUf, Nome, Uf, Regiao) values (15, 'Pará', 'PA', 1);
Insert into public.estados (CodigoUf, Nome, Uf, Regiao) values (25, 'Paraíba', 'PB', 2);
Insert into public.estados (CodigoUf, Nome, Uf, Regiao) values (41, 'Paraná', 'PR', 4);
Insert into public.estados (CodigoUf, Nome, Uf, Regiao) values (26, 'Pernambuco', 'PE', 2);
Insert into public.estados (CodigoUf, Nome, Uf, Regiao) values (22, 'Piauí', 'PI', 2);
Insert into public.estados (CodigoUf, Nome, Uf, Regiao) values (33, 'Rio de Janeiro', 'RJ', 3);
Insert into public.estados (CodigoUf, Nome, Uf, Regiao) values (24, 'Rio Grande do Norte', 'RN', 2);
Insert into public.estados (CodigoUf, Nome, Uf, Regiao) values (43, 'Rio Grande do Sul', 'RS', 4);
Insert into public.estados (CodigoUf, Nome, Uf, Regiao) values (11, 'Rondônia', 'RO', 1);
Insert into public.estados (CodigoUf, Nome, Uf, Regiao) values (14, 'Roraima', 'RR', 1);
Insert into public.estados (CodigoUf, Nome, Uf, Regiao) values (42, 'Santa Catarina', 'SC', 4);
Insert into public.estados (CodigoUf, Nome, Uf, Regiao) values (35, 'São Paulo', 'SP', 3);
Insert into public.estados (CodigoUf, Nome, Uf, Regiao) values (28, 'Sergipe', 'SE', 2);
Insert into public.estados (CodigoUf, Nome, Uf, Regiao) values (17, 'Tocantins', 'TO', 1);
