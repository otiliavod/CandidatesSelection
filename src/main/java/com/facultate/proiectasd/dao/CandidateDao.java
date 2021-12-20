package com.facultate.proiectasd.dao;

import com.facultate.proiectasd.model.Candidate;

import java.util.List;

public interface CandidateDao {

    List<Candidate> getAll();

    List<Candidate> getCandidatesFiltered(boolean withC5C7);

    List<Candidate> getAcceptedCandidates(int numarCandidatiNecesari);
}
