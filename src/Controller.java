import avengersLeague.AvengersLeague;
import superhero.Superhero;

import java.util.Locale;
import java.util.Scanner;

public class Controller {
    AvengersLeague avengersLeague;

    public Controller(AvengersLeague avengersLeague){
        this.avengersLeague = avengersLeague;
    }

    public void run(){
        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        int createAnotherHeroIndicator = 0;

        System.out.println("Welcome to the official superhero academy. Let's create your superhero!");
        boolean runAgain = true;

        do {
            if(createAnotherHeroIndicator == 1){
                System.out.println("Create your next hero?");
            }
            System.out.println(1 + ". Create a superhero!");
            System.out.println(2 + ". Display heroes!");
            System.out.println(9 + ". End the superhero creation");
            int answer = input.nextInt();
            input.nextLine();

            if (answer == 1) {
                avengersLeague.createSuperheroList();
                createAnotherHeroIndicator = 1;
            } else if (answer == 2) {
                avengersLeague.displayHeroes();
            } else if (answer == 9){
                runAgain = false;
            }
        } while(runAgain);
    }
}
