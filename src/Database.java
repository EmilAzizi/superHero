import comparator.*;
import superhero.Superhero;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Database {
    private Scanner sc = new Scanner(System.in);
    private Superhero superhero;
    private Scanner input = new Scanner(System.in);
    private char yesOrNo;
    private String name;
    private boolean race;
    private int year;
    private int strength;
    private String power;
    private char superHeroNameYesOrNo;
    private ArrayList<Superhero> superheroDataBase = new ArrayList<>();
    private Controller controller;

    private final Filehandler file = new Filehandler("SuperheroDatabase.csv", this);

    public Database(Controller controller) {
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

    public void createSuperheroList() throws IOException {
        superheroDataBase.add(createSuperHero());
        file.saveSuperheroToCSV(superheroDataBase);
    }

    public void displayHeroes() {
            if (superheroDataBase.isEmpty()) {
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
        if (heroNameOrSuperheroName == 1) {
            for (Superhero hero : superheroDataBase) {
                if (hero.getName().contains(searchForName)) {
                    controller.searchForHeroFromUI(hero.getName(), hero.getSuperHeroName(), hero.getRace(), hero.getStrength(), hero.getYear(), hero.getPower());
                    isHeroFound = true;
                    break;
                }
            }
        } else if (heroNameOrSuperheroName == 2) {
            for (Superhero hero : superheroDataBase) {
                if (hero.getSuperHeroName().contains(searchForName)) {
                    controller.searchForHeroBySuperHeroName(hero.getSuperHeroName(), hero.getName(), hero.getRace(), hero.getStrength(), hero.getYear(), hero.getPower());
                    isHeroFound = true;
                    break;
                }
            }
        }
        if (!isHeroFound) {
            controller.isHeroNotFoundFromUI();
        }
    }

    public void editHero() throws IOException {

        controller.whichHeroToEditSearchByNormalNameFromUI();
        String changeHero = input.nextLine();
        boolean isFound = false;

        Superhero originalHero = null;
        for(Superhero hero : superheroDataBase){
            if(hero.getName().contains(changeHero)){
                originalHero = hero;
                break;
            }
        }

        Collections.sort(superheroDataBase, new NameComparator());

        Superhero sortedHero = null;
        for(Superhero hero : superheroDataBase){
            if(hero.getName().equals(originalHero.getName())){
                sortedHero = hero;
                break;
            }
        }

            if (sortedHero != null) {
                isFound = true;
                controller.editSuperHeroNameMessageFromUI(sortedHero.getName());
                int answer = input.nextInt();
                input.nextLine();


                if(answer == 1){
                    controller.changeHeroNametoFromUI();
                    String newName = input.nextLine();
                    sortedHero.setName(newName);

                } else if (answer == 2) {
                    controller.doesHeroHaveSuperHeroNameFromUI();
                    char newSuperheroNameYesOrNo = input.next().charAt(0);
                    input.nextLine();

                    if (newSuperheroNameYesOrNo == 'y' || newSuperheroNameYesOrNo == 'Y') {
                        controller.changeSuperHeroNameToFromUI();
                        String newSuperHeroName = input.nextLine();
                        sortedHero.setSuperHeroName(newSuperHeroName);
                    } else {
                        sortedHero.setSuperHeroName(null);
                    }

                } else if (answer == 3) {
                    controller.isYourHeroHumanFromUI();
                    char yesOrNo = input.next().charAt(0);
                    if (yesOrNo == 'y' || yesOrNo == 'Y') {
                        race = true;
                        sortedHero.setRace(race);
                    } else {
                        race = false;
                        sortedHero.setRace(race);
                    }

                } else if (answer == 4) {
                    controller.changeHeroStrengthFromUI();
                    int newStrengthLevel = input.nextInt();
                    sortedHero.setStrength(newStrengthLevel);

                } else if (answer == 5) {
                    controller.changeHeroYearFromUI();
                    int newYear = input.nextInt();
                    input.nextLine();
                    sortedHero.setYear(newYear);

                } else if (answer == 6) {
                    controller.changeHeroPowerFromUI();
                    String newPower = input.nextLine();
                    sortedHero.setPower(newPower);
                }
                file.changeSuperhero();
            }
        if (!isFound) {
            controller.heroWasNotFoundFromUI();
        }
    }


    public void addHeroesToDatabase() throws IOException {
        for(Superhero hero : file.loadHeroes()){
            superheroDataBase.add(hero);
        }
        controller.yourHeroesHaveBeenLoadedFromUI();
    }

    public ArrayList<Superhero> getSuperheroDataBase() {
        return superheroDataBase;
    }

    public void sortHeroesByOneAttribute() {
        int userChoise = input.nextInt();
        switch(userChoise) {
            case 1 -> Collections.sort(superheroDataBase, new NameComparator());
            case 2 -> Collections.sort(superheroDataBase, new SuperheroNameComparator());
            case 3 -> Collections.sort(superheroDataBase, new RaceComparator());
            case 4 -> Collections.sort(superheroDataBase, new StrenthComparator());
            case 5 -> Collections.sort(superheroDataBase, new PowerComparator());
            case 6 -> Collections.sort(superheroDataBase, new YearComparator());
        }
    }

    public void sortHeroesByAttribute(int userChoice1, int userChoice2) {
        Comparator comparator1 = null;
        Comparator comparator2 = null;

        switch(userChoice1) {
            case 1 -> comparator1 = new NameComparator();
            case 2 -> comparator1 = new SuperheroNameComparator();
            case 3 -> comparator1 = new RaceComparator();
            case 4 -> comparator1 = new StrenthComparator();
            case 5 -> comparator1 = new PowerComparator();
            case 6 -> comparator1 = new YearComparator();
        }
        switch(userChoice2) {
            case 1 -> comparator2 = new NameComparator();
            case 2 -> comparator2 = new SuperheroNameComparator();
            case 3 -> comparator2 = new RaceComparator();
            case 4 -> comparator2 = new StrenthComparator();
            case 5 -> comparator2 = new PowerComparator();
            case 6 -> comparator2 = new YearComparator();
        }

        Collections.sort(superheroDataBase, comparator1.thenComparing(comparator2));
    }
}
