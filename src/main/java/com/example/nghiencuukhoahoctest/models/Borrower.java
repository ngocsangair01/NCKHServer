package com.example.nghiencuukhoahoctest.models;

import com.example.nghiencuukhoahoctest.bases.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "borrower")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Borrower extends BaseEntity {

    @Column(name = "code_user",unique = true)
    private Integer code;

    @ManyToOne
    @JoinColumn(name = "id_traffic")
    private Traffic traffic;
}
