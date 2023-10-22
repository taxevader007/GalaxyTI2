package model;

import java.util.Calendar;

public class Controller {

    private Galaxy[] galaxyMemory;
 		
    private BlackHole[] blackholeMemory;

    private int galaxyCounter; 


    public Controller() {
        galaxyMemory = new Galaxy[50];
        blackholeMemory = new BlackHole[50];
        galaxyCounter = 0; // inicializates galax counter in 0
    }

    
    public void testcases(){
        
        Galaxy galaxy1 = new Galaxy("Lechosa",4000000, "ELLIPTICAL");
        Galaxy galaxy2 = new Galaxy("Andromeda",4000000, "ELLIPTICAL");
        Galaxy galaxy3 = new Galaxy("Sombrero",4000000, "ELLIPTICAL");
        galaxyMemory[0] = galaxy1;

        Planet planet1 = new Planet("Planet1", 1, 1, 1, "Lechosa", null, 1);
        Planet planet2 = new Planet("Planet2", 1, 1, 1, "Lechosa", null, 1);
        Planet planet3 = new Planet("Planet3", 1, 1, 1, "Lechosa", null, 1);

    }
/* 
    public static boolean testcases (){
        new Galaxy("Lechosa",4000000, "ELLIPTICAL");

        return true;
    }

 */
     public String registerGalaxy(String galaxyName, double distanceToEarth, String shape) {
        
       
        Shape galaxyShape = Shape.valueOf(shape.toUpperCase());

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




    public String add(String galaxyName, double distanceToEarth, String shape){
        String msg = "";

        if (galaxyCounter < galaxyMemory.length) {
            if(freeName(galaxyName)){
                Galaxy newGalaxy = new Galaxy(galaxyName, distanceToEarth, shape );
                galaxyMemory[galaxyCounter] = newGalaxy;
                galaxyCounter++;
            
                msg = "Galaxy added successfully";
            }else{
                msg = "The galaxy already exists";
            }
    
        } 
        else {
            msg = "The galaxy memory is full";
        }

        return msg;
        
    }

    public boolean freeName(String name){
        boolean freeName = true;
        for (int i = 0; i < galaxyCounter; i++) {
            if (galaxyMemory[i].getGalaxyName().equals(name)) {
                freeName = false;
            }
        }
        return freeName;

    }

    public int getGalaxyIndexByName(String name){
        int index = -1;
        
        for(int i = 0; i < galaxyCounter ;i++){
            if(galaxyMemory[index].getGalaxyName().equalsIgnoreCase(name)){
                index = i;
            }

        }

        return index;
    }
    public String addBlackHole(String blackholeName, double mass, double density, double size, String galaxyName, boolean charge, boolean rotation){
        int index = getGalaxyIndexByName(galaxyName);
        String msg = "NOP";
        if(index!= -1){
            msg = galaxyMemory[index].addBlackHole(blackholeName, mass, density, size, charge, rotation);
        }

        return msg;

    }
   

    public String registerBlackHole(String blackholeName, double mass, double density, double size, String galaxyName, boolean charge, boolean rotation) {

        String messageRegisterBlackHole = "";
        //related a galaxy with a blackhole

        for (int i = 0; i < galaxyCounter; i++) {
            if (galaxyMemory[i] != null && galaxyMemory[i].getGalaxyName().equals(galaxyName)) {

                for (int j = 0; j < blackholeMemory.length; j++) {
                    if (blackholeMemory[j] != null && blackholeMemory[j].getBlackHoleName().equals(blackholeName)) {
                        return messageRegisterBlackHole = "The black hole already exists";
                    }
                }
                
                
                for (int j = 0; j < blackholeMemory.length; j++) {
                    if (blackholeMemory[j] == null) {

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
                        
                        BlackHole newBlackHole = new BlackHole(blackholeName, mass, i,false, false, blackholeName, null );
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
        double planetVolume = 0.0;
        double planetDensity = 0.0;
    
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

                        planetVolume = (4/3) * Math.PI * Math.pow(planetRadius, 3);
                        planetDensity = planetMass / planetVolume;
                        // There is space in the planet memory
                        Planet newPlanet = new Planet(planetName, numberOfSatellites, planetRadius, planetMass, galaxyName, null, planetDensity);
                        associatedGalaxy.getGalaxyPlanets()[j] = newPlanet;
                        return "Planet added successfully." + planetDensity;

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

    public String registerPlanetPhoto(String galaxyName, String planetName, String photoURL, String telescope, Calendar photoDate) {
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

    public String registeBlackHolePhoto (String galaxyName, String planetName, String telescope, Calendar photoDate) {
        String messageRegisterBlackHolePhoto = "";

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

        
        boolean blackHoleExists = false;
        for (int i = 0; i < blackholeMemory.length; i++) {
            if (blackholeMemory[i] != null && blackholeMemory[i].getBlackHoleName().equals(planetName)) {
                blackHoleExists = true;
                break;
            }
        }

        if (!blackHoleExists) {
            return "The associated black hole does not exist.";
        }

        // Check if there is space in the black hole photo memory

        for (int i = 0; i < blackholeMemory.length; i++) {
            if (blackholeMemory[i] != null && blackholeMemory[i].getBlackHoleName().equals(planetName)) {
                BlackHole associatedBlackHole = blackholeMemory[i];

                // Check if the black hole photo memory within the black hole is full
                for (int j = 0; j < associatedBlackHole.getBlackHolePhotos().length; j++) {
                    if (associatedBlackHole.getBlackHolePhotos()[j] == null) {
                        // There is space in the black hole photo memory
                        Photo newPhoto = new Photo(telescope, photoDate);
                        associatedBlackHole.getBlackHolePhotos()[j] = newPhoto;
                        return "Black hole photo added successfully.";
                    }
                }
            }
        }
                      

        return messageRegisterBlackHolePhoto;
    
    }

    // register galaxy photo

    public String registerGalaxyPhoto(String galaxyName, String photoURL, String telescope, Calendar photoDate) {
        String messageRegisterGalaxyPhoto = "";
    
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
    
        // Check if there is space in the galaxy photo memory
        for (int i = 0; i < galaxyCounter; i++) {
            if (galaxyMemory[i] != null && galaxyMemory[i].getGalaxyName().equals(galaxyName)) {
                Galaxy associatedGalaxy = galaxyMemory[i];
    
                // Check if the galaxy photo memory within the galaxy is full
                for (int j = 0; j < associatedGalaxy.getGalaxyPhotos().length; j++) {
                    if (associatedGalaxy.getGalaxyPhotos()[j] == null) {
                        // There is space in the galaxy photo memory
                        Photo newPhoto = new Photo(telescope, photoDate);
                        associatedGalaxy.getGalaxyPhotos()[j] = newPhoto;
                        return "Galaxy photo added successfully.";
                    }
                }
            }
        }
    
        return messageRegisterGalaxyPhoto;
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

    public String[] getGalaxyInfo() {
        // Retrieve all galaxies from the Controller
        Galaxy[] galaxies = getinfogalaxy();
        String[] galaxyInfo = new String[galaxies.length];
        
    
        if (galaxies.length == 0) {
            galaxyInfo[0] = "No galaxies found.";
        } else {
            // Sort the galaxies array based on distance to Earth (from nearest to farthest)
            for (int i = 0; i < galaxies.length - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < galaxies.length; j++) {
                    if (galaxies[j] != null &&
                            galaxies[i] != null &&
                            galaxies[j].getDistanceToEarth() < galaxies[i].getDistanceToEarth()) {
                        minIndex = j;
                    }
                }

            }
    
            galaxyInfo[0] = "Galaxies sorted by distance to Earth (from nearest to farthest):";
            for (int i = 0; i < galaxies.length; i++) {
                galaxyInfo[i+1] = "Galaxy " + (i + 1);
                if (galaxies[i] != null) {
                    galaxyInfo[i+1] += "\nGalaxy Name: " + galaxies[i].getGalaxyName();
                    galaxyInfo[i+1] += "\nDistance to Earth: " + galaxies[i].getDistanceToEarth();
                } else {
                    galaxyInfo[i+1] += "\nThis galaxy has been removed.";
                }
            }
        }
        
        return galaxyInfo;
    }

    // planet info
    public Planet infoPlanet(String galaxyName, String planetName) {
        for (int i = 0; i < galaxyMemory.length; i++) {
            if (galaxyMemory[i] != null && galaxyMemory[i].getGalaxyName().equals(galaxyName)) {
                Galaxy associatedGalaxy = galaxyMemory[i];
    
                for (int j = 0; j < associatedGalaxy.getGalaxyPlanets().length; j++) {
                    if (associatedGalaxy.getGalaxyPlanets()[j] != null && associatedGalaxy.getGalaxyPlanets()[j].getPlanetName().equals(planetName)) {
                        return associatedGalaxy.getGalaxyPlanets()[j]; // Planet found
                    }
                }
            }
        }
        return null; // Planet not found
    }

    // orderDistance galaxia mas alejada al planeta tierra
    public String orderDistance() {
        String messageDistantGalaxy = "";
        Double distantGalaxy = 0.0; 


        for (int i = 0; i < galaxyCounter; i++) {
            if (galaxyMemory[i] != null) {
                if (galaxyMemory[i].getDistanceToEarth() > distantGalaxy) {

                    messageDistantGalaxy = "The galaxy is the most distant to planet earth is :" + galaxyMemory[i].getGalaxyName();
                }
            }
        }     
        
        return messageDistantGalaxy;

    }

    // planetwithmoreDensity
    public String planetwithmoreDensity() {
        String mssgPlanetMostDensity = "";
        double planetMostDensity = 0.0;
    
        for (int i = 0; i < galaxyCounter; i++) {
            if (galaxyMemory[i] != null) {
                for (int j = 0; j < galaxyMemory[i].getGalaxyPlanets().length; j++) {
                    if (galaxyMemory[i].getGalaxyPlanets()[j] != null) {
                        if (galaxyMemory[i].getGalaxyPlanets()[j].getPlanetDensity() > planetMostDensity) {
                            mssgPlanetMostDensity = "The planet with more density is: " + galaxyMemory[i].getGalaxyPlanets()[j].getPlanetName() + " \n from galaxy : \n" + galaxyMemory[i].getGalaxyName();
                        }
                    }
                }
            }
        }
        return mssgPlanetMostDensity;
    }

    public String namesBlackholeGalaxy() {
    String messageNamesBlackholeGalaxy = "";

    for (int i = 0; i < galaxyCounter; i++) {
        if (galaxyMemory[i] != null) {
            for (int j = 0; j < blackholeMemory.length; j++) {
                if (blackholeMemory[j] != null) {
                    if (blackholeMemory[j].getBlackholeAssociatedGalaxy().equals(galaxyMemory[i].getGalaxyName())) {
                        messageNamesBlackholeGalaxy += "The black hole " + blackholeMemory[j].getBlackHoleName() + " is from the galaxy " + galaxyMemory[i].getGalaxyName() + "\n";
                    }
                }
            }
        }
    }
    

    return messageNamesBlackholeGalaxy;
}
    

    // telescope With more Photos
    
    public String telescopeWithmorePhotos(String telescope){

        int telescopeCounter = 0;
      
        for (int i = 0; i < galaxyCounter; i++) {
            
            if (galaxyMemory[i] != null) {
                for (int j = 0; j < galaxyMemory[i].getGalaxyPhotos().length; j++) {
                    if (galaxyMemory[i].getGalaxyPhotos()[j] != null) {
                        if (galaxyMemory[i].getGalaxyPhotos()[j].getTelescope().equals(telescope)) {
                            telescopeCounter++;
                        }
                    }
                }

                for (int j = 0; j < galaxyMemory[i].getGalaxyPlanets().length; j++) {
                    if (galaxyMemory[i].getGalaxyPlanets()[j] != null) {
                        for (int k = 0; k < galaxyMemory[i].getGalaxyPlanets()[j].getPlanetphotos().length; k++) {
                            if (galaxyMemory[i].getGalaxyPlanets()[j].getPlanetphotos()[k] != null) {
                                if (galaxyMemory[i].getGalaxyPlanets()[j].getPlanetphotos()[k].getTelescope().equals(telescope)) {
                                    telescopeCounter++;
                                }
                            }
                        }
                    }
                }

                // for blackhole
                for (int j = 0; j < blackholeMemory.length; j++) {
                    if (blackholeMemory[j] != null) {
                        for (int k = 0; k < blackholeMemory[j].getBlackHolePhotos().length; k++) {
                            if (blackholeMemory[j].getBlackHolePhotos()[k] != null) {
                                if (blackholeMemory[j].getBlackHolePhotos()[k].getTelescope().equals(telescope)) {
                                    telescopeCounter++;
                                }
                            }
                        }
                    }
                }
            }
        }

        return "The telescope " + telescope + " has " + telescopeCounter + " photos.";

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




}
