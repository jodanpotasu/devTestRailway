package pl.innokrea.devtest.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@ToString
public class Train extends AbstractDomain {

    private String name;
    private Long trainNumber;

    @ManyToOne
    private Station startStation;

    @ManyToOne
    private Station finalStation;
}
