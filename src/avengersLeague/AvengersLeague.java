package avengersLeague;
import superhero.Superhero;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AvengersLeague {
    private Superhero[] superHeroList = new Superhero[3];
    private List<Superhero> superheroDataBase = new ArrayList<>();

    public AvengersLeague(){
    }

    public Superhero createSuperHero(){
        Superhero superhero;
        Scanner input = new Scanner(System.in);
        char yesOrNo;
        String name;
        boolean race;
        int year;
        int strength;
        String power;
        char superHeroNameYesOrNo;

        System.out.print("What is the name of your hero? ");
        name = input.nextLine();
        System.out.print("Is your hero a human? [y/n] ");
        yesOrNo = input.next().charAt(0);

        if(yesOrNo == 'y'){
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

        if(superHeroNameYesOrNo == 'y' || superHeroNameYesOrNo == 'Y'){
            System.out.print("What is the superhero name? ");
            String superHeroName = input.nextLine();
            superhero = new Superhero(name, race, year,strength, power, superHeroName);
        } else {
            superhero = new Superhero(name, race, year, strength, power);
        }

        return superhero;
    }

    public void createSuperheroList(int index){
        // superheroDataBase.add(createSuperHero());
        superHeroList[index] = createSuperHero();
    }

    public void displayHeroes(){
        System.out.println("Your heroes are: ");
        int count = 0;
        for(Superhero hero : superHeroList){
            count++;
            System.out.println(count);
            System.out.println("Name: " + hero.getName());
            System.out.println("Super hero name: " + hero.getSuperHeroName());
            System.out.println("Race: " + hero.getRace());
            System.out.println("Strength level: " + hero.getStrength());
            System.out.println("Year: " + hero.getYear());
            System.out.println("Power: " + hero.getPower());
            System.out.println("---------------------------------------------");

        }
    }
}
