package com.example.touristguidetwo.repository;

import com.example.touristguidetwo.model.City;
import com.example.touristguidetwo.model.Tags;
import com.example.touristguidetwo.model.TouristAttraction;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
import org.w3c.dom.Attr;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {
    private static final List<TouristAttraction> touristAttractions = new ArrayList<>();

    private final JdbcTemplate jdbcTemplate;

    public TouristRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createTouristAttractions() {
    /*    touristAttractions.add(new TouristAttraction("Tivoli", "Forlystelsespark midt i KBH centrum", City.København, List.of(Tags.Familie, Tags.Udendørs, Tags.Koncert, Tags.Restaurant)));
        touristAttractions.add(new TouristAttraction("Eiffeltårnet", "Smukt tårn i Paris", City.Paris, List.of(Tags.Udendørs, Tags.Kærlighed, Tags.Europa)));
        touristAttractions.add(new TouristAttraction("Zoo", "Se masser af dyr i KBH", City.København, List.of(Tags.Udendørs, Tags.Familie, Tags.Dyr)));
        touristAttractions.add(new TouristAttraction("Colosseum", "Oplev det gamle Rom på nært hold", City.Rom, List.of(Tags.Udendørs, Tags.Familie, Tags.Europa)));
     */
    }

    public List<TouristAttraction> getAllTouristAttractions() {
        String sql = "SELECT * FROM TouristAttraction " +
                "JOIN City on TouristAttraction.cityID = City.CityID";
        return jdbcTemplate.query(sql, new AttractionRowMapper());
    }

    public TouristAttraction findTouristAttractionByName(String name) {
        String sql = "SELECT * FROM TouristAttraction " +
                "WHERE name = ?";
        List<TouristAttraction> attractions = jdbcTemplate.query(sql, new AttractionRowMapper(), name);
        if (attractions.isEmpty()){
            return null;
        } else {
            return attractions.get(0);
        }
    }

    public List<TouristAttraction> findTouristAttractionByNameAndTags(String name, Tags tags) {
        List<TouristAttraction> result = new ArrayList<>();

        for (TouristAttraction attraction : touristAttractions) {
            if (attraction.getName().equalsIgnoreCase(name) && attraction.getTags().getName().contains(tags.getName())) {
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


    public List<City> getCities() {
        String sql = "SELECT * FROM City";
        List<City> query = JdbcTemplate.query(sql, new CityRowmapper());
        return query;
    }

    public List<Tags> getTags() {
        String sql = "SELECT * FROM Tags";
        List<Tags> query = JdbcTemplate.query(sql, new CityRowmapper());
        return query;
    }


}


