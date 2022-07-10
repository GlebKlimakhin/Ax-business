package com.axioma.axiomabusiness.repository;

import com.axioma.axiomabusiness.model.entity.ReadingExercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ReadingExerciseRepository extends JpaRepository<ReadingExercise, Long> {

    @Modifying
    @Query("update ReadingExercise e set e.duration = :duration where e.id = :id")
    void update(long id, long duration);
}
