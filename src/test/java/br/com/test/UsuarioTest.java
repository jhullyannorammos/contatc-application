package br.com.test;

import javax.inject.Inject;
import junit.framework.Test;
import br.com.ciceroednilson.model.PessoaModel;
import br.com.ciceroednilson.model.UsuarioModel;
import br.com.ciceroednilson.repository.PessoaRepository;
import br.com.ciceroednilson.usuario.controller.UsuarioController;
import br.com.ciceroednilson.uteis.Uteis;
import org.junit.*;

public class UsuarioTest {

    @Inject
    PessoaModel pessoaModel;
    
    @Inject
    UsuarioModel usuarioModel;

    @Inject
    UsuarioController usuarioController;

    @Inject
    PessoaRepository pessoaRepository;
	
    @T
    public void SalvarNovaPessoa(){
    	
    	pessoaModel.setEmail("teste@gmail.com");
    	pessoaModel.setNome("teste");
    	pessoaModel.setEndereco("g fdgdgd7f89sfdh");
    	pessoaModel.setOrigemCadastro("tjihi7sd68");
    	pessoaModel.setSexo("M");
		pessoaModel.setUsuarioModel(this.usuarioController.GetUsuarioSession());
		//INFORMANDO QUE O CADASTRO FOI VIA INPUT
		pessoaModel.setOrigemCadastro("I");
		pessoaRepository.SalvarNovoRegistro(this.pessoaModel);
		
		this.pessoaModel = null;
		
		Uteis.MensagemInfo("Registro cadastrado com sucesso");
		
	}

}
