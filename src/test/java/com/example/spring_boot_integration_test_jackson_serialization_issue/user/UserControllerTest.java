package com.example.spring_boot_integration_test_jackson_serialization_issue.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void getUserShouldReturnData() {

        ResponseEntity<User> response = testRestTemplate.getForEntity("/users/{id}", User.class, 1);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        assertThat(response.getBody().getName()).isEqualTo("Muhammed Suiçmez");
        assertThat(response.getBody().getNonEditableProperty()).isEqualTo("Non editable property");

    }
}