package com.example.spring_boot_integration_test_jackson_serialization_issue.user;

import org.springframework.data.repository.CrudRepository;

interface UserRepository extends CrudRepository<User, Integer> {
}
