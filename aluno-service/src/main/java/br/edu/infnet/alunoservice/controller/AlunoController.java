package br.edu.infnet.alunoservice.controller;

import br.edu.infnet.alunoservice.model.Aluno;
import br.edu.infnet.alunoservice.service.AlunoService;
import br.edu.infnet.alunoservice.service.EnrollmentRequest;
import br.edu.infnet.alunoservice.service.EnrollmentResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.ObjectUtils;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/alunos")
@Slf4j
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<Aluno>> listarAlunos() {
        return ResponseEntity.ok(alunoService.listarAlunos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarAlunoPorId(@PathVariable String id) {
        Optional<Aluno> aluno = alunoService.buscarAlunoPorId(id);
        return aluno.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Aluno> salvarAluno(@RequestBody Aluno aluno) {
        Aluno salvo = alunoService.salvarAluno(aluno);
        return ResponseEntity.status(HttpStatus.SC_CREATED).body(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizarAluno(@PathVariable String id, @RequestBody Aluno alunoAtualizado) {
        Aluno aluno = alunoService.atualizarAluno(id, alunoAtualizado);
        if (aluno != null) {
            return ResponseEntity.ok(aluno);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAluno(@PathVariable String id) {
        alunoService.deletarAluno(id);
        return ResponseEntity.noContent().build();
    }
}