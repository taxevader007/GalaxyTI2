package model;

public class Galaxy {
    private String galaxyName;
    private double distanceToEarth;
    private String shape;
    //galaxyPhotos
    //galaxyBlackHoles
    //galaxyPlanets
    

    public Galaxy(String galaxyName, double distanceToEarth, String shape) {
        this.galaxyName = galaxyName;
        this.distanceToEarth = distanceToEarth;
        this.shape = shape;
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

    // Override toString method to provide a meaningful representation of the Galaxy
    @Override
    public String toString() {
        return "Galaxy Name: " + galaxyName +
                "\nDistance to Earth: " + distanceToEarth +
                "\nShape: " + shape;
    }
}// end of class
