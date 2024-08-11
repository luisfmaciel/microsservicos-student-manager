package br.edu.infnet.disciplinaservice.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EnrollmentRequest {
    String studentId;
    String classId;
}
