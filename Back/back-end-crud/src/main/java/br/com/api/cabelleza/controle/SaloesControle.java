package br.com.api.cabelleza.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.cabelleza.modelo.RespostaModelo;
import br.com.api.cabelleza.modelo.SaloesModelo;
import br.com.api.cabelleza.servico.SaloesServico;

@RestController
@CrossOrigin(origins = "*")
public class SaloesControle {
    
    @Autowired
    private SaloesServico ss;

    @DeleteMapping("/remover/{id}") //@DeleteMapping declara remoção
    //O {id} serve para que seja especificado o id para remoção
    public ResponseEntity<RespostaModelo> remover(@PathVariable long id){ //@PathVariable captura a informação codigo que é passada via URL
        return ss.remover(id);

    }

    @PutMapping("/alterar") //@PutMapping declara alteração
    public ResponseEntity<?> alterar (@RequestBody SaloesModelo sm){
        return ss.cadastrarAlterar(sm, "alterar");
    }

    @PostMapping("/cadastrar") //@PostMapping declara criação
    public ResponseEntity<?> cadastrar (@RequestBody SaloesModelo sm){
        return ss.cadastrarAlterar(sm, "cadastrar");
    }

    @GetMapping("/listar") //@GetMapping declara a analise de dados inseridos após o POST
    public Iterable<SaloesModelo> listar(){
        return ss.listar();
    }

    @GetMapping("/")
    public String rota(){
        return "Porque fazer o bem, faz bem!";
    }

}
