package pl.innokrea.devtest.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class LineStation extends AbstractDomain {

    @ManyToOne
    @JoinColumn(name = "train_number")
    private Train train;

    @ManyToOne
    private Station currentStation;
    private LocalDateTime arrivalDate;
    private LocalDateTime departureDate;
}
