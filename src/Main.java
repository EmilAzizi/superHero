import avengersLeague.AvengersLeague;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        AvengersLeague superheroTeam = new AvengersLeague();
        int createAnotherHeroIndicator = 0;

        System.out.println("Welcome to the official superhero academy. Let's create your superhero!");
        boolean runAgain = true;

        do {
            if(createAnotherHeroIndicator == 1){
                System.out.println("Would you like to create another hero");
            }
            System.out.println(1 + ". Create a superhero!");
            System.out.println(9 + ". End the superhero creation.");
            int answer = input.nextInt();

            if (answer == 1) {
                superheroTeam.createSuperheroList();
            } else if (answer == 9) {
                superheroTeam.displayHeroes();
                runAgain = false;
            }
        } while(runAgain);
    }
}