import java.util.Locale;
import java.util.Scanner;

public class UserInterface {


    public void anotherHero() {
        System.out.println("Would you like to create another hero?");
    }


    public void superheroMenu() {
        System.out.println(1 + ". Create a superhero!");
        System.out.println(2 + ". Display heroes!");
        System.out.println(3 + ". Search for a hero.");
        System.out.println(4 + ". Edit a hero.");
        System.out.println(5 + ". Load heroes.");
        System.out.println(9 + ". End the superhero creation.");
    }


    public void welcomeMessage(){
        System.out.println("Welcome to the official superhero academy. Let's create your superhero!");
    }

    public void searchForHeroMessage(){
        System.out.println("Would you like to search for: ");
        System.out.println(1 + ". Hero's normal name?");
        System.out.println(2 + ". Hero's super-hero name?");
    }


    public void whichHero() {
        System.out.print("What hero are you looking for? ");

    }



    public void wrongChoice() {
        System.out.println("The input is not corresponding to the choices shown above, please pick one of five options.");
    }

    public void wrongInput() {
        System.out.println("Invalid input. Please type a number corresponding to a valid option.");
    }

    public void giveSuperHeroNameQuestionMessage(){
        System.out.print("What is the name of your hero? ");
    }

    public void isHumanQuestionFromUI() {
        System.out.print("Is your hero a human? [y/n] ");
    }

    public void editHeroChoicesMessage(String name){
        System.out.println("What would you like to change about " + name);
        System.out.println(1 + ". Name");
        System.out.println(2 + ". Superhero name");
        System.out.println(3 + ". Race");
        System.out.println(4 + ". Strength level");
        System.out.println(5 + ". Year");
        System.out.println(6 + ". Power");
    }


    public void showHero(int count, String name, String superHeroName, String race,  double strength, int year, String power ) {
        System.out.println(count + " Name: " + name);
        System.out.println("  Super hero name: " + superHeroName);
        System.out.println("  Race: " + race);
        System.out.println("  Strength level: " + strength);
        System.out.println("  Year: " + year);
        System.out.println("  Power: " + power);
        System.out.println("---------------------------------------------");
    }

    public void searchForHero(String name, String superHeroName, String race, double strength, int year, String power){
        System.out.println("  Your hero was found! Here is an overview of " + name);
        System.out.println("  Super hero name: " + superHeroName);
        System.out.println("  Race: " + race);
        System.out.println("  Strength level: " + strength);
        System.out.println("  Year: " + year);
        System.out.println("  Power: " + power);
    }


    public void searchForHeroBySuperHeroName(String superHeroName, String name, String race, double strength, int year, String power) {
        System.out.println("  Your hero was found! Here is an overview of the " + superHeroName + " AKA " + name);
        System.out.println("  Race: " + race);
        System.out.println("  Strength level: " + strength);
        System.out.println("  Year: " + year);
        System.out.println("  Power: " + power);
    }

    public void askForSuperheroYear(){
        System.out.print("When did your hero get created? ");
    }

    public void askForSuperheroStrength(){
        System.out.print("What is the strength of your hero? Ex. 9000: ");
    }

    public void askForSuperheroPower(){
        System.out.print("What kind of power/powers does your hero have? ");
    }


    public void mustCreateHero() {
        System.out.println("You must create a hero first in order to diplay it.");
    }

    public void askForSuperheroHeroNameYesNo(){
        System.out.print("Does your hero have a superhero-name? [y/n] ");
    }

    public void askForSuperheroHeroName(){
        System.out.print("What is the superhero name? ");
    }

    public void yourHeroesAre() {
        System.out.println("Your heroes are: ");
    }

    public void isHeroNotFound() {
        System.out.println("Your hero was not found. Please create the hero in order to view it.");
    }

    public void changeHeroStrength(){
        System.out.print("Change your hero's strength level to: ");
    }

    public void changeHeroYear(){
        System.out.print("Change your hero's creation year to: ");
    }

    public void changeHeroPower(){
        System.out.print("Change your hero's power to: ");
    }

    public void whichHeroToEditSearchByNormalName() {
        System.out.print("Which hero would you like to edit? (Search by normal name): ");
    }

    public void heroWasNotFound(){
        System.out.println("Your hero was not found, please create the hero in order to edit it.");
    }

    public void changeHeroNameTo() {
        System.out.print("Change your hero's name to: ");
    }

    public void doesHeroHaveSuperHeroName() {
        System.out.print("Does your hero have a superhero name? [y/n] ");
    }

    public void changeSuperHeroNameTo() {
        System.out.print("Change your hero's superhero name to: ");
    }

    public void isYourHeroHuman() {
        System.out.print("Is your hero human? [y/n] ");
    }


}
