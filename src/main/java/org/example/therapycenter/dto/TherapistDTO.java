package org.example.therapycenter.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TherapistDTO {
    private String id;
    private String patientName;
    private String therapistName;
    private String programName;
    private String date;
    private String time;
}
