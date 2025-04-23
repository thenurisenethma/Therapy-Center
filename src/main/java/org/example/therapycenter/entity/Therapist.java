package org.example.therapycenter.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "therapist")
public class Therapist implements SuperEntity{

    @Id
    @Column(name = "therapist_id")
    private String id;
    private String name;
    private String email;
    @ManyToOne
    @JoinColumn(name = "program_id", referencedColumnName = "program_id")
    private TherapyProgram assignedProgram;

    @ManyToOne
    @JoinColumn(name = "schedule_id", referencedColumnName = "schedule_id")
    private Schedule schedule;


}
