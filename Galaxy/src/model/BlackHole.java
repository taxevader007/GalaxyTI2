package model;

public class BlackHole{
    private String blackHoleName;
    private double blackHoleMass;
    private double blackHoleDistanceToEarth; 
    //atributo de la clase photo
    private double angularMoment;   
    private double charge;
    private String blackholeAssociatedGalaxy;

    public BlackHole(String blackHoleName, double blackHoleMass, double blackHoleDistanceToEarth, double angularMoment, double charge, String blackholeAssociatedGalaxy) {
        this.blackHoleName = blackHoleName;
        this.blackHoleMass = blackHoleMass;
        this.blackHoleDistanceToEarth = blackHoleDistanceToEarth;
        this.angularMoment = angularMoment;
        this.charge = charge;
        this.blackholeAssociatedGalaxy = blackholeAssociatedGalaxy;
    }
    
    public String getBlackHoleName() {
        return blackHoleName;
    }

    public void setBlackHoleName(String blackHoleName) {
        this.blackHoleName = blackHoleName;
    }

    public double getBlackHoleMass() {
        return blackHoleMass;
    }

    public void setBlackHoleMass(double blackHoleMass) {
        this.blackHoleMass = blackHoleMass;
    }

    public double getBlackHoleDistanceToEarth() {
            return blackHoleDistanceToEarth;
        }

    public void setBlackHoleDistanceToEarth(double blackHoleDistanceToEarth) {
        this.blackHoleDistanceToEarth = blackHoleDistanceToEarth;
    }

    public double getAngularMoment() {
        return angularMoment;
    }

    public void setAngularMoment(double angularMoment) {
        this.angularMoment = angularMoment;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge; 
    }

    public String getBlackholeAssociatedGalaxy() {
        return blackholeAssociatedGalaxy;
    }

    public void setBlackholeAssociatedGalaxy(String blackholeAssociatedGalaxy) {
        this.blackholeAssociatedGalaxy = blackholeAssociatedGalaxy;
    }

    
}