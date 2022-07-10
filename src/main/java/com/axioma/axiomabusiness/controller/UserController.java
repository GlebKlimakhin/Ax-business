package com.axioma.axiomabusiness.controller;

import com.axioma.axiomabusiness.model.dto.UserDto;
import com.axioma.axiomabusiness.model.entity.*;
import com.axioma.axiomabusiness.service.UserService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserController {

    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto findById(@PathVariable Long id) {
        return userService.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("User with id %s", id)));
    }

    @GetMapping("/firstname={firstname}&surname={surname}")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> findAllByFirstnameAndSurname(@PathVariable String firstname, @PathVariable String surname) {
        return userService.findAllByFirstnameAndSurname(firstname, surname);
    }

    @GetMapping("/role={role}")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> findAllByRoleName(@PathVariable(name = "role") String roleName) {
        return userService.findAllByRoleName(roleName);
    }

    @GetMapping("/groupId={groupId}")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> findAllByGroupId(@PathVariable Integer groupId) {
        return userService.findAllByGroupId(groupId);
    }

    @GetMapping("/homeworkId={homeworkId}")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> findAllByHomeworkId(@PathVariable Long homeworkId) {
        return userService.findAllByHomeworkId(homeworkId);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }



}
