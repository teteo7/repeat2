package com.soomgorepeat.repeat.jpa.repository;

import com.soomgorepeat.repeat.jpa.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

    @Query(value="SELECT u FROM Member u where u.name=:name", nativeQuery = false)
    Optional<Member> findByName1(@Param("name")String name);

    @Query(value="select * from user as u where u.name =:name", nativeQuery = true)
    Optional<Member> findByName2(@Param("name")String name);

    Optional<Member> findByName(String name);

    Optional<Member> findByAddress(String address);



}
