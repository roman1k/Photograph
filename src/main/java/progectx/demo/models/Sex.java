package progectx.demo.models;



import javax.persistence.Entity;

public enum Sex {
    Male("чоловік"), Female("жінка"), Anyone("Не важливо");

    private String name;

    Sex(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
