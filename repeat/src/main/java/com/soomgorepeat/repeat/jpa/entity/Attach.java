//package com.soomgorepeat.repeat.jpa.entity;
//
//import lombok.AccessLevel;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.hibernate.annotations.Fetch;
//
//import javax.persistence.*;
//import java.util.Date;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor(access = AccessLevel.PUBLIC)
//@Table(name="attach")
//@Entity
//public class Attach {
//
//    @Id
//    @Column(name="id", columnDefinition="int")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    @Column(name="file_name", columnDefinition = "varchar(500)")
//    private String fileName;
//
//    @Column(name="file_path", columnDefinition = "varchar(500)")
//    private String filePath;
//    @Column(name="uuid", columnDefinition="varchar(500)")
//    private String uuid;
//    @Column(name="date_created", columnDefinition="datetime")
//    private Date dateCreated;
//
//    @ManyToOne(targetEntity = Board.class, fetch= FetchType.LAZY)
//    @JoinColumn(name= "board", referencedColumnName = "id")
//    private Board board;
//
//}
