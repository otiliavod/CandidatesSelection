package com.facultate.proiectasd.service;

import com.facultate.proiectasd.dao.CandidateDao;
import com.facultate.proiectasd.model.Candidate;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CandidateService {
    public final CandidateDao candidateDao;

    public CandidateService(CandidateDao candidateDao) {
        this.candidateDao = candidateDao;
    }

    public List<Candidate> getAllCandidates() {
        return candidateDao.getAll();
    }

    public List<Candidate> getCandidatesFiltered(boolean withC5C7) {
        return candidateDao.getCandidatesFiltered(withC5C7);
    }

    public List<Candidate> getAcceptedCandidates(int numarCandidatiNecesari) {
        return candidateDao.getAcceptedCandidates(numarCandidatiNecesari);
    }
}
