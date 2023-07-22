package br.com.api.cabelleza.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.api.cabelleza.modelo.SaloesModelo;

@Repository
public interface SaloesRepositorio extends CrudRepository<SaloesModelo, Long>{
    
}
