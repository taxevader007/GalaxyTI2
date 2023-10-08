package model;


public enum Shape{
    ELLIPTICAL, SPIRAL, LENTICULAR, IRREGULAR;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}

