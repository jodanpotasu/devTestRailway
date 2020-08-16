package pl.innokrea.devtest.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface LinesStationsRepository extends CrudRepository<LineStation, Long> {

    @Query("select ls.train from LineStation ls " +
            "where ls.arrivalDate <= :startDateTime and ls.departureDate >= :startDateTime " +
            "and ls.currentStation.name = :startingStation " +
            "and ls.train.trainNumber in (select lst.train.trainNumber from LineStation lst where lst.currentStation.name = :finalStation)")
    List<Train> findTrains(String startingStation, String finalStation, LocalDateTime startDateTime);

    @Query(value = "select * from line_station ls " +
            "join train t on ls.train_number = t.train_number " +
            "where EXISTS(select 1 from line_station lst " +
                            "join station s on s.id = lst.current_station_id " +
                            "where lst.arrival_date <= :startDateTime " +
                            "and lst.departure_date >= :startDateTime " +
                            "and s.name = :startingStation " +
                            "and lst.train_number = t.train_number)" +
            "and exists(select 1 from line_station lst " +
                            "join station s on s.id = lst.current_station_id " +
                            "where s.name = :finalStation)" +
            "and ls.departure_date >= :startDateTime",
            nativeQuery = true)
    List<LineStation> findAllConnections(String startingStation, String finalStation, LocalDateTime startDateTime);

}
