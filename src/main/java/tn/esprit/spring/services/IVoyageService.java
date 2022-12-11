package tn.esprit.spring.services;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.spring.entities.Ville;
import tn.esprit.spring.entities.Voyage;
import tn.esprit.spring.repository.VoyageRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface IVoyageService {

	 Voyage ajouterVoyage(Voyage v);
	 Voyage modifierVoyage(Voyage v);
	 void affecterTrainAVoyage(Long idTrain, Long idVoyage);
	 List<Voyage> recupererAll();
	 Voyage recupererVoyageParId(Long id);
	 Voyage supprimerVoyage(Long id);

	
}








