import avengersLeague.AvengersLeague;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        AvengersLeague superheroTeam = new AvengersLeague();
        int createAnotherHeroIndicator = 0;
        int index = 0;

        System.out.println("Welcome to the official superhero academy. Let's create your superhero!");
        boolean runAgain = true;

        do {
            if(createAnotherHeroIndicator == 1){
                System.out.println("Create your next hero?");
            }
            System.out.println(1 + ". Create a superhero!");
            System.out.println(9 + ". End the superhero creation.");
            int answer = input.nextInt();
            input.nextLine();

            if (answer == 1) {
                superheroTeam.createSuperheroList(index);
                createAnotherHeroIndicator = 1;
                index++;
            } else if (answer == 9) {
                superheroTeam.displayHeroes();
                runAgain = false;
            }
        } while(runAgain);
    }
}