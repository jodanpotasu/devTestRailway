package pl.innokrea.devtest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.innokrea.devtest.domain.*;
import pl.innokrea.devtest.dto.RailwayConnectionsRequest;
import pl.innokrea.devtest.service.RailwayConnectionsService;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class InnokreaApplication implements CommandLineRunner {

    private final RailwayConnectionsService railwayConnectionsService;
    private final StationRepository stationRepository;
    private final TrainRepository trainRepository;
    private final LinesStationsRepository linesStationsRepository;

    public InnokreaApplication(RailwayConnectionsService railwayConnectionsService, StationRepository stationRepository, TrainRepository trainRepository, LinesStationsRepository linesStationsRepository) {
        this.railwayConnectionsService = railwayConnectionsService;
        this.stationRepository = stationRepository;
        this.trainRepository = trainRepository;
        this.linesStationsRepository = linesStationsRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(InnokreaApplication.class, args);
    }

    @Override
    public void run(String... args) {
        populateBasicData();
//        runDemoScenario();
    }

    private void runDemoScenario() {
        LocalDateTime date = LocalDateTime.of(2020, 8, 15, 8, 0, 0, 0);
        RailwayConnectionsRequest request = new RailwayConnectionsRequest(date, "rumia", "gdansk");
        Map<Long, List<LineStation>> connections = railwayConnectionsService.getConnections(request);
        System.out.println(connections);
    }

    private void populateBasicData() {

        Station wejherowo = new Station();
        wejherowo.setName("wejherowo");
        Station reda = new Station();
        reda.setName("reda");
        Station rumia = new Station();
        rumia.setName("rumia");
        Station gdynia = new Station();
        gdynia.setName("gdynia");
        Station sopot = new Station();
        sopot.setName("sopot");
        Station gdansk = new Station();
        gdansk.setName("gdansk");
        stationRepository.saveAll(Arrays.asList(wejherowo, reda, rumia, gdynia, sopot, gdansk));

        Train train = new Train();
        train.setTrainNumber(0L);
        train.setName("pierwszy");
        train.setStartStation(rumia);
        train.setFinalStation(gdansk);

        Train train1 = new Train();
        train1.setTrainNumber(1L);
        train1.setName("drugi");
        train1.setStartStation(wejherowo);
        train1.setFinalStation(rumia);

        Train train2 = new Train();
        train2.setTrainNumber(2L);
        train2.setName("trzeci");
        train2.setStartStation(gdansk);
        train2.setFinalStation(sopot);

        Train train3 = new Train();
        train3.setTrainNumber(3L);
        train3.setName("czwarty");
        train3.setStartStation(gdansk);
        train3.setFinalStation(rumia);
        trainRepository.saveAll(Arrays.asList(train, train1, train2));

        //pierwszy
        LineStation lineStationStart = new LineStation();
        lineStationStart.setCurrentStation(rumia);
        lineStationStart.setTrain(train);
        lineStationStart.setArrivalDate(LocalDateTime.of(2020, 8, 15, 8, 0, 0, 0));
        lineStationStart.setDepartureDate(LocalDateTime.of(2020, 8, 15, 8, 5, 0, 0));

        LineStation lineStation1 = new LineStation();
        lineStation1.setCurrentStation(gdynia);
        lineStation1.setTrain(train);
        lineStation1.setArrivalDate(LocalDateTime.of(2020, 8, 15, 8, 30, 0, 0));
        lineStation1.setDepartureDate(LocalDateTime.of(2020, 8, 15, 8, 40, 0, 0));

        LineStation lineStation2 = new LineStation();
        lineStation2.setCurrentStation(sopot);
        lineStation2.setTrain(train);
        lineStation2.setArrivalDate(LocalDateTime.of(2020, 8, 15, 8, 50, 0, 0));
        lineStation2.setDepartureDate(LocalDateTime.of(2020, 8, 15, 8, 55, 0, 0));

        LineStation lineStation3 = new LineStation();
        lineStation3.setCurrentStation(gdansk);
        lineStation3.setTrain(train);
        lineStation3.setArrivalDate(LocalDateTime.of(2020, 8, 15, 10, 0, 0, 0));
        lineStation3.setDepartureDate(LocalDateTime.of(2020, 8, 15, 10, 5, 0, 0));

        //drugi
        LineStation linesStationsa2 = new LineStation();
        linesStationsa2.setCurrentStation(wejherowo);
        linesStationsa2.setTrain(train1);
        linesStationsa2.setArrivalDate(LocalDateTime.of(2020, 8, 15, 7, 0, 0, 0));
        linesStationsa2.setDepartureDate(LocalDateTime.of(2020, 8, 15, 7, 10, 0, 0));

        LineStation linesStationsa3 = new LineStation();
        linesStationsa3.setCurrentStation(reda);
        linesStationsa3.setTrain(train1);
        linesStationsa3.setArrivalDate(LocalDateTime.of(2020, 8, 15, 7, 30, 0, 0));
        linesStationsa3.setDepartureDate(LocalDateTime.of(2020, 8, 15, 7, 40, 0, 0));

        LineStation linesStationsa4 = new LineStation();
        linesStationsa4.setCurrentStation(rumia);
        linesStationsa4.setTrain(train1);
        linesStationsa4.setArrivalDate(LocalDateTime.of(2020, 8, 15, 8, 0, 0, 0));
        linesStationsa4.setDepartureDate(LocalDateTime.of(2020, 8, 15, 8, 5, 0, 0));

        //trzeci
        LineStation lineStationStartb = new LineStation();
        lineStationStartb.setCurrentStation(gdansk);
        lineStationStartb.setTrain(train2);
        lineStationStartb.setArrivalDate(LocalDateTime.of(2020, 8, 15, 14, 50, 0, 0));
        lineStationStartb.setDepartureDate(LocalDateTime.of(2020, 8, 15, 15, 0, 0, 0));

        LineStation linesStationsb1 = new LineStation();
        linesStationsb1.setCurrentStation(sopot);
        linesStationsb1.setTrain(train2);
        linesStationsb1.setArrivalDate(LocalDateTime.of(2020, 8, 15, 15, 15, 0, 0));
        linesStationsb1.setDepartureDate(LocalDateTime.of(2020, 8, 15, 15, 20, 0, 0));

        LineStation linesStationsb2 = new LineStation();
        linesStationsb2.setCurrentStation(gdynia);
        linesStationsb2.setTrain(train2);
        linesStationsb2.setArrivalDate(LocalDateTime.of(2020, 8, 15, 16, 20, 0, 0));
        linesStationsb2.setDepartureDate(LocalDateTime.of(2020, 8, 15, 16, 30, 0, 0));

        linesStationsRepository.saveAll(Arrays.asList(lineStation1, lineStationStart, lineStation2, lineStation3));
        linesStationsRepository.saveAll(Arrays.asList(linesStationsa2, linesStationsa3));
        linesStationsRepository.saveAll(Arrays.asList(linesStationsb2, linesStationsb1, lineStationStartb));
    }
}
