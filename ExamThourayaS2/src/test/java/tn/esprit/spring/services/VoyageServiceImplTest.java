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
import tn.esprit.spring.entities.Ville;
import tn.esprit.spring.entities.Voyage;
import tn.esprit.spring.entities.Voyageur;
import tn.esprit.spring.repository.VoyageRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@Slf4j
class VoyageServiceImplTest {
    @Mock
    VoyageRepository voyageRepository;
    @InjectMocks
    VoyageServiceImpl voyageService;

    Voyage vv1 = new Voyage(1L, 1L, Ville.tunis, Ville.SOUSSE, "2022-06-13", "22-12-2022", 15.45, 17.45);
    Voyage vv2 = new Voyage(2L, 2L, Ville.sfax, Ville.SAKIETEZZIT, "22/12/2022", "22-12-2022", 12.45, 13.15);
    List<Voyage> voyages = new ArrayList<Voyage>() {
        {
            add(new Voyage(3L, 3L, Ville.RADES, Ville.SAKIETEZZIT, "22/12/2022", "22-12-2022", 12.45, 15.45));
            add(new Voyage(4L, 4L, Ville.tunis, Ville.sfax, "22/12/2022", "22-12-2022", 12.45, 16.45));
        }
    };

    //@Before
    //public void init() {
    //    MockitoAnnotations.initMocks(this);
    //}
    @Test
    void ajouterVoyageTest() {

        Voyage voyage=new Voyage(5L, 5L, Ville.sfax, Ville.EZZAHRA, "22/12/2022", "22-12-2022", 13.25, 17.45);
        Mockito.when(voyageRepository.save(voyage)).thenReturn(voyage);
        assertEquals(voyage, voyageService.ajouterVoyage(voyage));

    }

    @Test
    void modifierVoyageTest() {

        Mockito.when(voyageRepository.save(vv2)).thenReturn(vv2);
        Voyage test = voyageService.modifierVoyage(vv2);
        Assertions.assertEquals(test, vv2);

    }

    @Test
    void affecterTrainAVoyageTest() {
    }

    @Test
    void recupererAllTest() {

        Mockito.when(voyageRepository.findAll()).thenReturn(voyages);
        List<Voyage> test = voyageService.recupererAll();
        Assertions.assertEquals(voyages, test);

    }

    @Test
    void recupererVoyageParIdTest() {
    }

    @Test
    void supprimerVoyageTest() {

        Mockito.doNothing().when(voyageRepository).deleteById(vv1.getIdVoyage());
        Mockito.when(voyageRepository.findById(vv1.getIdVoyage())).thenReturn(Optional.ofNullable(null));
        Voyage test = voyageService.supprimerVoyage(vv1.getIdVoyage());
        Assertions.assertNull(test);

    }
}