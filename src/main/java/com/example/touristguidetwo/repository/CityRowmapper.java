package com.example.touristguidetwo.repository;

import com.example.touristguidetwo.model.City;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CityRowmapper implements RowMapper<City> {
    @Override
    public City mapRow(ResultSet rs, int rowNum) throws SQLException{
        int id = rs.getInt("CityID");
        String name = rs.getString("cityName");
        return new City(name, id);
    }
}
