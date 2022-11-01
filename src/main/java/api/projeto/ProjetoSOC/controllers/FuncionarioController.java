package api.projeto.ProjetoSOC.controllers;

import api.projeto.ProjetoSOC.models.Funcionario;
import api.projeto.ProjetoSOC.repositories.FuncionarioRepository;
import api.projeto.ProjetoSOC.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Validated
@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping()
    public List <Funcionario> list() {
        return funcionarioService.list();
    }
    //Obter dados
    @ResponseBody
    @GetMapping("/{id}")
    public ResponseEntity findById(@Valid @PathVariable @Min(value = 0L, message = "Id inválido!") Long id){
        return funcionarioService.findById(id);
    }

    @ResponseBody
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody Funcionario funcionario){
        funcionarioService.create(funcionario);
    }

    @ResponseBody
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Funcionario funcionario ){
        return funcionarioService.update(id, funcionario);
    }

    @ResponseBody
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        return funcionarioService.delete(id);
    }
}