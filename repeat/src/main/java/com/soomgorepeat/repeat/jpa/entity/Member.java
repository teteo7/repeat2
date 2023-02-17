package com.soomgorepeat.repeat.jpa.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Table(name="member")
@Entity
public class Member {

    @Id
    @Column(name="id", columnDefinition = "int")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name", columnDefinition="varchar(32)")
    private String name;

    @Column(name="password", columnDefinition="varchar(500)")
    private String password;

    @Column(name="address", columnDefinition="varchar(50)")
    private String address;

    @Column(name="type", columnDefinition="varchar(10)")
    private String type;
}
