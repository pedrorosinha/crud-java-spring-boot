package br.com.dbserver.crud.application.repositories;

import br.com.dbserver.crud.application.modelos.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
