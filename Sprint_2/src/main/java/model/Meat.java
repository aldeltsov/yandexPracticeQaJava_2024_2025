package model;

import model.constants.Discount;

/**
 * Наследники класса Food: Meat и Apple
 * Класс Meat — для мяса.
 * Это класс с конструктором.
 * Конструктор принимает два входных параметра — количество и цену.
 * И устанавливает для флага isVegetarian правильное значение.
 */

public class Meat extends Food implements Discountable {
    public Meat(int amount, double price) {
        isVegetarian = false;
        this.amount = amount;
        this.price = price;
    }

    @Override
    public double getDiscount() {
        return Discount.DEFAULT;
    }
}
