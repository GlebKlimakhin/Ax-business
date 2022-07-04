package com.axioma.axiomabusiness.service;

import com.axioma.axiomabusiness.repository.GroupRepository;
import com.axioma.axiomabusiness.repository.HomeworkRepository;
import com.axioma.axiomabusiness.repository.RoleRepository;
import com.axioma.axiomabusiness.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.axioma.axiomabusiness.model.entity.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private GroupRepository groupRepository;
    private HomeworkRepository homeworkRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Autowired
    public void setGroupRepository(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Autowired
    public void setHomeworkRepository(HomeworkRepository homeworkRepository) {
        this.homeworkRepository = homeworkRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    public List<User> findAllByFirstnameAndSurname(String firstname, String surname) {
        return userRepository.findAllByFirstnameAndSurname(firstname, surname);
    }

    public List<User> findAllByRoleName(String roleName) throws EntityNotFoundException {
        return userRepository.findAllByRoles(roleRepository.findByName(roleName).orElseThrow(
                () -> new EntityNotFoundException("No such role found")));
    }

    public List<User> findAllByGroupName(String groupName) throws EntityNotFoundException {
        return userRepository.findAllByGroups(groupRepository.findByName(groupName).orElseThrow(
                ()-> new EntityNotFoundException("No such group found")));
    }

    public List<User> findAllByHomeworkId(long id) {
        return userRepository.findAllByHomework(homeworkRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No such homework found")));
    }

//    public Double getAverageScore(User user) {
//    }



}
