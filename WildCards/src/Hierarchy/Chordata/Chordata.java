package Hierarchy.Chordata;

import Hierarchy.impl.Phylum;

public class Chordata implements Phylum {
    @Override
    public String toString() {
        return "Тип Хордовые ";
    }

    @Override
    public String getClasses() {
        return "Класс Пресмыкающиеся ";
    }
}
