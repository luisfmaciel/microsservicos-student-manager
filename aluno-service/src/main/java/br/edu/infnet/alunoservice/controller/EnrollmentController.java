package br.edu.infnet.alunoservice.controller;

import br.edu.infnet.alunoservice.model.Aluno;
import br.edu.infnet.alunoservice.service.AlunoService;
import br.edu.infnet.alunoservice.service.EnrollmentRequest;
import br.edu.infnet.alunoservice.service.EnrollmentResponse;
import br.edu.infnet.alunoservice.service.EnrollmentService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/enrollment")
@Slf4j
public class EnrollmentController {
    @Autowired
    private AlunoService alunoService;
    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping
    public ResponseEntity<EnrollmentResponse> EnrollmentStudent(@RequestBody EnrollmentRequest request , HttpServletRequest httpRequest) {
        String endpoint = httpRequest.getRequestURI();
        log.info(endpoint);
        int status = HttpStatus.SC_CREATED;
        EnrollmentResponse response;
        Optional<Aluno> student = alunoService.buscarAlunoPorId(request.getStudentId());
        if (student.isPresent()) {
            response = enrollmentService.enrollmentStudent(request);
            if (!response.isSuccess()) {
                status = HttpStatus.SC_BAD_REQUEST;
            } else {
                student.get().getDisciplinas().add(response.getDisciplinaId());
                alunoService.atualizarAluno(student.get().getId(), student.get());
            }
            return ResponseEntity.status(status).body(response);
        }
        return ResponseEntity.notFound().build();
    }
}
