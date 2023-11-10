package comparator;

import superhero.Superhero;

import java.util.Comparator;

public class YearComparator implements Comparator<Superhero> {

    @Override
    public int compare(Superhero s1, Superhero s2) {
        return Integer.compare(s1.getYear(), (s2.getYear()));
    }
}
