package Hierarchy.Chordata.Reptilia.Crocodiles.Crocodile;

import Hierarchy.Chordata.Reptilia.Crocodiles.Crocodiles;
import Hierarchy.impl.Family;

public class Crocodile extends Crocodiles implements Family {
    @Override
    public String toString() {
        return "Семейство Настоящие крокодилы ";
    }

    @Override
    public String getSpecies() {
        return "Нильский крокодил ";
    }
}
