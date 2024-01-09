package com.example.demo.Controllers;

import com.example.demo.model.DeviceSensorDetails;
import com.example.demo.model.UserCredentials;
import com.example.demo.repository.UserCredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/usercredentials")
public class UserController {

    // Autowire the JPA repository for UserCredentials
    @Autowired
    private UserCredentialsRepository userCredentialsRepository;

    // Define an endpoint to fetch all user credentials
    @GetMapping("/all")
    public List<UserCredentials> getAllUserCredentials() {
        List<UserCredentials> userDetails = userCredentialsRepository.getAllUserCredentials();
        return userDetails;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/login")
    public ResponseEntity<String> validateCredentails(@RequestBody UserCredentials inputCredentails) {
        String username = inputCredentails.getUsername();
        String password = inputCredentails.getPassword();

        List<UserCredentials> storedCredentialsList = userCredentialsRepository.getUserCredentialsByUsername(username);

        for(UserCredentials storedCrentaials : storedCredentialsList){
            if(storedCrentaials.getPassword().equals(password)){
                return ResponseEntity.ok("Credentails are valid");
            }
        }

        return ResponseEntity.badRequest().body("Invalid credentails");


    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/deviceDetails")
    public ResponseEntity<List<DeviceSensorDetails>> getLiveData() {
        List<Object[]> devicesData = userCredentialsRepository.getDeviceSensorDetails();
        List<DeviceSensorDetails> sensorDataList = new ArrayList<>();
        for (Object[] array : devicesData) {
            DeviceSensorDetails sensorData = new DeviceSensorDetails(
                    (String) array[0],
                    (String) array[1],
                    (String) array[2],
                    (int) array[3],
                    (String) array[4],
                    (double) array[5],
                    (double) array[6]
            );
            sensorDataList.add(sensorData);
        }
        return ResponseEntity.ok(sensorDataList);
    }


}

