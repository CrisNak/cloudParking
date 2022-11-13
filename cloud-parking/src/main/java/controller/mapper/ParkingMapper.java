package controller.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import controller.DTO.ParkingCreateDTO;
import controller.DTO.ParkingDTO;
import model.Parking;


@Component
public class ParkingMapper {
	
	private static final ModelMapper MODEL_MAPPER = new ModelMapper();
	
	public ParkingDTO toparkingDTO( Parking parking) {
		return MODEL_MAPPER.map(parking, controller.DTO.ParkingDTO.class);
	}
	
	public List<ParkingDTO> toParkingDTOList(List<Parking> parkingList){
		return parkingList.stream().map(this::toparkingDTO).collect(Collectors.toList());
	}
	
	public Parking toParking(ParkingDTO dto) {
		return MODEL_MAPPER.map(dto,  Parking.class);
	}

	public Parking toparkingCreate(ParkingCreateDTO dto) {
		return MODEL_MAPPER.map(dto,  Parking.class);
	}

}
