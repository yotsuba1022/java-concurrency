package idv.java.ccr.threads.example12;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author Carl Lu
 * <p>
 * Here is an immutable Planets class whose objects store sets of planet
 * names. Although the set is mutable, the design of this class prevents the set from being
 * modified after the constructor exits. By declaring planets final, the reference stored
 * in this field cannot be modified. Furthermore, this reference will not be cached so the
 * cached variable problem goes away.
 */
public class Planets {

    private final Set<String> planets = new TreeSet<>();

    public Planets() {
        planets.add("Mercury");
        planets.add("Venus");
        planets.add("Earth");
        planets.add("Mars");
        planets.add("Jupiter");
        planets.add("Saturn");
        planets.add("Uranus");
        planets.add("Neptune");
    }

    public boolean isPlanet(String planetName) {
        return planets.contains(planetName);
    }

}
