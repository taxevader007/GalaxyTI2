package model;

import java.util.Calendar;

public class Controller {

    // This is `the main controller of the program (obaject)
    private Galaxy[] galaxyMemory;
    private BlackHole[] blackholeMemory;
    private int galaxyCounter; // keeps track of the number of galaxies in the galaxyMemory array


    public Controller() {
        galaxyMemory = new Galaxy[50];
        blackholeMemory = new BlackHole[50];
        galaxyCounter = 0; // inicializates galax counter in 0
    }

    public String registerGalaxy(String galaxyName, double distanceToEarth, String shape) {
        
       
        Shape galaxyShape = Shape.valueOf(shape.toUpperCase());
            // rest of the method
        String messageResgiterGalaxy = "";

        for (int i = 0; i < galaxyCounter; i++) {
            if (galaxyMemory[i] != null && galaxyMemory[i].getGalaxyName().equals(galaxyName)) {
                messageResgiterGalaxy = "The galaxy already exists";
                
               
            }
        }

        if (galaxyCounter < galaxyMemory.length) {
            Galaxy newGalaxy = new Galaxy(galaxyName, distanceToEarth, shape );
            galaxyMemory[galaxyCounter] = newGalaxy;
            galaxyCounter++;
            
            messageResgiterGalaxy = "Galaxy added successfully";
        } else {
            messageResgiterGalaxy = "The galaxy memory is full";
        }

        return messageResgiterGalaxy;
    }
   

    public String registerBlackHole(String blackholeName, double mass, double density, double size, String galaxyName, boolean charge, boolean rotation) {

        String messageRegisterBlackHole = "";
        //related a galaxy with a blackhole

        // Check the charge to set the type of black hole
        // me base del codigo de thomas en esta parte para hacer el enum
        BlackholeNameType form = null;
        if (charge == false && rotation == false) {
            form = BlackholeNameType.SCHWARZSCHILD;
        } else if (charge == true && rotation == false) {
            form = BlackholeNameType.REISSNER_NORDSTROM;
        } else if (charge == false && rotation == true) {
            form = BlackholeNameType.KERR;
        } else if (charge == true && rotation == true) {
            form = BlackholeNameType.KERR_NEWMAN;
        }

        for (int i = 0; i < galaxyCounter; i++) {
            if (galaxyMemory[i] != null && galaxyMemory[i].getGalaxyName().equals(galaxyName)) {

                for (int j = 0; j < blackholeMemory.length; j++) {
                    if (blackholeMemory[j] != null && blackholeMemory[j].getBlackHoleName().equals(blackholeName)) {
                        return messageRegisterBlackHole = "The black hole already exists";
                    }
                }
                
                // Check if the black hole memory is full
                for (int j = 0; j < blackholeMemory.length; j++) {
                    if (blackholeMemory[j] == null) {
                        // There is space in the black hole memory
                        BlackHole newBlackHole = new BlackHole(blackholeName, mass, i,false, false, blackholeName, null);
                        blackholeMemory[j] = newBlackHole;
                        return messageRegisterBlackHole = "Black hole added successfully";
                    }
                }
                
                return messageRegisterBlackHole = "The black hole memory is full";
            }


        }
        return messageRegisterBlackHole = "The galaxy does not exist";

    }

    // register planet
    public String registerPlanet(String planetName, int numberOfSatellites, double planetRadius, double planetMass, String galaxyName) {
        String messageRegisterPlanet = "";
    
        // Check if the associated galaxy exists
        boolean galaxyExists = false;
        for (int i = 0; i < galaxyCounter; i++) {
            if (galaxyMemory[i] != null && galaxyMemory[i].getGalaxyName().equals(galaxyName)) {

                galaxyExists = true;
                break;
            }
        }
    
        if (!galaxyExists) {
            return "The associated galaxy does not exist.";
        }
    
        // Check if there is space in the planet memory
        for (int i = 0; i < galaxyCounter; i++) {
            if (galaxyMemory[i] != null && galaxyMemory[i].getGalaxyName().equals(galaxyName)) {
                Galaxy associatedGalaxy = galaxyMemory[i];
    
                // Check if the planet memory within the galaxy is full
                for (int j = 0; j < associatedGalaxy.getGalaxyPlanets().length; j++) {
                    if (associatedGalaxy.getGalaxyPlanets()[j] == null) {
                        // There is space in the planet memory
                        Planet newPlanet = new Planet(planetName, numberOfSatellites, planetRadius, planetMass, galaxyName, null);
                        associatedGalaxy.getGalaxyPlanets()[j] = newPlanet;
                        return "Planet added successfully.";
                    }
                }
    
                return "The planet memory in the associated galaxy is full.";
            }
        }
    
        return "The associated galaxy was not found.";
    }

