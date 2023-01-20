package com.artificalyzer.models.userroles.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ur_user", schema = "userroles")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(unique = true)
    private String email;

    private String password;
    @Column(name = "enabled")
    private Boolean isEnabled;

    @Column(name = "date_created")
    private OffsetDateTime dateCreated;

    @Column(name = "date_modified")
    private OffsetDateTime dateModified;


    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.isEnabled = false;
        this.dateCreated = OffsetDateTime.now();
        this.dateModified = OffsetDateTime.now();
        this.roleList = new ArrayList<>();
    }

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<UserRole> roleList;

}