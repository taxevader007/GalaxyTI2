package model;

public class BlackHole{
    private String blackHoleName;
    private double blackHoleMass;
    private double blackHoleDistanceToEarth; 
    private Photo[] blackHolePhotos; 
    private boolean angularMoment;   
    private boolean charge;
    private String blackholeAssociatedGalaxy;

    public BlackHole(String blackHoleName, double blackHoleMass, double blackHoleDistanceToEarth, boolean angularMoment, boolean charge, String blackholeAssociatedGalaxy, Photo[] blackHolePhotos) {
        this.blackHoleName = blackHoleName;
        this.blackHoleMass = blackHoleMass;
        this.blackHoleDistanceToEarth = blackHoleDistanceToEarth;
        this.angularMoment = angularMoment;
        this.charge = charge;
        this.blackholeAssociatedGalaxy = blackholeAssociatedGalaxy;
        //5 per blackhole
    }
        public BlackHole(String blackHoleName, double blackHoleMass, double blackHoleDistanceToEarth, boolean angularMoment, boolean charge) {
        this.blackHoleName = blackHoleName;
        this.blackHoleMass = blackHoleMass;
        this.blackHoleDistanceToEarth = blackHoleDistanceToEarth;
        this.angularMoment = angularMoment;
        this.charge = charge;
   
        //5 per blackhole
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

    public Photo[] getBlackHolePhotos() {
        return blackHolePhotos;
    }

    public void setBlackHolePhotos(Photo[] blackHolePhotos) {
        this.blackHolePhotos = blackHolePhotos;
    }

    public boolean getAngularMoment() {
        return angularMoment;
    }

    public void setAngularMoment(boolean angularMoment) {
        this.angularMoment = angularMoment;
    }

    public boolean getCharge() {
        return charge;
    }

    public void setCharge(boolean charge) {
        this.charge = charge; 
    }

    public String getBlackholeAssociatedGalaxy() {
        return blackholeAssociatedGalaxy;
    }

    public void setBlackholeAssociatedGalaxy(String blackholeAssociatedGalaxy) {
        this.blackholeAssociatedGalaxy = blackholeAssociatedGalaxy;
    }

    
}