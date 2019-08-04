package br.com.projetoweb.util;

import br.com.projetoweb.model.Endereco;

public class ViaCepUtil {
    
    public static Endereco buscarEndereco(Endereco endereco) throws ViaCEPException {
        ViaCEP viaCep = new ViaCEP();
        String cepFormatado = endereco.getCep().replaceAll("-","").trim();
        if(viaCep.validarCEP(cepFormatado)){
            viaCep.buscar(cepFormatado);
            endereco.setEstado(viaCep.getUf());
            endereco.setBairro(viaCep.getBairro());
            endereco.setLogradouro(viaCep.getLogradouro());
            endereco.setCidade(viaCep.getLocalidade());
            return endereco;
        }else{
            MensagemUtil.erro("CEP Inválido");
            return endereco;
        }
    }
}
