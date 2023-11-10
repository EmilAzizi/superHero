package comparator;

import superhero.Superhero;

import java.util.Comparator;

public class RaceComparator implements Comparator<Superhero> {

    @Override
    public int compare(Superhero s1, Superhero s2) {
        return s1.getRace().compareTo(s2.getRace());
    }
}

