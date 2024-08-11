package br.edu.infnet.alunoservice.service;

import br.edu.infnet.alunoservice.service.feign.DisciplinaClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnrollmentService {
    private final DisciplinaClient disciplinaClient;
    public EnrollmentResponse enrollmentStudent(EnrollmentRequest enrollmentRequest) {
        return disciplinaClient.enrollmentStudent(enrollmentRequest);
    }
}
