package model;

public class Controller {

    // This is `the main controller of the program (obaject)
    private Galaxy[] galaxyMemory;
    private int galaxyCounter; // keeps track of the number of galaxies in the galaxyMemory array


    public Controller() {
        galaxyMemory = new Galaxy[50];
        galaxyCounter = 0; // inicializates galax counter in 0
    }

    public String registerGalaxy(String galaxyName, double distanceToEarth, String shape) {
        // Check if t,//Existshe galaxy already exists
        String messageResgiterGalaxy = "";

        for (int i = 0; i < galaxyCounter; i++) {
            if (galaxyMemory[i] != null && galaxyMemory[i].getGalaxyName().equals(galaxyName)) {
                messageResgiterGalaxy = "The galaxy already exists";
                
               
            }
        }

        if (galaxyCounter < galaxyMemory.length) {
            Galaxy newGalaxy = new Galaxy(galaxyName, distanceToEarth, shape);
            galaxyMemory[galaxyCounter] = newGalaxy;
            galaxyCounter++;
            
            messageResgiterGalaxy = "Galaxy added successfully";
        } else {
            messageResgiterGalaxy = "The galaxy memory is full";
        }

        return messageResgiterGalaxy;
    }

    // register blackhole
    public void registerBlackHole() {

    }

    // register planet
    public void registerPlanet() {

    }

    // remove planet
    public void rmPlanet() {

    }

    // edit planet
    public void editPlanet() {

    }

    // galaxy info
    public Galaxy infoGalaxy(String galaxyName) {
        for (int i = 0; i < galaxyMemory.length; i++) {
            if (galaxyMemory[i] != null && galaxyMemory[i].getGalaxyName().equals(galaxyName)) {
                return galaxyMemory[i]; // Galaxy found
            }
        }
        return null; // Galaxy not found
    }

    // planetinfo
    public void infoPlanet() {

    }

    // orderDistance
    public void orderDistance() {

    }

    // planetwithmoreDensity
    public void planetwithmoreDensity() {

    }

    // addPlanetPhoto
    public void addPlanetPhoto() {

    }

    // namesBlackholePhotos
    public void namesBlackholePhotos() {

    }

    // telescopeWithmorePhotos
    public void telescopeWithmorePhotos() {

    }

    // addBlackholePhoto
    public void addBlackholePhoto() {

    }

    // addGalaxyPhoto
    public void addGalaxyPhoto() {

    }

    // infoGalaxy
    public Galaxy[] getinfogalaxy() {
        Galaxy[] validGalaxies = new Galaxy[galaxyCounter];
        int index = 0;
        for (int i = 0; i < galaxyCounter; i++) {
            if (galaxyMemory[i] != null) {
                validGalaxies[index] = galaxyMemory[i];
                index++;
            }
        }
        return validGalaxies;
    }
    

    // remove galaxy

    public String rmGalaxy(String galaxyName) {
        String messageRMGalaxy = "";

        for (int i = 0; i < galaxyMemory.length; i++) {
            if (galaxyMemory[i] != null) {
                if (galaxyMemory[i].getGalaxyName().equals(galaxyName)) {
                    galaxyMemory[i] = null;
                    messageRMGalaxy = "Galaxy removed successfully";
                }
            }
            else{
                messageRMGalaxy = "The galaxy does not exist";
            }
        }
        return messageRMGalaxy;

    }

    //caculateDensity
    public void caculateDensity() {

    }

    //calculateVolume
    public void calculateVolume() {

    }
    

}
