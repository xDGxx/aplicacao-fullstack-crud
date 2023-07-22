package br.com.api.cabelleza.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.cabelleza.modelo.RespostaModelo;
import br.com.api.cabelleza.modelo.SaloesModelo;
import br.com.api.cabelleza.repositorio.SaloesRepositorio;

@Service
public class SaloesServico {

    @Autowired
    private SaloesRepositorio sr;

    @Autowired
    private RespostaModelo rm;

    //Metodo para listar todos os produtos

    public Iterable<SaloesModelo> listar(){
        return sr.findAll(); 
    }
    
    //Metodo para Cadastro ou Alteração de Salões
    public ResponseEntity<?> cadastrarAlterar(SaloesModelo sm, String acao){

        if(sm.getNomeSalao().equals("")){
            rm.setMensagem("O nome do salão é obrigatório!");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        } else if(sm.getProprietarioSalao().equals("")){
            rm.setMensagem("O nome do proprietario é obrigatório");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        } else if(sm.getEmail().equals("")){
            rm.setMensagem("O Email é obrigatório");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        } else if(sm.getSenha().equals("")){
            rm.setMensagem("A senha é obrigatória");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        } else if(sm.getRuaSalao().equals("")){
            rm.setMensagem("A rua do salão é obrigatória");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        } else if(sm.getNumeroSalao().equals("")){
            rm.setMensagem("O número do salão é obrigatório");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }else if(sm.getBairroSalao().equals("")){
            rm.setMensagem("O bairro do salão é obrigatório");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }else if(sm.getCnpj().equals("")){
            rm.setMensagem("O CNPJ do salão é obrigatório");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }else if(sm.getTelefoneSalao().equals("")){
            rm.setMensagem("O telefone do salão é obrigatório");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }else if(sm.getSeloSalao().equals("")){
            rm.setMensagem("Informe o selo do seu salão");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }else{
            if(acao.equals("cadastrar")){
                return new ResponseEntity<SaloesModelo>(sr.save(sm), HttpStatus.CREATED); //CREATED = Cria um cadastro
            } else{  //O Metodo ".save" serve tanto para a criação quanto para a alteração
                return new ResponseEntity<SaloesModelo>(sr.save(sm), HttpStatus.OK); //OK = Altera um cadastro
            }
        }
            
    }

    //Metodo para Remover Salões
    public ResponseEntity<RespostaModelo> remover(long id){

        sr.deleteById(id); //Remove o Id do Salão
        
        rm.setMensagem("O Salão foi removido com sucesso!");
        return new ResponseEntity<RespostaModelo>(rm, HttpStatus.OK);
    }
}
