package database;
import superhero.Superhero;

import java.util.ArrayList;
import java.util.Scanner;

public class Database {
    Superhero superhero;
    Scanner input = new Scanner(System.in);
    char yesOrNo;
    String name;
    boolean race;
    int year;
    int strength;
    String power;
    char superHeroNameYesOrNo;
    private ArrayList<Superhero> superheroDataBase = new ArrayList<>();

    public Database() {
    }

    public Superhero createSuperHero() {

        System.out.print("What is the name of your hero? ");
        name = input.nextLine();
        System.out.print("Is your hero a human? [y/n] ");
        yesOrNo = input.next().charAt(0);

        if (yesOrNo == 'y') {
            race = true;
        } else {
            race = false;
        }

        System.out.print("When did your hero get created? ");
        year = input.nextInt();

        System.out.print("What is the strength of your hero? Ex. 9000: ");
        strength = input.nextInt();
        input.nextLine();

        System.out.print("What kind of power/powers does your hero have? ");
        power = input.nextLine();

        System.out.print("Does your hero have a superhero-name? [y/n] ");
        superHeroNameYesOrNo = input.next().charAt(0);
        input.nextLine();

        if (superHeroNameYesOrNo == 'y' || superHeroNameYesOrNo == 'Y') {
            System.out.print("What is the superhero name? ");
            String superHeroName = input.nextLine();
            superhero = new Superhero(name, race, year, strength, power, superHeroName);
        } else {
            superhero = new Superhero(name, race, year, strength, power);
        }

        return superhero;
    }

    public void createSuperheroList() {
        superheroDataBase.add(createSuperHero());
    }

    public void displayHeroes() {
        if(superheroDataBase.isEmpty()){
            System.out.println("You must create a hero first in order to diplay it.");
        } else {
            System.out.println("Your heroes are: ");
            int count = 0;
            for (Superhero hero : superheroDataBase) {
                count++;
                System.out.println(count + " Name: " + hero.getName());
                System.out.println("  Super hero name: " + hero.getSuperHeroName());
                System.out.println("  Race: " + hero.getRace());
                System.out.println("  Strength level: " + hero.getStrength());
                System.out.println("  Year: " + hero.getYear());
                System.out.println("  Power: " + hero.getPower());
                System.out.println("---------------------------------------------");
            }
        }
    }

    public void searchForHero(int heroNameOrSuperheroName) {
        boolean isHeroFound = false;
        String searchForName = input.nextLine();
        if(heroNameOrSuperheroName == 1){
            for (Superhero hero : superheroDataBase) {
                if (hero.getName().contains(searchForName)) {
                    System.out.println("  Your hero was found! Here is an overview of " + hero.getName());
                    System.out.println("  Super hero name: " + hero.getSuperHeroName());
                    System.out.println("  Race: " + hero.getRace());
                    System.out.println("  Strength level: " + hero.getStrength());
                    System.out.println("  Year: " + hero.getYear());
                    System.out.println("  Power: " + hero.getPower());
                    isHeroFound = true;
                    break;
                }
            }
        } else if(heroNameOrSuperheroName == 2){
            for (Superhero hero : superheroDataBase) {
                if (hero.getSuperHeroName().contains(searchForName)) {
                    System.out.println("  Your hero was found! Here is an overview of the " + hero.getSuperHeroName() + " AKA " + hero.getName());
                    System.out.println("  Race: " + hero.getRace());
                    System.out.println("  Strength level: " + hero.getStrength());
                    System.out.println("  Year: " + hero.getYear());
                    System.out.println("  Power: " + hero.getPower());
                    isHeroFound = true;
                    break;
                }
            }
        }
        if(!isHeroFound){
            System.out.println("Your hero was not found. Please create the hero in order to view it.");
        }
    }

    public void editHero(){
        System.out.print("Which hero would you like to edit? (Search by normal name): ");
        String changeHero = input.nextLine();
        for (Superhero hero : superheroDataBase) {
            if (hero.getName().contains(changeHero)) {
                System.out.println("What would you like to change about " + hero.getName());
                System.out.println(1 + ". Name");
                System.out.println(2 + ". Superhero name");
                System.out.println(3 + ". Race");
                System.out.println(4 + ". Strength level");
                System.out.println(5 + ". Year");
                System.out.println(6 + ". Power");
                int answer = input.nextInt();
                input.nextLine();

                if(answer == 1){
                    System.out.print("Change your hero's name to: ");
                    String newName = input.nextLine();
                    hero.setName(newName);

                } else if(answer == 2){
                    System.out.print("Does your hero have a superhero name? [y/n] ");
                    char newSuperheroNameYesOrNo = input.next().charAt(0);
                    input.nextLine();

                    if(newSuperheroNameYesOrNo == 'y' ||newSuperheroNameYesOrNo == 'Y'){
                        System.out.print("Change your hero's superhero name to: ");
                        String newSuperHeroName = input.nextLine();
                        hero.setSuperHeroName(newSuperHeroName);
                    } else{
                        hero.setSuperHeroName(null);
                    }

                } else if(answer == 3){
                    System.out.print("Is your hero human? [y/n] ");
                    char yesOrNo = input.next().charAt(0);
                    if(yesOrNo == 'y' || yesOrNo == 'Y'){
                        race = true;
                        hero.setRace(race);
                    } else {
                        race = false;
                        hero.setRace(race);
                    }

                } else if(answer == 4){
                    System.out.print("Change your hero's strength level to: ");
                    int newStrengthLevel = input.nextInt();
                    hero.setStrength(newStrengthLevel);

                } else if(answer == 5){
                    System.out.print("Change your hero's creation year to: ");
                    int newYear = input.nextInt();
                    input.nextLine();
                    hero.setYear(newYear);

                } else if(answer == 6){
                    System.out.print("Change your hero's power to: ");
                    String newPower = input.nextLine();
                    hero.setPower(newPower);
                }
            }
        }

    }
}
