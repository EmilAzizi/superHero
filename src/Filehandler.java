import superhero.Superhero;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Filehandler {
    private final File f;

    Superhero loadHero;

    public Filehandler(String fileName) {
        f = new File(fileName);
    }

    public void saveSuperheroToCSV(ArrayList<Superhero> heroList) throws IOException {
        PrintStream output = new PrintStream(f);
        for (Superhero hero : heroList) {
            String line = hero.getName() + ";" + hero.getSuperHeroName() + ";" + hero.getRace() + ";" + hero.getYear()
                    + ";" + hero.getStrength() + ";" + hero.getPower();
            output.println(line);
        }
        output.close();
    }

    public ArrayList<Superhero> loadHeroes() throws IOException {
        ArrayList<Superhero> heroes = new ArrayList<>();
        Scanner sc = new Scanner(f);


        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            String[] attributes = line.split(";");

            String name = attributes[0];
            //System.out.println(attributes[2]);
            //boolean isHuman = attributes[2].contains("Human");
            int year = Integer.parseInt(attributes[3]);
            double strength = Double.parseDouble(attributes[4]);
            String power = attributes[5];
            String superHeroName = attributes[1];


            if(attributes[2].contains("Human")){
                loadHero = new Superhero(name, true, year, strength, power, superHeroName);
            } else {
                loadHero = new Superhero(name, false, year, strength, power, superHeroName);
            }

            loadHero = new Superhero(name, true, year, strength, power, superHeroName);

            heroes.add(loadHero);

        }

        sc.close();
        return heroes;
    }

}
