package com.example.touristguidetwo.repository;

import com.example.touristguidetwo.model.City;
import com.example.touristguidetwo.model.Tags;
import com.example.touristguidetwo.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {
    private static final List<TouristAttraction> touristAttractions = new ArrayList<>();

    public TouristRepository() {
        createTouristAttractions();
    }

    public void createTouristAttractions() {
        touristAttractions.add(new TouristAttraction("Tivoli", "Forlystelsespark midt i KBH centrum", City.København, List.of(Tags.Familie, Tags.Udendørs, Tags.Koncert, Tags.Restaurant)));
        touristAttractions.add(new TouristAttraction("Eiffeltårnet", "Smukt tårn i Paris", City.Paris, List.of(Tags.Udendørs, Tags.Kærlighed, Tags.Europa)));
        touristAttractions.add(new TouristAttraction("Zoo", "Se masser af dyr i KBH", City.København, List.of(Tags.Udendørs, Tags.Familie, Tags.Dyr)));
        touristAttractions.add(new TouristAttraction("Colosseum", "Oplev det gamle Rom på nært hold", City.Rom, List.of(Tags.Udendørs, Tags.Familie, Tags.Europa)));
    }

    public List<TouristAttraction> getAllTouristAttractions() {
        return touristAttractions;
    }

    public TouristAttraction findTouristAttractionByName(String name) {
        for (TouristAttraction touristAttraction : touristAttractions) {
            if (touristAttraction.getName().equalsIgnoreCase(name)) {
                return touristAttraction;
            }
        }
        return null;
    }

    public List<TouristAttraction> findTouristAttractionByNameAndTags(String name, List<Tags> tags) {
        List<TouristAttraction> result = new ArrayList<>();

        for (TouristAttraction attraction : touristAttractions) {
            if (attraction.getName().equalsIgnoreCase(name) && attraction.getTags().containsAll(tags)) {
                result.add(attraction);
            }
        }

        return result;
    }

    public TouristAttraction addTouristAttraction(TouristAttraction touristAttraction) {
        touristAttractions.add(touristAttraction);
        return touristAttraction;
    }

    public TouristAttraction removeTouristAttraction(TouristAttraction touristAttraction) {
        touristAttractions.remove(touristAttraction);
        return touristAttraction;
    }

    public TouristAttraction updateTouristAttraction(TouristAttraction touristAttraction) {
        for (TouristAttraction existingAttraction : touristAttractions) {
            if (existingAttraction.getName().equalsIgnoreCase(touristAttraction.getName())) {
                existingAttraction.setCity(touristAttraction.getCity());
                existingAttraction.setDescription(touristAttraction.getDescription());
                existingAttraction.setTags(touristAttraction.getTags());
                return existingAttraction;
            }
        }
        return null;
    }


    public List<String> getCities() {
        List<String> cities = new ArrayList<>();
        for (City city : City.values()) {
            cities.add(city.name());
        }
        return cities;
    }

    public List<String> getTags() {
        List<String> tags = new ArrayList<>();
        for (Tags tag : Tags.values()) {
            tags.add(tag.name());
        }
        return tags;
    }
}


