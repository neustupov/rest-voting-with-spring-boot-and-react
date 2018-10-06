package ru.neustupov.restvotingwithspringbootandreact.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.neustupov.restvotingwithspringbootandreact.model.Vote;

import java.util.List;

public interface VoteRepository extends JpaRepository<Vote, Long> {

    /*@EntityGraph(attributePaths = {"restaurant"}, type = EntityGraph.EntityGraphType.LOAD)*/
    @Query("select v FROM Vote v WHERE v.date=CURRENT_DATE")
    List<Vote> getAllForCurrentDate();
}
