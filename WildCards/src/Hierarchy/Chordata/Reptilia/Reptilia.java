package Hierarchy.Chordata.Reptilia;

import Hierarchy.Chordata.Chordata;
import Hierarchy.impl.Class;

public class Reptilia extends Chordata implements Class {
    @Override
    public String getOrder() {
        return "Отряды: Черепахи, Крокодилы, Чешуйчатые ";
    }

    @Override
    public String toString() {
        return "Пресмыкающиеся ";
    }
}
