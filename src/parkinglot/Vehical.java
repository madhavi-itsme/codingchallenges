package parkinglot;

public class Vehical {
    String licensePlate;

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    String color;

    public Vehical(String licensePlate, String color) {
        this.licensePlate=licensePlate;
        this.color=color;
    }

}
