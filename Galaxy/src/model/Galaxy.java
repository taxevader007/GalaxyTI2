package model;

public class Galaxy {
    private String galaxyName;
    private double distanceToEarth;
    private String shape;
    private BlackHole[] galaxyBlackHoles;       
    private Planet[] galaxyPlanets;
    private Photo[] galaxyPhotos;
 

    public Galaxy(String galaxyName, double distanceToEarth, String shape) {
        this.galaxyName = galaxyName;
        this.distanceToEarth = distanceToEarth;
        this.shape = shape;
        galaxyBlackHoles = new BlackHole[50];
        galaxyPlanets = new Planet[50];
        
        if (galaxyPhotos != null) {
            this.galaxyPhotos = new Photo[30];

            for (int i = 0; i < galaxyPhotos.length; i++) {
                galaxyPhotos[i] = new Photo(shape, null);
            }
        }
    }

    // Getter and setter methods for galaxyName
    public String getGalaxyName() {
        return galaxyName;
    }

    public void setGalaxyName(String galaxyName) {
        this.galaxyName = galaxyName;
    }

    // Getter and setter methods for distanceToEarth
    public double getDistanceToEarth() {
        return distanceToEarth;
    }

    public void setDistanceToEarth(double distanceToEarth) {
        this.distanceToEarth = distanceToEarth;
    }

    // Getter and setter methods for shape
    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    // Getter and setter methods for galaxyBlackHoles
    public BlackHole[] getGalaxyBlackHoles() {
        return galaxyBlackHoles;
    }

    public void setGalaxyBlackHoles(BlackHole[] galaxyBlackHoles) {
        this.galaxyBlackHoles = galaxyBlackHoles;
    }

    // Getter and setter methods for galaxyPlanets
    public Planet[] getGalaxyPlanets() {
        return galaxyPlanets;
    }

    public void setGalaxyPlanets(Planet[] galaxyPlanets) {
        this.galaxyPlanets = galaxyPlanets;
    }

    public Photo[] getGalaxyPhotos() {
        return galaxyPhotos;
    }

    public void setGalaxyPhotos(Photo[] galaxyPhotos) {
        this.galaxyPhotos = galaxyPhotos;
    }

    // Override toString method to provide a meaningful representation of the Galaxy
    @Override
    public String toString() {
        return "Galaxy Name: " + galaxyName +
                "\nDistance to Earth: " + distanceToEarth +
                "\nShape: " + shape;
    }
}// end of class
