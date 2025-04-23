package org.example.therapycenter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "payment")
public class Payment implements SuperEntity {
    @Id
    @Column(name = "payment_id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "program_id", referencedColumnName = "program_id")
    private TherapyProgram therapyProgram;

    private double amount;
    private String status;
}
