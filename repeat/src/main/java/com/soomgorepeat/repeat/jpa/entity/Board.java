package com.soomgorepeat.repeat.jpa.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Table(name="board")
@Entity
public class Board {

    @Id
    @Column(name="id", columnDefinition="int")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="title", columnDefinition="varchar(120)")
    private String title;
    @Column(name="content", columnDefinition="mediumtext")
    private String content;
    @Column(name="date_created", columnDefinition="datetime")
    private Date dateCreated;

    @ManyToOne(targetEntity = Member.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "member", referencedColumnName="id")
    private Member member;

//    @JsonManagedReference
//    @OneToMany(mappedBy = "board", fetch=FetchType.LAZY, cascade = CascadeType.PERSIST, targetEntity = RelUserBoardFavorite.class)
//    private Collection<RelUserBoardFavorite> relUserBoardFavorites;


}
