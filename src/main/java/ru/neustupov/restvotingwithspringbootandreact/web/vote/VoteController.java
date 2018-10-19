package ru.neustupov.restvotingwithspringbootandreact.web.vote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.neustupov.restvotingwithspringbootandreact.model.Vote;
import ru.neustupov.restvotingwithspringbootandreact.service.VoteService;

import java.net.URI;
import java.time.LocalTime;

@RestController
@RequestMapping("/votes")
public class VoteController {

    private final Logger log = LoggerFactory.getLogger(RestController.class);

    static final LocalTime STOP_TIME = LocalTime.of(11, 00, 00, 00);

    @Autowired
    private VoteService voteService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Vote> createWithLocation(@RequestBody Vote vote) {

        log.info("Request to create vote");

        Vote created = voteService.save(vote);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("votes/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }
}
