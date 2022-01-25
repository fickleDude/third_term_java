package Hierarchy.Chordata.Reptilia.Crocodiles.Alligator;

import Hierarchy.Chordata.Reptilia.Crocodiles.Crocodiles;
import Hierarchy.impl.Family;

public class Alligator extends Crocodiles implements Family {
    @Override
    public String toString() {
        return "Семейство Аллигаторы ";
    }

    @Override
    public String getSpecies() {
        return "Миссисипский аллигатор ";
    }
}
