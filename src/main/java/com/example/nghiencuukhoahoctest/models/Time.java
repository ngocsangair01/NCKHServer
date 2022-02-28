package com.example.nghiencuukhoahoctest.models;

import com.example.nghiencuukhoahoctest.bases.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "time")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Time extends BaseEntity {

    @CreationTimestamp
    @Column(name = "create_at")
    private Timestamp createAt;

    @UpdateTimestamp
    @Column(name = "update_at")
    private Timestamp updateAt;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User userTime;

    @ManyToOne
    @JoinColumn(name = "id_traffic")
    private Traffic trafficTime;
}
