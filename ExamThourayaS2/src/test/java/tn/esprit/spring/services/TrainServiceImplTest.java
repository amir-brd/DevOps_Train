package tn.esprit.spring.services;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Train;
import tn.esprit.spring.entities.Voyageur;
import tn.esprit.spring.entities.etatTrain;
import tn.esprit.spring.repository.TrainRepository;
import tn.esprit.spring.repository.VoyageurRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ExtendWith(MockitoExtension.class)
@Slf4j
class TrainServiceImplTest {
    @Mock
    TrainRepository trainRepository;
    @InjectMocks
    TrainServiceImpl trainService;

    Train t1 = new Train(4L, etatTrain.annule, 20);
    Train t2 = new Train(5L, etatTrain.en_gare, 10);
    List<Train> trains = new ArrayList<Train>() {
        {
            add(new Train(6L, etatTrain.en_route, 15));
            add(new Train(7L, etatTrain.prevu, 30));
        }
    };

    //@Before
    //public void init() {
    //    MockitoAnnotations.initMocks(this);
    //}

    @Test
    void ajouterTrainTest() {

        Train train=new Train(8L, etatTrain.prevu, 200);
        Mockito.when(trainRepository.save(train)).thenReturn(train);
        assertEquals(train, trainService.ajouterTrain(train));

    }

    @Test
    void trainPlacesLibresTest() {
    }

    @Test
    void listerTrainsIndirectsTest() {
    }

    @Test
    void affecterTainAVoyageurTest() {
    }

    @Test
    void desaffecterVoyageursTrainTest() {
    }

    @Test
    void trainsEnGareTest() {
    }
}