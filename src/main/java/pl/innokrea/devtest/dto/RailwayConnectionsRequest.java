package pl.innokrea.devtest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class RailwayConnectionsRequest {

    private final LocalDateTime departureDate;
    private final String startingStation;
    private final String finalStation;
}
