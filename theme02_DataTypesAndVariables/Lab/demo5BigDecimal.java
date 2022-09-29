package theme02_DataTypesAndVariables.Lab;

import java.math.BigDecimal;

public class demo5BigDecimal {
    public static void main(String[] args) {

        BigDecimal number = new BigDecimal(0);

        number = number.add(BigDecimal.valueOf(2.5)); //събиране
        number = number.subtract(BigDecimal.valueOf(1.5)); //изваждане
        number = number.multiply(BigDecimal.valueOf(2));//умножение
        number = number.divide(BigDecimal.valueOf(2));//делене

    }
}
