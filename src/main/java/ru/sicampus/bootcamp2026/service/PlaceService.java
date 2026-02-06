package ru.sicampus.bootcamp2026.service;


import ru.sicampus.bootcamp2026.dto.PlaceDTO;
import ru.sicampus.bootcamp2026.entity.Place;

import java.util.List;
import java.util.Optional;

public interface PlaceService {

    List<PlaceDTO> getAllPlaces();

    PlaceDTO getPlaceById(Long id);

    PlaceDTO createPlace(PlaceDTO place);

    PlaceDTO updatePlace(Long id,PlaceDTO place);

    void deletePlace(Long id);

    PlaceDTO findByName(PlaceDTO placeName);
}
