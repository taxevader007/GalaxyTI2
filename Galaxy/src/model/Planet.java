package model;

public class Planet {
    private String planetName;
    private int planetNumberSatelites;
    //planetphotos
    private double planetRadio;
    private double planetMass;
    private String planetAssociatedGalaxy;   

    public Planet(String planetName, int planetNumberSatelites, double planetRadio, double planetMass, String planetAssociatedGalaxy) {
        this.planetName = planetName;
        this.planetNumberSatelites = planetNumberSatelites;
        this.planetRadio = planetRadio;
        this.planetMass = planetMass;
        this.planetAssociatedGalaxy = planetAssociatedGalaxy;
    }

    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public int getPlanetNumberSatelites() {
        return planetNumberSatelites;
    }

    public void setPlanetNumberSatelites(int planetNumberSatelites) {
        this.planetNumberSatelites = planetNumberSatelites;
    }

    public double getPlanetRadio() {
        return planetRadio;
    }

    public void setPlanetRadio(double planetRadio) {
        this.planetRadio = planetRadio;
    }

    public double getPlanetMass() {
        return planetMass;
    }

    public void setPlanetMass(double planetMass) {
        this.planetMass = planetMass;
    }

    public String getPlanetAssociatedGalaxy() {
        return planetAssociatedGalaxy;
    }

    public void setPlanetAssociatedGalaxy(String planetAssociatedGalaxy) {
        this.planetAssociatedGalaxy = planetAssociatedGalaxy;
    }



    
}
