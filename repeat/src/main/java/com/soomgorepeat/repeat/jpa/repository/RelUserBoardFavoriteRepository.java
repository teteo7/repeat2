package com.soomgorepeat.repeat.jpa.repository;

import com.soomgorepeat.repeat.jpa.entity.Board;
import com.soomgorepeat.repeat.jpa.entity.Member;
import com.soomgorepeat.repeat.jpa.entity.RelUserBoardFavorite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RelUserBoardFavoriteRepository extends JpaRepository<RelUserBoardFavorite, Integer> {

    Page<RelUserBoardFavorite> findAllByMember(Member member, Pageable pagealbe);
    List<RelUserBoardFavorite> findByMember(Member member);

    Boolean existByMemberAndBoard(Member member, Board board);

    @Transactional
    @Modifying
    void deleteByMemberAndBoard(Member member, Board board);



}
