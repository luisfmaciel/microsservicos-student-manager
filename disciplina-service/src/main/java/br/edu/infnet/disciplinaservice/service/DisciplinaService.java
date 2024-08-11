package br.edu.infnet.disciplinaservice.service;

import br.edu.infnet.disciplinaservice.model.Disciplina;
import br.edu.infnet.disciplinaservice.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public List<Disciplina> listarDisciplinas() {
        return disciplinaRepository.findAll();
    }

    public Optional<Disciplina> buscarDisciplinaPorId(String id) {
        return disciplinaRepository.findById(id);
    }

    public Disciplina salvarDisciplina(Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    public Disciplina atualizarDisciplina(String id, Disciplina disciplinaAtualizada) {
        Optional<Disciplina> disciplinaExistente = disciplinaRepository.findById(disciplinaAtualizada.getId());
        if (disciplinaExistente.isPresent()) {
            disciplinaAtualizada.setId(id);
            return disciplinaRepository.save(disciplinaAtualizada);
        }
        return null;
    }

    public void deletarDisciplina(String id) {
        disciplinaRepository.deleteById(id);
    }
}