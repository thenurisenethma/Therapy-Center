package org.example.therapycenter.dto.tm;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TherapistTM {
    private String  id;
    private String name;
    private String email;
    private String assignedProgram;
    private String schedule;
}
