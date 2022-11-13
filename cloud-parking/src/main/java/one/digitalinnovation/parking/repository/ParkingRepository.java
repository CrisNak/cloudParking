package one.digitalinnovation.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Parking;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, String>{

}
