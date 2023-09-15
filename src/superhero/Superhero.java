package superhero;

public class Superhero {
    private String name;
    private String superHeroName;
    private boolean race;
    private int year;
    private double strength;
    private String power;

    public Superhero(String name, boolean race, int year, double strength, String power){
        this.name = name;
        this.race = race;
        this.year = year;
        this.strength = strength;
        this.superHeroName = null;
        this.power = power;
    }
    public Superhero(String name, boolean race, int year, double strength, String power, String superHeroName){
        this.name = name;
        this.race = race;
        this.year = year;
        this.strength = strength;
        this.superHeroName = superHeroName;
        this.power = power;
    }


    public String getName(){
        return name;
    }
    public String getRace(){
        if(race){
            return "Human";
        } else {
            return "Not a human";
        }
    }
    public int getYear(){
        return year;
    }
    public double getStrength(){
        return strength;
    }
    public String getPower(){
        return power;
    }
    public String getSuperHeroName(){
        if(superHeroName == null){
            return "This hero does not have a superhero name.";
        } else {
            return superHeroName;
        }
    }
    public void setName(String newName){
        name = newName;
    }
    public void setRace(boolean race){
        this.race = race;
        getRace();
    }
    public void setYear(int year){
        this.year = year;
    }
    public void setStrength(int strength){
        this.strength = strength;
    }
    public void setSuperHeroName(String superHeroName){
        this.superHeroName = superHeroName;
    }
    public void setPower(String power){
        this.power = power;
    }
}
