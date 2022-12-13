package tn.esprit.spring.services;


import tn.esprit.spring.entities.Voyage;
import java.util.List;

public interface IVoyageService {

	 Voyage ajouterVoyage(Voyage v);
	 Voyage modifierVoyage(Voyage v);
	 void affecterTrainAVoyage(Long idTrain, Long idVoyage);
	 List<Voyage> recupererAll();
	 Voyage recupererVoyageParId(Long id);
	 Voyage supprimerVoyage(Long id);

	
}








