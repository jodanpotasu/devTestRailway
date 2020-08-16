package pl.innokrea.devtest.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Station extends AbstractDomain {

    private String name;
}
