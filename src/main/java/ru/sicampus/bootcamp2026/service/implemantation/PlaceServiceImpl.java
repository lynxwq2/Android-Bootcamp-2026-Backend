package ru.sicampus.bootcamp2026.service.implemantation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sicampus.bootcamp2026.dto.PlaceDTO;
import ru.sicampus.bootcamp2026.entity.Place;
import ru.sicampus.bootcamp2026.exception.PlaceAllreadyEx;
import ru.sicampus.bootcamp2026.exception.PlaceNotFoundExc;
import ru.sicampus.bootcamp2026.repository.PlaceRepository;
import ru.sicampus.bootcamp2026.service.PlaceService;
import ru.sicampus.bootcamp2026.util.EmployeeMapper;
import ru.sicampus.bootcamp2026.util.PlaceMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlaceServiceImpl implements PlaceService {


    private final PlaceRepository placeRepository;

    @Override
    public List<PlaceDTO> getAllPlaces() {
        return placeRepository.findAll().stream().map(PlaceMapper::ConvertPlaceToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PlaceDTO getPlaceById(Long id) {
        return placeRepository.findById(id).map(PlaceMapper::ConvertPlaceToDTO).orElseThrow(() -> new PlaceNotFoundExc("Place isn't valid"));
    }

    @Override
    public PlaceDTO createPlace(PlaceDTO placeDTO) {
        Optional<Place> optionalPlace = placeRepository.findByName(placeDTO.getName());
        if (optionalPlace.isPresent())
            throw new PlaceAllreadyEx("Place already exists!!");

        Place place = new Place();
        place.setName(placeDTO.getName());
        place.setTime(placeDTO.getTime());
        return PlaceMapper.ConvertPlaceToDTO(placeRepository.save(place));
    }

    @Override
    public PlaceDTO updatePlace(Long id, PlaceDTO placeDTO) {
        Place place = placeRepository.findById(id)
                .orElseThrow(() -> new PlaceNotFoundExc("Place not found"));
        place.setName(placeDTO.getName());
        place.setTime(placeDTO.getTime());

        return PlaceMapper.ConvertPlaceToDTO(placeRepository.save(place));
    }


    @Override
    public void deletePlace(Long id) {
        placeRepository.deleteById(id);
    }

    @Override
    public PlaceDTO findByName(PlaceDTO placeDTO) {
        return null;
    }
}