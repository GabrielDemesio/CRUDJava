package api.projeto.ProjetoSOC.repositories;

import api.projeto.ProjetoSOC.models.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Repository

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
