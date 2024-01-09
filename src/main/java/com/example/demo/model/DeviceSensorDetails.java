package com.example.demo.model;

public class DeviceSensorDetails {

    private String deviceName;
    private String sensorName;
    private String sensorType;
    private int sensorValue;
    private String unit;
    private double lat;
    private double lng;

    // Constructors, getters, and setters

    public DeviceSensorDetails() {
    }

    public DeviceSensorDetails(String deviceName, String sensorName, String sensorType, int sensorValue, String unit, double lat, double lng) {
        this.deviceName = deviceName;
        this.sensorName = sensorName;
        this.sensorType = sensorType;
        this.sensorValue = sensorValue;
        this.unit = unit;
        this.lat = lat;
        this.lng = lng;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public int getSensorValue() {
        return sensorValue;
    }

    public void setSensorValue(int sensorValue) {
        this.sensorValue = sensorValue;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}

