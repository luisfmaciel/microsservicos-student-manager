package br.edu.infnet.disciplinaservice.service.feign;

import br.edu.infnet.disciplinaservice.model.Aluno;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("ALUNO-SERVICE")
public interface AlunoClient {
    @GetMapping("/api/alunos/{id}")
    Aluno getAluno(@PathVariable String id);
}
