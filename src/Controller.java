import database.Database;

import java.util.Locale;
import java.util.Scanner;

public class Controller {
    Database database;
    // String searchForHero;

    public Controller(Database database){
        this.database = database;
    }

    public void run(){
        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        int createAnotherHeroIndicator = 0;

        System.out.println("Welcome to the official superhero academy. Let's create your superhero!");
        boolean runAgain = true;

        do {
            if(createAnotherHeroIndicator == 1){
                System.out.println("Would you like to create another hero?");
            }
            System.out.println(1 + ". Create a superhero!");
            System.out.println(2 + ". Display heroes!");
            System.out.println(3 + ". Search for a hero");
            System.out.println(9 + ". End the superhero creation");
            int answer = input.nextInt();
            input.nextLine();

            if (answer == 1) {
                database.createSuperheroList();
                createAnotherHeroIndicator = 1;
            } else if (answer == 2) {
                database.displayHeroes();
            } else if(answer == 3){
                System.out.println("Would you like to search for: ");
                System.out.println(1 + ". Hero's normal name?");
                System.out.println(2 + ". Hero's super-hero name?");
                int nameOrHeroName = input.nextInt();
                System.out.print("What hero are you looking for? ");
                database.searchForHero(nameOrHeroName);


            } else if (answer == 9){
                runAgain = false;
            }
        } while(runAgain);
    }
}
