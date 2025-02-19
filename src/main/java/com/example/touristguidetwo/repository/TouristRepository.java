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
        touristAttractions.add(new TouristAttraction("Tivoli", "Forlystelsespark midt i KBH centrum", City.København, List.of(Tags.familie)));
        touristAttractions.add(new TouristAttraction("Eiffeltårnet", "Smukt tårn i Paris", City.Paris, List.of(Tags.udendørs)));
        touristAttractions.add(new TouristAttraction("Zoo", "Se masser af dyr i KBH", City.København, List.of(Tags.udendørs)));
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
        for (int i = 0; i < touristAttractions.size(); i++) {
            if (touristAttractions.get(i).getName().equalsIgnoreCase(touristAttraction.getName())) {
                touristAttractions.set(i, touristAttraction);
                return touristAttraction;
            }
        }
        return null;
    }
}


