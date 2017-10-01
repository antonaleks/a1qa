package cars.entities;

public class Car {
    private String engine;
    private String transmission;

    public void setYear(String year) {
        this.year = year;
    }

    private String model;

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    private String make;
    private String year;

    public String getYear() {
        return year;
    }

    public String getModel() {
        return model;
    }

    public String getMake() {
        return make;
    }

    public Car(String make, String model, String year){
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String getEngine() {
        return engine;
    }

    public String getTransmission() {
        return transmission;
    }
}
