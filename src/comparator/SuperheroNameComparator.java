package comparator;

import superhero.Superhero;

import java.util.Comparator;

public class SuperheroNameComparator implements Comparator<Superhero> {

    @Override
    public int compare(Superhero s1, Superhero s2) {
        return s1.getSuperHeroName().compareTo(s2.getSuperHeroName());
    }
}
