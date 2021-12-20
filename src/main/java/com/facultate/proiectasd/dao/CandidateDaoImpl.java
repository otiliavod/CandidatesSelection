package com.facultate.proiectasd.dao;

import com.facultate.proiectasd.model.Candidate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Repository
public class CandidateDaoImpl implements CandidateDao {

    private final List<Candidate> allCandidates = new ArrayList();

    @PostConstruct
    private void initAllCandidates() {
        allCandidates.add(new Candidate("Anton Petru", "anton.petru@gmail.com",
                List.of(new String[]{"1", "2", "5", "6", "10"})));

        allCandidates.add(new Candidate("Codrina Anca", "anca.c@gmail.com",
                List.of(new String[]{"1", "4", "5", "6","7", "11"})));

        allCandidates.add(new Candidate("Marieta Radavoi", "m.radavoi@gmail.com",
                List.of(new String[]{"1", "5", "6", "7", "8", "11"})));

        allCandidates.add(new Candidate("Monica Petrescu", "petrescu.monica@gmail.com",
                List.of(new String[]{"1", "3", "5", "7", "9", "10", "11"})));

        allCandidates.add(new Candidate("Dan Ionescu", "danionescu@gmail.com",
                List.of(new String[]{"1", "2", "3", "4", "5", "7", "9"})));

        allCandidates.add(new Candidate("Mihai Popescu", "popescu.mihai@gmail.com",
                List.of(new String[]{"1", "3", "6", "11"})));

    }

    @Override
    public List<Candidate> getAll() {
        return allCandidates;
    }

    @Override
    public List<Candidate> getCandidatesFiltered(boolean withC5C7) {
        List<Candidate> c = new ArrayList<>();

        allCandidates.forEach(candidate -> {
            if((candidate.getCriterias().contains("5") && candidate.getCriterias().contains("7")) == withC5C7){
                c.add(candidate);
            }
        });

        Collections.sort(c);

        return c;
    }

    @Override
    public List<Candidate> getAcceptedCandidates(int numarCandidatiNecesari) {
        List<Candidate> accepted = new ArrayList<>();
        List<Candidate> filteredWith = this.getCandidatesFiltered(true);
        List<Candidate> filteredWithout = this.getCandidatesFiltered(false);

        accepted.addAll(filteredWith);
        accepted.addAll(filteredWithout);

        return accepted.subList(0, numarCandidatiNecesari);
    }

}
