package org.example.therapycenter.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PatientDTO {
    private String id;
    private String name;
    private String email;
    private String contact;
}
