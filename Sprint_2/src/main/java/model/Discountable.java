package model;

/**
 * Интерфейс Discountable c единственным методом getDiscount. Он возвращает размер скидки — вещественное число.
 */

public interface Discountable {
    double getDiscount();

}

/**
 * Все классы, реализующие этот интерфейс, возвращают значение 0 в методе getDiscount, если в задании не указано иное.
 */
