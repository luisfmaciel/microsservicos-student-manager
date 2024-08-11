package br.edu.infnet.alunoservice.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EnrollmentResponse extends BaseResponse {
    String disciplinaId;
}
