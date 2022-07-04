package com.axioma.axiomabusiness.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "homeworks")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Homework {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "start_date")
    @CreationTimestamp
    Date start;

    @Column(name = "deadline_date")
    Date deadline;

    @ManyToMany
            @JoinTable(name = "homeworks_exercises",
            joinColumns = @JoinColumn(name = "homework_id"),
            inverseJoinColumns = @JoinColumn(name = "exercise_id"))
    Set<ArithmeticExercise> arithmeticExercises;

    @ManyToOne
    @JoinColumn(name = "group_id")
    Group group;

}
