/*
package tn.esprit.spring.services;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Voyageur;
import tn.esprit.spring.repository.VoyageurRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@Slf4j
class VoyageurServiceImplTest {
    @Mock
    VoyageurRepository voyageurRepository;
    @InjectMocks
    VoyageurServiceImpl voyageurService;

    Voyageur v1 = new Voyageur(1L,"Amir");
    Voyageur v2 = new Voyageur(2L,"Alaa");
    List<Voyageur> voyageurs = new ArrayList<Voyageur>() {
        {
            add(new Voyageur(3L, "Ali"));
            add(new Voyageur(4L, "Saleh"));
        }
    };

    //@Before
    //public void init() {
    //    MockitoAnnotations.initMocks(this);
    //}
    @Test
    public void listeVoyageursTest() {
        Mockito.when(voyageurRepository.findAll()).thenReturn(voyageurs);
        List<Voyageur> result = voyageurService.recupererAll();
        Assertions.assertEquals(voyageurs, result);
    }

    @Test
    public void ajouterVoyageurTest(){
        Voyageur voyageur=new Voyageur(5L, "Atef");
        Mockito.when(voyageurRepository.save(voyageur)).thenReturn(voyageur);
        assertEquals(voyageur, voyageurService.ajouterVoyageur(voyageur));
    }

    @Test
    public void supprimerVoyageurTest() {
        Mockito.doNothing().when(voyageurRepository).deleteById(v1.getIdVoyageur());
        Mockito.when(voyageurRepository.findById(1L)).thenReturn(Optional.ofNullable(null));
        Voyageur result = voyageurService.supprimerVoyageur(v1.getIdVoyageur());
        Assertions.assertNull(result);
    }

    @Test
    public void updateVoyageurTest() {
        Mockito.when(voyageurRepository.save(v2)).thenReturn(v2);
        Voyageur result = voyageurService.modifierVoyageur(v2);
        Assertions.assertEquals(result, v2);
    }

}*/
