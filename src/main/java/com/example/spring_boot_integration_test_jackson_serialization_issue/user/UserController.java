package com.example.spring_boot_integration_test_jackson_serialization_issue.user;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@AllArgsConstructor
@RequestMapping("users")
public class UserController {

    private final UserRepository userRepository;

    @GetMapping
    public Collection<User> getAllUsers() {
        return (Collection<User>) userRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public User getUser(@PathVariable Integer id) {
        return userRepository.findOne(id);
    }

}
