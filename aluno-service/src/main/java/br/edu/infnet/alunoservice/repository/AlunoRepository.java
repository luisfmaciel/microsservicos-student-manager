package br.edu.infnet.alunoservice.repository;

import br.edu.infnet.alunoservice.model.Aluno;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlunoRepository extends MongoRepository<Aluno, String> {
}