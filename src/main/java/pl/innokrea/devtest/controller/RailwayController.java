package pl.innokrea.devtest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.innokrea.devtest.config.Routes;
import pl.innokrea.devtest.domain.LineStation;
import pl.innokrea.devtest.dto.RailwayConnectionsRequest;
import pl.innokrea.devtest.service.RailwayConnectionsService;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class RailwayController {

    private final RailwayConnectionsService railwayConnectionsService;

    @GetMapping(Routes.RAILWAY_CONNECTIONS)
    public Map<Long, List<LineStation>> getConnections(RailwayConnectionsRequest request) {
        return railwayConnectionsService.getConnections(request);
    }
}
