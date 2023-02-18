package com.soomgorepeat.repeat.jpa.repository;

import com.soomgorepeat.repeat.jpa.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer>, JpaSpecificationExecutor {

    Page<Board> findAll(Pageable pagealbe);
}
