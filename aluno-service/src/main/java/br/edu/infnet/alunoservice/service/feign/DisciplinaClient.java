package br.edu.infnet.alunoservice.service.feign;

import br.edu.infnet.alunoservice.service.EnrollmentRequest;
import br.edu.infnet.alunoservice.service.EnrollmentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("DISCIPLINA-SERVICE")
public interface DisciplinaClient {
    @PostMapping("/api/disciplinas/enroll")
    EnrollmentResponse enrollmentStudent(EnrollmentRequest request);
}