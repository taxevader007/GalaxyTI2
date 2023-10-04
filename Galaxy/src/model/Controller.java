package model;

public class Controller {

    // This is `the main controller of the program (obaject)
    private Galaxy[] galaxyMemory;
    private int galaxyCounter; // keeps track of the number of galaxies in the galaxyMemory array

    public Controller() {
        galaxyMemory = new Galaxy[50];
        galaxyCounter = 0; // inicializates galax counter in 0
    }

    public void registerGalaxy(String galaxyName, double distanceToEarth, String shape) {
        // Check if the galaxy already exists
        for (int i = 0; i < galaxyCounter; i++) {
            if (galaxyMemory[i] != null && galaxyMemory[i].getGalaxyName().equals(galaxyName)) {
                System.out.println("The galaxy already exists");
                return;
            }
        }

        if (galaxyCounter < galaxyMemory.length) {
            Galaxy newGalaxy = new Galaxy(galaxyName, distanceToEarth, shape);
            galaxyMemory[galaxyCounter] = newGalaxy;
            galaxyCounter++;
            System.out.println("Galaxy added successfully");
        } else {
            System.out.println("The galaxy memory is full");
        }
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

    public boolean rmGalaxy(String galaxyName) {
        for (int i = 0; i < galaxyMemory.length; i++) {
            if (galaxyMemory[i] != null) {
                if (galaxyMemory[i].getGalaxyName().equals(galaxyName)) {
                    galaxyMemory[i] = null;
                    return true; // Galaxy removed successfully
                }
            }
        }
        System.out.println("The galaxy does not exist");
        return false; // Galaxy not found

    }

    //caculateDensity
    public void caculateDensity() {

    }

    //calculateVolume
    public void calculateVolume() {

    }
    

}
