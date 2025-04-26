package org.example.therapycenter.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaymentDTO {
    private String id;
    private String patientName;
    private String programName;
    private String amount;
    private String status;
}
