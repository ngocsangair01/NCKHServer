package com.example.nghiencuukhoahoctest.models;


import com.example.nghiencuukhoahoctest.bases.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Role extends BaseEntity {

    @Column(name = "name_role")
    private String name;

    @OneToMany(mappedBy = "role")
    @JsonIgnore
    private Set<User> users;
}
