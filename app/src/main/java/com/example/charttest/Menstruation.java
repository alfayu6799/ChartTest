package com.example.charttest;

public class Menstruation {
    private String testDate;
    private double temperature;
    private int cycleStatus;

    public String getTestDate() {
        return testDate;
    }

    public void setTestDate(String testDate) {
        this.testDate = testDate;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getCycleStatus() {
        return cycleStatus;
    }

    public void setCycleStatus(int cycleStatus) {
        this.cycleStatus = cycleStatus;
    }
}
