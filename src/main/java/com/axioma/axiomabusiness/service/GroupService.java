package com.axioma.axiomabusiness.service;

import com.axioma.axiomabusiness.model.entity.*;
import com.axioma.axiomabusiness.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {

    private GroupRepository groupRepository;

    @Autowired
    public void setGroupRepository(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    public Optional<Group> findByName(String name) {
        return groupRepository.findByName(name);
    }

    public Optional<Group> findById(Integer id) {
        return groupRepository.findById(id);
    }

    public void addUsers(Group group, List<User> users) {
        group.getStudents().addAll(users);
    }

    public void deleteUser(Group group, User user) {
        group.getStudents().remove(user);
    }
}
