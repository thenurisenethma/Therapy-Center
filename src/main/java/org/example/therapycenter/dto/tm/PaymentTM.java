package org.example.therapycenter.dto.tm;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaymentTM {
    private String id;
    private String patientName;
    private String programName;
    private String amount;
    private String status;
}
