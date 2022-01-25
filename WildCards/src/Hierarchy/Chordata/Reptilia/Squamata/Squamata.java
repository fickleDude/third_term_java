package Hierarchy.Chordata.Reptilia.Squamata;

import Hierarchy.Chordata.Reptilia.Reptilia;
import Hierarchy.impl.Order;

public class Squamata extends Reptilia implements Order {
    @Override
    public String toString() {
        return "Отряд Чешуйчатые ";
    }

    @Override
    public String getFamilies() {
        return "Семейство Ящерицы, Семейство Змеи ";
    }
}
