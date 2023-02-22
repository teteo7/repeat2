//package com.soomgorepeat.repeat.jpa.entity;
//
//import lombok.AccessLevel;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor(access = AccessLevel.PUBLIC)
//@Table(name="rel_user_board_favorite")
//@Entity
//public class RelUserBoardFavorite {
//
//    @Id
//    @Column(name="id", columnDefinition="int")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    @ManyToOne(targetEntity = Member.class, fetch = FetchType.LAZY)
//    @JoinColumn(name = "member", referencedColumnName="id")
//    private Member member;
//
//    @ManyToOne(targetEntity = Board.class, fetch = FetchType.LAZY)
//    @JoinColumn(name = "board", referencedColumnName="id")
//    private Board board;
//
//}
