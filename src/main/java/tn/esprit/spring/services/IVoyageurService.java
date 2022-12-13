package tn.esprit.spring.services;


import tn.esprit.spring.entities.Voyageur;

import java.util.List;


public interface IVoyageurService {
    Voyageur ajouterVoyageur(Voyageur voyageur);
    //Modifier le voyageur
    Voyageur modifierVoyageur(Voyageur voyageur);
    List<Voyageur> recupererAll();
    Voyageur recupererVoyageParId(long idVoyageur);
    Voyageur supprimerVoyageur(Long idVoyageur);
}
