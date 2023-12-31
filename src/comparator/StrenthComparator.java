package comparator;

import superhero.Superhero;

import java.util.Comparator;

public class StrenthComparator implements Comparator<Superhero> {

    @Override
    public int compare(Superhero s1, Superhero s2) {
        return Double.compare(s1.getStrength(),(s2.getStrength()));
    }
}

