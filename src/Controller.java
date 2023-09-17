import database.Database;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Controller {
    Database database;
    Scanner input;


    public Controller(Database database){
        this.database = database;
        input = new Scanner(System.in).useLocale(Locale.US);
    }

    public void run(){
        boolean createAnotherHeroIndicator = false;

        System.out.println("Welcome to the official superhero academy. Let's create your superhero!");
        boolean runAgain = true;

        do {
            if(createAnotherHeroIndicator){
                System.out.println("Would you like to create another hero?");
            }
            System.out.println(1 + ". Create a superhero!");
            System.out.println(2 + ". Display heroes!");
            System.out.println(3 + ". Search for a hero.");
            System.out.println(4 + ". Edit a hero.");
            System.out.println(9 + ". End the superhero creation.");

            try {
                int answer = input.nextInt();
                input.nextLine();
                if (answer == 1) {
                    database.createSuperheroList();
                    createAnotherHeroIndicator = true;
                } else if (answer == 2) {
                    database.displayHeroes();
                } else if (answer == 3) {
                    System.out.println("Would you like to search for: ");
                    System.out.println(1 + ". Hero's normal name?");
                    System.out.println(2 + ". Hero's super-hero name?");
                    int nameOrHeroName = input.nextInt();
                    System.out.print("What hero are you looking for? ");
                    database.searchForHero(nameOrHeroName);
                } else if (answer == 4) {
                    database.editHero();
                } else if (answer == 9) {
                    runAgain = false;
                } else {
                    System.out.println("The input is not corresponding to the choices shown above, please pick one of five options.");
                }
            } catch(InputMismatchException e){
                System.out.println("Invalid input. Please type a number corresponding to a valid option.");
                input.nextLine();
            }
        } while(runAgain);
    }
}
