package com.example.touristguidetwo.service;

import com.example.touristguidetwo.model.City;
import com.example.touristguidetwo.model.Tags;
import com.example.touristguidetwo.model.TouristAttraction;
import com.example.touristguidetwo.repository.TouristRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristService {

    private final TouristRepository touristRepository;

    public TouristService(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    public List<TouristAttraction> getAllTouristAttractions() {
        return touristRepository.getAllTouristAttractions();
    }

    public TouristAttraction findTouristAttractionByName(String name) {
        return touristRepository.findTouristAttractionByName(name);
    }

    public List<TouristAttraction> findTouristAttractionByNameAndTags(String name, Tags tags) {
        return touristRepository.findTouristAttractionByNameAndTags(name, tags);
    }

    public TouristAttraction addTouristAttraction(TouristAttraction touristAttraction) {
        return touristRepository.addTouristAttraction(touristAttraction);
    }

    public TouristAttraction deleteTouristAttraction(String name) {
        TouristAttraction touristAttraction = findTouristAttractionByName(name);
        if (touristAttraction != null) {
            return touristRepository.removeTouristAttraction(touristAttraction);
        }
        return null;
    }

    public TouristAttraction editTouristAttraction(String name, Tags tags) {
        TouristAttraction touristAttraction = findTouristAttractionByName(name);
        if (touristAttraction != null) {
            touristAttraction.setTags(tags);
            return touristRepository.updateTouristAttraction(touristAttraction);
        }
        return null;
    }

    public TouristAttraction updateTouristAttraction(TouristAttraction touristAttraction) {
        TouristAttraction existingAttraction = findTouristAttractionByName(touristAttraction.getName());
        if (existingAttraction != null) {
            existingAttraction.setCity(touristAttraction.getCity());
            existingAttraction.setDescription(touristAttraction.getDescription());
            existingAttraction.setTags(touristAttraction.getTags());
            return touristRepository.updateTouristAttraction(existingAttraction);
        }
        return null;
    }


    public List<City> getCities() {
        return touristRepository.getCities();
    }

    public List<Tags> getTags() {
        return touristRepository.getTags();
    }
}


