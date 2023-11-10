package comparator;

import superhero.Superhero;

import java.util.Comparator;

public class PowerComparator implements Comparator<Superhero> {

    @Override
    public int compare(Superhero s1, Superhero s2) {
        return s1.getPower().compareTo(s2.getPower());
    }
}

