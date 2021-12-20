package com.facultate.proiectasd.controller;

import com.facultate.proiectasd.model.Candidate;
import com.facultate.proiectasd.service.CandidateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/candidate", produces = APPLICATION_JSON_VALUE)
public class CandidateController {
    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping("/getAllCandidates")
    public List<Candidate> getAllCandidates() {
        return candidateService.getAllCandidates();
    }

    @GetMapping("/candidatesWithC5C7")
    public List<Candidate> getCandidatesWithC5C7() {
        return candidateService.getCandidatesFiltered(true);
    }

    @GetMapping("/candidatesWithoutC5C7")
    public List<Candidate> getCandidatesWithoutC5C7() {
        return candidateService.getCandidatesFiltered(false);
    }

    @GetMapping(path = "/getAcceptedCandidates/{numarCandidati}")
    public List<Candidate> getAcceptedCandidates(@PathVariable int numarCandidati) {
        return candidateService.getAcceptedCandidates(numarCandidati);
    }
}
