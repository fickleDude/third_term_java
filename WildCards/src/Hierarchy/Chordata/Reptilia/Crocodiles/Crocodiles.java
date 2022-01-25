package Hierarchy.Chordata.Reptilia.Crocodiles;

import Hierarchy.Chordata.Reptilia.Reptilia;
import Hierarchy.impl.Order;

public class Crocodiles extends Reptilia implements Order {
    @Override
    public String getFamilies() {
        return "Семейство Настоящие Крокодилы, семейство Аллигаторы, семейство Гавиалы ";
    }

    @Override
    public String toString() {
        return "Отряд крокодилы ";
    }
}
