package org.example.therapycenter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "patient")
public class Patient implements SuperEntity {
    @Id
    @Column(name = "patient_id")
    private String id;
    private String name;
    private String email;
    private String contact;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Schedule> schedules = new ArrayList<>();
}