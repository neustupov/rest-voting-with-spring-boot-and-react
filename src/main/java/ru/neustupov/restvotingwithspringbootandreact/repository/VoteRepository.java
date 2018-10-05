package ru.neustupov.restvotingwithspringbootandreact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.neustupov.restvotingwithspringbootandreact.model.Vote;

import java.util.List;

public interface VoteRepository extends JpaRepository<Long, Vote> {

    @Query("SELECT v FROM Vote v WHERE v.date=CURRENT_DATE AND v.restaurant.id=:restId")
    List<Vote> getAllForCurrentDateAndRestaurant(@Param("restId") long restId);
}
