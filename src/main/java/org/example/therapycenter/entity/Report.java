package org.example.therapycenter.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "report")
public class Report implements SuperEntity {
    @Id
    @Column(name = "report_id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "therapist_id", referencedColumnName = "therapist_id")
    private Therapist therapist;
}
