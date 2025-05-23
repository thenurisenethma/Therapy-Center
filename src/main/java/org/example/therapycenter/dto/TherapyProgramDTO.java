package org.example.therapycenter.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TherapyProgramDTO {
    private String id;
    private String programName;
    private String description;
    private String duration;
    private String fee;
}
