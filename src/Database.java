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
    Controller controller;

    public Database(Controller controller){
        this.controller = controller;
    }

    public Superhero createSuperHero() {

        controller.giveSuperHeroNameQuestionFromUI();
        name = input.nextLine();
        controller.isHumanQuestionFromUI();
        yesOrNo = input.next().charAt(0);

        if (yesOrNo == 'y') {
            race = true;
        } else {
            race = false;
        }

        controller.askForSuperheroYearFromUI();
        year = input.nextInt();

        controller.askForSuperheroStrengthFromUI();
        strength = input.nextInt();
        input.nextLine();

        controller.askForSuperheroPowerFromUI();
        power = input.nextLine();

        controller.askForSuperheroHeroNameYesNoFromUI();
        superHeroNameYesOrNo = input.next().charAt(0);
        input.nextLine();

        if (superHeroNameYesOrNo == 'y' || superHeroNameYesOrNo == 'Y') {
            controller.askForSuperheroHeroNameFromUI();
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
            controller.mustCreateHeroFromUI();
        } else {
            controller.yourHeroesAreFromUI();
            int count = 0;
            for (Superhero hero : superheroDataBase) {
                count++;
                controller.showHeroFromUI(count, hero.getName(), hero.getSuperHeroName(), hero.getRace(), hero.getStrength(), hero.getYear(), hero.getPower());
            }
        }
    }

    public void searchForHero(int heroNameOrSuperheroName) {
        boolean isHeroFound = false;
        String searchForName = input.nextLine();
        if(heroNameOrSuperheroName == 1){
            for (Superhero hero : superheroDataBase) {
                if (hero.getName().contains(searchForName)) {
                    controller.searchForHeroFromUI(hero.getName(), hero.getSuperHeroName(), hero.getRace(), hero.getStrength(), hero.getYear(), hero.getPower());
                    isHeroFound = true;
                    break;
                }
            }
        } else if(heroNameOrSuperheroName == 2){
            for (Superhero hero : superheroDataBase) {
                if (hero.getSuperHeroName().contains(searchForName)) {
                    controller.searchForHeroBySuperHeroName(hero.getSuperHeroName(), hero.getName(), hero.getRace(), hero.getStrength(), hero.getYear(), hero.getPower());
                    isHeroFound = true;
                    break;
                }
            }
        }
        if(!isHeroFound){
            controller.isHeroNotFoundFromUI();
        }
    }

    public void editHero(){
        controller.whichHeroToEditSearchByNormalNameFromUI();
        String changeHero = input.nextLine();
        boolean isFound = false;

        for (Superhero hero : superheroDataBase) {
            if (hero.getName().contains(changeHero)) {
                isFound = true;
                controller.editSuperHeroNameMessageFromUI(hero.getName());
                int answer = input.nextInt();
                input.nextLine();

                if(answer == 1){
                    controller.changeHeroPowerFromUI();
                    String newName = input.nextLine();
                    hero.setName(newName);

                } else if(answer == 2){
                    controller.doesHeroHaveSuperHeroNameFromUI();
                    char newSuperheroNameYesOrNo = input.next().charAt(0);
                    input.nextLine();

                    if(newSuperheroNameYesOrNo == 'y' ||newSuperheroNameYesOrNo == 'Y'){
                        controller.changeSuperHeroNameToFromUI();
                        String newSuperHeroName = input.nextLine();
                        hero.setSuperHeroName(newSuperHeroName);
                    } else{
                        hero.setSuperHeroName(null);
                    }

                } else if(answer == 3){
                    controller.isYourHeroHumanFromUI();
                    char yesOrNo = input.next().charAt(0);
                    if(yesOrNo == 'y' || yesOrNo == 'Y'){
                        race = true;
                        hero.setRace(race);
                    } else {
                        race = false;
                        hero.setRace(race);
                    }

                } else if(answer == 4){
                    controller.changeHeroStrengthFromUI();
                    int newStrengthLevel = input.nextInt();
                    hero.setStrength(newStrengthLevel);

                } else if(answer == 5){
                    controller.changeHeroYearFromUI();
                    int newYear = input.nextInt();
                    input.nextLine();
                    hero.setYear(newYear);

                } else if(answer == 6){
                    controller.changeHeroPowerFromUI();
                    String newPower = input.nextLine();
                    hero.setPower(newPower);
                }
            }
        }
        if(!isFound) {
            controller.heroWasNotFoundFromUI();
        }
    }
}
