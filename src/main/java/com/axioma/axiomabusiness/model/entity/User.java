package com.axioma.axiomabusiness.model.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "username", nullable = false)
    String username;

    @Column(name = "password", nullable = false)
    String password;

    @Column(name = "firstname", nullable = false)
    String firstname;

    @Column(name = "surname", nullable = false)
    String surname;

    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    Date createdAt;

    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    Date updatedAt;

    @ManyToMany
            @JoinTable(name = "users_toles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    List<Group> groups;

    @ManyToMany
            @JoinTable(name = "users_homeworks",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    List<Homework> homeworks;

    @ManyToMany
            @JoinTable(name = "users_homeworks",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    List<Role> roles;

//    @ManyToMany
//            @JoinTable(name = "users_arithmetic_exercises",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "exercise_id"))
//    List<ArithmeticExercise> arithmeticExercises;

    @ManyToMany
            @JoinTable(name = "users_reading_exercises",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "exercise_id"))
    List<ReadingExercise> readingExercises;
}
