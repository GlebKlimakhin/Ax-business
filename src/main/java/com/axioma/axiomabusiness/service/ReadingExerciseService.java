package com.axioma.axiomabusiness.service;

import com.axioma.axiomabusiness.model.entity.ReadingExercise;
import com.axioma.axiomabusiness.repository.ReadingExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReadingExerciseService {

    private ReadingExerciseRepository exerciseRepository;

    @Autowired
    public void setExerciseRepository(ReadingExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public Optional<ReadingExercise> findById(long id) {
        return exerciseRepository.findById(id);
    }

    public void updateTimeById(long id, long duration) {
        exerciseRepository.update(id, duration);
    }


}
