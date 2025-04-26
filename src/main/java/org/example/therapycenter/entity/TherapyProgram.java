package org.example.therapycenter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "therapy_program")
public class TherapyProgram implements SuperEntity{
    @Id
    @Column(name = "program_id")
    private String id;
    @ManyToOne
    @JoinColumn(name = "therapist_id", referencedColumnName = "therapist_id")
    private Therapist therapist;

    @Column(name = "program_name")
    private String programName;    private String description;
    private String duration;
    private double fee;

}
