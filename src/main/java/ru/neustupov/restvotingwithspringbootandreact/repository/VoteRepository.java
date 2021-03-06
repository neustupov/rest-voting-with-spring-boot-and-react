package ru.neustupov.restvotingwithspringbootandreact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.neustupov.restvotingwithspringbootandreact.model.Vote;
import ru.neustupov.restvotingwithspringbootandreact.model.VoteCount;

import java.util.List;

public interface VoteRepository extends JpaRepository<Vote, Long> {

    @Query("SELECT NEW ru.neustupov.restvotingwithspringbootandreact.model.VoteCount(v.restaurant.id, count (v.id)) FROM Vote v WHERE v.date=CURRENT_DATE GROUP BY v.restaurant.id")
    List<VoteCount> getVoteCountForCurrentDate();

    @Override
    @Transactional
    Vote save(Vote vote);
}