    // remove planet
    public void rmPlanet( String galaxyName, String planetName) {
        for (int i = 0; i < galaxyCounter; i++) {
            if (galaxyMemory[i] != null && galaxyMemory[i].getGalaxyName().equals(galaxyName)) {
                Galaxy associatedGalaxy = galaxyMemory[i];
    
                for (int j = 0; j < associatedGalaxy.getGalaxyPlanets().length; j++) {
                    if (associatedGalaxy.getGalaxyPlanets()[j] != null && associatedGalaxy.getGalaxyPlanets()[j].getPlanetName().equals(planetName)) {
                        associatedGalaxy.getGalaxyPlanets()[j] = null;
                        break;
                    }
                }
            }
        }
    }

    // edit planet
    public void editPlanet(String galaxyName, String planetName, String newPlanetName, int newNumberOfSatellites, double newPlanetRadius, double newPlanetMass) {
        for (int i = 0; i < galaxyCounter; i++) {
            if (galaxyMemory[i] != null && galaxyMemory[i].getGalaxyName().equals(galaxyName)) {
                Galaxy associatedGalaxy = galaxyMemory[i];
    
                for (int j = 0; j < associatedGalaxy.getGalaxyPlanets().length; j++) {
                    if (associatedGalaxy.getGalaxyPlanets()[j] != null && associatedGalaxy.getGalaxyPlanets()[j].getPlanetName().equals(planetName)) {
                        associatedGalaxy.getGalaxyPlanets()[j].setPlanetName(newPlanetName);
                        associatedGalaxy.getGalaxyPlanets()[j].setPlanetNumberSatelites(newNumberOfSatellites);
                        associatedGalaxy.getGalaxyPlanets()[j].setPlanetRadio(newPlanetRadius);
                        associatedGalaxy.getGalaxyPlanets()[j].setPlanetMass(newPlanetMass);
                        break;
                    }
                }
            }
        }
    }

    // register planet photo

    public String registerPlanetPhoto(String galaxyName, String planetName, String telescope, Calendar photoDate) {
        String messageRegisterPlanetPhoto = "";
    
        // Check if the associated galaxy exists
        boolean galaxyExists = false;
        for (int i = 0; i < galaxyCounter; i++) {
            if (galaxyMemory[i] != null && galaxyMemory[i].getGalaxyName().equals(galaxyName)) {
                galaxyExists = true;
                break;
            }
        }
    
        if (!galaxyExists) {
            return "The associated galaxy does not exist.";
        }
    
        // Check if the associated planet exists
        boolean planetExists = false;
        for (int i = 0; i < galaxyCounter; i++) {
            if (galaxyMemory[i] != null && galaxyMemory[i].getGalaxyName().equals(galaxyName)) {
                Galaxy associatedGalaxy = galaxyMemory[i];
    
                for (int j = 0; j < associatedGalaxy.getGalaxyPlanets().length; j++) {
                    if (associatedGalaxy.getGalaxyPlanets()[j] != null && associatedGalaxy.getGalaxyPlanets()[j].getPlanetName().equals(planetName)) {
                        planetExists = true;
                        break;
                    }
                }
    
                break;
            }
        }
    
        if (!planetExists) {
            return "The associated planet does not exist.";
        }
    
        // Check if there is space in the planet photo memory
        for (int i = 0; i < galaxyCounter; i++) {
            if (galaxyMemory[i] != null && galaxyMemory[i].getGalaxyName().equals(galaxyName)) {
                Galaxy associatedGalaxy = galaxyMemory[i];
    
                for (int j = 0; j < associatedGalaxy.getGalaxyPlanets().length; j++) {
                    if (associatedGalaxy.getGalaxyPlanets()[j] != null && associatedGalaxy.getGalaxyPlanets()[j].getPlanetName().equals(planetName)) {
                        Planet associatedPlanet = associatedGalaxy.getGalaxyPlanets()[j];
    
                        // Check if the planet photo memory within the planet is full
                        for (int k = 0; k < associatedPlanet.getPlanetphotos().length; k++) {
                            if (associatedPlanet.getPlanetphotos()[k] == null) {
                                // There is space in the planet photo memory
                                Photo newPhoto = new Photo(telescope, photoDate);
                                associatedPlanet.getPlanetphotos()[k] = newPhoto;
                                return "Planet photo added successfully.";
                            }
                        }
                    }
                }
            }
        }
        return messageRegisterPlanetPhoto;
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
    
    public String rmGalaxy(String galaxyName) {
        String messageRMGalaxy = "";

        for (int i = 0; i < galaxyMemory.length; i++) {
            if (galaxyMemory[i] != null) {
                if (galaxyMemory[i].getGalaxyName().equalsIgnoreCase(galaxyName)) {
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
