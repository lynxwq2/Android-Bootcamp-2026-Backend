package ru.sicampus.bootcamp2026.util;


import lombok.experimental.UtilityClass;
import ru.sicampus.bootcamp2026.dto.PlaceDTO;
import ru.sicampus.bootcamp2026.entity.Place;

@UtilityClass
public class PlaceMapper {
    public PlaceDTO ConvertPlaceToDTO(Place place){
        PlaceDTO placeDTO = new PlaceDTO();
        placeDTO.setTime(place.getTime());
        placeDTO.setId(place.getId());
        placeDTO.setName(place.getName());
//        placeDTO.setEmployees(place.getEmployees());

        return placeDTO;
    }
}
