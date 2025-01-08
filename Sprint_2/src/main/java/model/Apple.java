package model;

import model.constants.Colour;
import model.constants.Discount;

/**
 * Класс Apple — для яблок.
 * У него есть ещё строковое поле colour — цвет яблок.
 * Конструктор принимает три параметра: количество, цену и цвет яблок — и устанавливает флаг isVegetarian.
 * Для красных яблок (colour равно "red") скидка должна быть равна 60%: соответствующий метод возвращает значение 60.
 */

public class Apple extends Food implements Discountable {

    private String colour;

    public Apple(int amount, double price, String colour) {
        isVegetarian = true;
        this.amount = amount;
        this.price = price;
        this.colour = colour;
    }

    @Override
    public double getDiscount() {
        if (Colour.RED.equals(colour)) {
            return Discount.RED_APPLE;
        } else
            return Discount.DEFAULT;
          }
}
