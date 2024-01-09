package com.example.demo.repository;

import com.example.demo.model.UserCredentials;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Objects;

public interface UserCredentialsRepository extends CrudRepository<UserCredentials, Integer> {
    // You can add custom query methods if needed
    @Query("SELECT uc FROM UserCredentials uc")
    List<UserCredentials> getAllUserCredentials();

    @Query("SELECT uc FROM UserCredentials uc WHERE uc.username = :username")
    List<UserCredentials> getUserCredentialsByUsername(@Param("username") String username);

    @Query(nativeQuery = true,
            value = "SELECT d.name AS deviceName, s.name AS sensorName, s.type AS sensorType, sd.value AS sensorValue, s.unit, d.lat, d.lng " +
                    "FROM mapping m " +
                    "JOIN deviceTable d ON m.DeviceId = d.id " +
                    "JOIN sensor s ON m.SensorId = s.id " +
                    "LEFT JOIN sensordata sd ON s.id = sd.sensorId")
    List<Object[]> getDeviceSensorDetails();
}

