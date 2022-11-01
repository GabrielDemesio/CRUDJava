package api.projeto.ProjetoSOC.services;

import api.projeto.ProjetoSOC.models.Funcionario;
import api.projeto.ProjetoSOC.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.Calendar;
import java.util.List;

@Service
public class FuncionarioService {


    @Autowired
    private FuncionarioRepository funcionarioRepository;


    public List<Funcionario> list() {
        return funcionarioRepository.findAll();
    }
    public ResponseEntity findById(@PathVariable Long id){
        return funcionarioRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @Transactional
    public void create(@RequestBody Funcionario funcionario){
        funcionario.setDate(Calendar.getInstance().getTime());
        funcionarioRepository.save(funcionario);
    }

    public ResponseEntity update(@PathVariable("id") long id, @RequestBody Funcionario funcionario ){
        return funcionarioRepository.findById(id)
                .map(record -> {
                    record.setName(funcionario.getName());
                    record.setExame(funcionario.getExame());
                    Funcionario updated = funcionarioRepository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }
    public ResponseEntity <?> delete(@PathVariable long id){
        return funcionarioRepository.findById(id)
                .map(record -> {
                    funcionarioRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }


}
