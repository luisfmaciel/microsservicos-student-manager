package br.edu.infnet.disciplinaservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "disciplinas")
public class Disciplina {
    @Id
    private String id;
    private String nome;
    private List<String> alunos = new ArrayList<>();
}
