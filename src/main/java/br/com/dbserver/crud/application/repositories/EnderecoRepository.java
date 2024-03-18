package br.com.dbserver.crud.application.repositories;

import br.com.dbserver.crud.application.modelos.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{
    
}
