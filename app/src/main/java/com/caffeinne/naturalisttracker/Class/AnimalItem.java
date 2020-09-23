package com.caffeinne.naturalisttracker.Class;

public class AnimalItem {

    private String animalName;
    private String animalPrice;
    private String sampledStatus;
    private String sampledQuantity;

    public AnimalItem (String _animalName, String _animalPrice, String _sampledStatus, String _sampledQuantity){
        animalName = _animalName;
        animalPrice = _animalPrice;
        sampledStatus = _sampledStatus;
        sampledQuantity = _sampledQuantity;
    }

    public String getAnimalName() {
        return animalName;
    }

    public String getAnimalPrice() {
        return animalPrice;
    }

    public String getSampledStatus() {
        return sampledStatus;
    }

    public String getSampledQuantity() {
        return sampledQuantity;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public void setAnimalPrice(String animalPrice) {
        this.animalPrice = animalPrice;
    }

    public void setSampledStatus(String sampledStatus) {
        this.sampledStatus = sampledStatus;
    }

    public void setSampledQuantity(String sampledQuantity) {
        this.sampledQuantity = sampledQuantity;
    }
}
