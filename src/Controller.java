import superhero.Superhero;

import java.io.IOException;
import java.util.ArrayList;
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
               UI.anotherHero();
            }
            UI.superheroMenu();

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
                    UI.whichHero();
                    database.searchForHero(nameOrHeroName);
                } else if (answer == 4) {
                    database.editHero();
                } else if (answer == 5) {
                    database.addHeroesToDatabase();
                } else if (answer == 9){
                    runAgain = false;
                } else {
                    UI.wrongChoice();
                }
            } catch(InputMismatchException e){
                UI.wrongInput();
                input.nextLine();
            } catch(IOException e){
                e.getMessage();
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
