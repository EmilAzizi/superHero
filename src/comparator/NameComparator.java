package comparator;

import superhero.Superhero;

import java.util.Comparator;

public class NameComparator implements Comparator<Superhero> {

    @Override
    public int compare(Superhero s1, Superhero s2) {
        return s1.getName().compareTo(s2.getName());
    }
}