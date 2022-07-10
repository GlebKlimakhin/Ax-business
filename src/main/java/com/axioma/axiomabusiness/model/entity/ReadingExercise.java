package com.axioma.axiomabusiness.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "reading_exercises")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReadingExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "data", nullable = false)
    String data;

    @Column(name = "duration")
    long duration;

    @Column(name = "score")
    int score;

    public void setId(long id) {
        this.id = id;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setDuration(long duration) {
        this.duration = duration;
        if(duration <= 10) {
            throw new RuntimeException("Impossible time, try again");
        }
        else if(duration < 40) {
            this.score = 5;
        }
        else if(duration < 50) {
            this.score = 4;
        }
        else {
            this.score = 3;
        }
    }

    public void setScore(int score) {
        this.score = score;
    }
}
