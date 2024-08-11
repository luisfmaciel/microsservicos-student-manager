package br.edu.infnet.disciplinaservice.repository;

import br.edu.infnet.disciplinaservice.model.Disciplina;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DisciplinaRepository extends MongoRepository<Disciplina, String> {
}