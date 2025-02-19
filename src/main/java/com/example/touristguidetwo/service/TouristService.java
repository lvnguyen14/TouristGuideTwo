package com.example.touristguidetwo.service;

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

    public List<TouristAttraction> findTouristAttractionByNameAndTags(String name, List<Tags> tags) {
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

    public TouristAttraction editTouristAttraction(String name, List<Tags> tags) {
        TouristAttraction touristAttraction = findTouristAttractionByName(name);
        if (touristAttraction != null) {
            touristAttraction.setTags(tags);
            return touristRepository.updateTouristAttraction(touristAttraction);
        }
        return null;
    }

    public TouristAttraction updateTouristAttraction(TouristAttraction touristAttraction) {
        return touristRepository.updateTouristAttraction(touristAttraction);
    }
}


