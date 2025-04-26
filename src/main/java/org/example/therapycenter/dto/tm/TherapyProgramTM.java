package org.example.therapycenter.dto.tm;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TherapyProgramTM {
    private String id;
    private String programName;
    private String description;
    private String duration;
    private String fee;
}
