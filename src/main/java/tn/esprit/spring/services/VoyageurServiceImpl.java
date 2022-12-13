package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entities.Voyageur;


import tn.esprit.spring.repository.VoyageurRepository;


@Service
@Slf4j
public class VoyageurServiceImpl implements IVoyageurService{

	@Autowired
	VoyageurRepository voyageurRepository;

	public Voyageur ajouterVoyageur(Voyageur v) {
		log.info("In method ajouterVoyageur");
		voyageurRepository.save(v);
		return v;
    }

	@Override
	public Voyageur modifierVoyageur(Voyageur v) {
		log.info("In method modifierVoyageur");
		return voyageurRepository.save(v);
	}

	@Override
	public List<Voyageur> recupererAll() {
		List<Voyageur> list= (List<Voyageur>) voyageurRepository.findAll();
		//Afficher la liste des voyageurs
		for (Voyageur v: list) {
			System.err.print("Voyageur");
			System.out.print(v.toString()+"\n");
		}
		return list;
	}

	@Override
	public Voyageur recupererVoyageParId(long idVoyageur) {
		return null;
	}

	@Override
	public Voyageur supprimerVoyageur(Long id) {
		log.info("In method supprimerVoyageur");
		voyageurRepository.deleteById(id);
		return voyageurRepository.findById(id).orElse(null);
	}

}
