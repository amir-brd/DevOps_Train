package tn.esprit.spring.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Train;
import tn.esprit.spring.entities.Voyage;
import tn.esprit.spring.repository.TrainRepository;
import tn.esprit.spring.repository.VoyageRepository;

import java.util.List;

@Service
@Slf4j
public class VoyageServiceImpl implements IVoyageService {
    @Autowired
    VoyageRepository voyageRepository;
    @Autowired
    TrainRepository trainRepository;
    @Override
    public Voyage ajouterVoyage(Voyage v) {
        log.info("In method ajouterVoyage");
        voyageRepository.save(v);
        return v;
    }

    @Override
    public Voyage modifierVoyage(Voyage v) {
        log.info("In method ajouterVoyage");
		return voyageRepository.save(v);
    }


    public void affecterTrainAVoyage(Long idTrain, Long idVoyage) {

        Train t = trainRepository.findById(idTrain).get();
        Voyage v = voyageRepository.findById(idVoyage).get();
        v.setTrain(t);
        voyageRepository.save(v);
    }

    @Override
    public List<Voyage> recupererAll() {
        List<Voyage> list = (List<Voyage>) voyageRepository.findAll();
        return list;
    }

    @Override
    public Voyage recupererVoyageParId(Long id) {
        Voyage v = voyageRepository.findById(id).orElse(null);
        return v;
    }

    @Override
    public Voyage supprimerVoyage(Long id) {
        log.info("In method supprimerVoyage");
        voyageRepository.deleteById(id);
        return voyageRepository.findById(id).orElse(null);
    }

}
