package ru.neustupov.restvotingwithspringbootandreact.service;

import javassist.NotFoundException;
import ru.neustupov.restvotingwithspringbootandreact.model.Vote;
import ru.neustupov.restvotingwithspringbootandreact.to.VoteTo;

public interface VoteService {

    Vote get(long id) throws NotFoundException;

    Vote save(VoteTo voteTo);
}
