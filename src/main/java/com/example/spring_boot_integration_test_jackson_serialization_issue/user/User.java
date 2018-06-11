package com.example.spring_boot_integration_test_jackson_serialization_issue.user;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Entity
class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String nonEditableProperty;

    User() {
    }

    public User(String name, String nonEditableProperty) {
        this.name = name;
        this.nonEditableProperty = nonEditableProperty;
    }

}
