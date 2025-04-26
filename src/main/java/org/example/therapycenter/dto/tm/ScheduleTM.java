package org.example.therapycenter.dto.tm;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ScheduleTM {
    private String id;
    private String patientName;
    private String therapistName;
    private String programName;
    private String date;
    private String time;
}
