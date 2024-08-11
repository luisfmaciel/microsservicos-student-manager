package br.edu.infnet.alunoservice.service;

import br.edu.infnet.alunoservice.model.Aluno;
import br.edu.infnet.alunoservice.repository.AlunoRepository;
import br.edu.infnet.alunoservice.service.feign.DisciplinaClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final DisciplinaClient disciplinaClient;

    public List<Aluno> listarAlunos() {
        return alunoRepository.findAll();
    }

    public Optional<Aluno> buscarAlunoPorId(String id) {
        return alunoRepository.findById(id);
    }

    public Aluno salvarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Aluno atualizarAluno(String alunoId, Aluno alunoAtualizado) {
        Optional<Aluno> alunoExistente = alunoRepository.findById(alunoId);
        if (alunoExistente.isPresent()) {
            alunoAtualizado.setId(alunoId);
            return alunoRepository.save(alunoAtualizado);
        }
        return null;
    }

    public void deletarAluno(String id) {
        alunoRepository.deleteById(id);
    }
}