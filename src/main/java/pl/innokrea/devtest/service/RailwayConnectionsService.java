package pl.innokrea.devtest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.innokrea.devtest.domain.LineStation;
import pl.innokrea.devtest.domain.LinesStationsRepository;
import pl.innokrea.devtest.domain.Train;
import pl.innokrea.devtest.dto.RailwayConnectionsRequest;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RailwayConnectionsService {

    private final LinesStationsRepository linesStationsRepository;

    public Map<Long, List<LineStation>> getConnections(RailwayConnectionsRequest request) { //returned value may be some dto
        return linesStationsRepository.findAllConnections(request.getStartingStation(),request.getFinalStation(), request.getDepartureDate()).stream()
                .sorted(Comparator.comparing(LineStation::getArrivalDate))
                .collect(Collectors.groupingBy(x -> x.getTrain().getTrainNumber(), Collectors.toList()));
    }

    public List<Train> getAvailableTrains(RailwayConnectionsRequest request) { //for testing purposes
        return linesStationsRepository.findTrains(request.getStartingStation(),request.getFinalStation(), request.getDepartureDate());
    }
}
