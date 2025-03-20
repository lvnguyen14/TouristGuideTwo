package com.example.touristguidetwo.repository;

import com.example.touristguidetwo.model.City;
import com.example.touristguidetwo.model.Tags;
import com.example.touristguidetwo.model.TouristAttraction;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttractionRowMapper implements RowMapper<TouristAttraction> {
    @Override
    public TouristAttraction mapRow(ResultSet rs, int rowNum) throws SQLException{
        int id = rs.getInt("attractionID");
        String name = rs.getString("name");
        String description = rs.getString("description");

        City city = new City(rs.getString("cityName"), rs.getInt("cityID"));

        return new TouristAttraction(id, name, description, city, null);
    }
}
