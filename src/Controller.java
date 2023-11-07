import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Controller {
    private final Database database = new Database(this);
    private final Scanner input;
    private final UserInterface UI = new UserInterface();


    public Controller(){
        input = new Scanner(System.in).useLocale(Locale.US);
    }

    public void run(){
        boolean createAnotherHeroIndicator = false;

        UI.welcomeMessage();

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
                    UI.searchForHeroMessage();
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

    public void giveSuperHeroNameQuestionFromUI(){
        UI.giveSuperHeroNameQuestionMessage();
    }


    public void isHumanQuestionFromUI() {
        UI.isHumanQuestionFromUI();
    }

    public void editSuperHeroNameMessageFromUI(String name){
        UI.editHeroChoicesMessage(name);
    }

    public void showHeroFromUI(int count, String name, String superHeroName, String race,  double strength, int year, String power) {
        UI.showHero(count, name, superHeroName, race, strength, year, power);
    }

    public void searchForHeroFromUI(String name, String superHeroName, String race, double strength, int year, String power){
        UI.searchForHero(name, superHeroName, race, strength, year, power);
    }


    public void searchForHeroBySuperHeroName(String superHeroName, String name, String race, double strength, int year, String power) {
        UI.searchForHeroBySuperHeroName(superHeroName, name, race, strength, year, power);
    }

    public void askForSuperheroYearFromUI(){
        UI.askForSuperheroYear();
    }

    public void askForSuperheroStrengthFromUI(){
        UI.askForSuperheroStrength();
    }

    public void askForSuperheroPowerFromUI(){
        UI.askForSuperheroPower();
    }

    public void askForSuperheroHeroNameYesNoFromUI(){
        UI.askForSuperheroHeroNameYesNo();
    }

    public void askForSuperheroHeroNameFromUI(){
        UI.askForSuperheroHeroName();
    }

    public void mustCreateHeroFromUI() {
        UI.mustCreateHero();
    }

    public void yourHeroesAreFromUI() {
        UI.yourHeroesAre();
    }

    public void isHeroNotFoundFromUI() {
        UI.isHeroNotFound();
    }

    public void changeHeroStrengthFromUI(){
        UI.changeHeroStrength();
    }

    public void changeHeroYearFromUI(){
        UI.changeHeroYear();
    }

    public void changeHeroPowerFromUI(){
        UI.changeHeroPower();
    }

    public void heroWasNotFoundFromUI(){
        UI.heroWasNotFound();
    }

    public void whichHeroToEditSearchByNormalNameFromUI() {
        UI.whichHeroToEditSearchByNormalName();
    }

    public void changeHeroNametoFromUI() {
        UI.changeHeroNameTo();
    }

    public void doesHeroHaveSuperHeroNameFromUI() {
        UI.doesHeroHaveSuperHeroName();
    }

    public void changeSuperHeroNameToFromUI() {
        UI.changeSuperHeroNameTo();
    }

    public void isYourHeroHumanFromUI() {
        UI.isYourHeroHuman();
    }


}
