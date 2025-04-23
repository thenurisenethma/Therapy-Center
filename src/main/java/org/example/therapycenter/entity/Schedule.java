package org.example.therapycenter.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "schedule")
public class Schedule implements SuperEntity{
    @Id
    @Column(name = "schedule_id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "therapist_id", referencedColumnName = "therapist_id")
    private Therapist therapist;

    @ManyToOne
    @JoinColumn(name = "therapy_program_id", referencedColumnName = "program_id")
    private TherapyProgram therapyProgram;

    private String date;
    private String time;

}
