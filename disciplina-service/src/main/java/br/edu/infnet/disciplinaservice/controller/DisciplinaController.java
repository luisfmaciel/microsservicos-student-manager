package br.edu.infnet.disciplinaservice.controller;

import br.edu.infnet.disciplinaservice.model.Disciplina;
import br.edu.infnet.disciplinaservice.service.DisciplinaService;
import br.edu.infnet.disciplinaservice.service.EnrollmentRequest;
import br.edu.infnet.disciplinaservice.service.EnrollmentResponse;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/disciplinas")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;

    @GetMapping
    public ResponseEntity<List<Disciplina>> listarDisciplinas() {
        return ResponseEntity.ok(disciplinaService.listarDisciplinas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Disciplina> buscarDisciplinaPorId(@PathVariable String id) {
        Optional<Disciplina> disciplina = disciplinaService.buscarDisciplinaPorId(id);
        return disciplina.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Disciplina> salvarDisciplina(@RequestBody Disciplina disciplina) {
        Disciplina salvo = disciplinaService.salvarDisciplina(disciplina);
        return ResponseEntity.status(HttpStatus.SC_CREATED).body(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Disciplina> atualizarDisciplina(@PathVariable String id, @RequestBody Disciplina disciplinaAtualizada) {
        Disciplina disciplina = disciplinaService.atualizarDisciplina(id, disciplinaAtualizada);
        if (disciplina != null) {
            return ResponseEntity.ok(disciplina);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarDisciplina(@PathVariable String id) {
        disciplinaService.deletarDisciplina(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/enroll")
    public ResponseEntity<EnrollmentResponse> enrollmentStudent(@RequestBody EnrollmentRequest request) {
        Optional<Disciplina> discipline = disciplinaService.buscarDisciplinaPorId(request.getClassId());
        EnrollmentResponse response = new EnrollmentResponse();
        if (discipline.isPresent()) {
            discipline.get().getAlunos().add(request.getStudentId());
            disciplinaService.atualizarDisciplina(request.getClassId(), discipline.get());
            response.setDisciplinaId(discipline.get().getId());
            response.setMessage("Enrollment successful");
            response.setSuccess(true);
            return ResponseEntity.status(HttpStatus.SC_CREATED).body(response);
        } else {
            response.setMessage("Enrollment failed");
            response.setSuccess(false);
            return ResponseEntity.status(HttpStatus.SC_NOT_FOUND).body(response);
        }

    }
}