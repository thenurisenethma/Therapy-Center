package org.example.therapycenter.dto.tm;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class PatientTM {
    private String id;
    private String name;
    private String email;
    private String contact;

}
