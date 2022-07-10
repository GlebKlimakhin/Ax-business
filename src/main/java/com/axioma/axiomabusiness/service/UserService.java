package com.axioma.axiomabusiness.service;

import com.axioma.axiomabusiness.model.dto.UserDto;
import com.axioma.axiomabusiness.repository.GroupRepository;
import com.axioma.axiomabusiness.repository.HomeworkRepository;
import com.axioma.axiomabusiness.repository.RoleRepository;
import com.axioma.axiomabusiness.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.axioma.axiomabusiness.model.entity.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private GroupRepository groupRepository;
    private HomeworkRepository homeworkRepository;
    private ModelMapper modelMapper;

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

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    public Optional<UserDto> findById(long id) {
        return userRepository.findById(id).map(this::mapToDto);
    }

    public List<UserDto> findAllByFirstnameAndSurname(String firstname, String surname) {
        return userRepository.findAllByFirstnameAndSurname(firstname, surname).stream().map(this::mapToDto).collect(Collectors.toList());
    }

    public List<UserDto> findAllByRoleName(String roleName) {
        return userRepository.findAllByRoles(roleRepository.findByName(roleName).orElseThrow(
                () -> new EntityNotFoundException("No such role found"))).stream().map(this::mapToDto).collect(Collectors.toList());
    }

    public List<UserDto> findAllByGroupName(String groupName) throws EntityNotFoundException {
        return userRepository.findAllByGroups(groupRepository.findByName(groupName).orElseThrow(
                ()-> new EntityNotFoundException("No such group found"))).stream().map(this::mapToDto).collect(Collectors.toList());
    }

    public List<UserDto> findAllByGroupId(Integer groupId) {
        return userRepository.findAllByGroups(groupRepository.findById(groupId).orElseThrow(
                ()-> new EntityNotFoundException("No such group found"))).stream().map(this::mapToDto).collect(Collectors.toList());
    }

    public List<UserDto> findAllByHomeworkId(long id) {
        return userRepository.findAllByHomeworks(homeworkRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No such homework found"))).stream().map(this::mapToDto).collect(Collectors.toList());
    }

    private UserDto mapToDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

//    public Double getAverageScore(User user) {
//    }



}
