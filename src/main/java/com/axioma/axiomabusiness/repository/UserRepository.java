package com.axioma.axiomabusiness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.axioma.axiomabusiness.model.entity.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByRoles(Role role);

    List<User> findAllByGroups(Group group);

    List<User> findAllByHomeworks(Homework homework);

    List<User> findAllByFirstnameAndSurname(String firstname, String surname);

}
