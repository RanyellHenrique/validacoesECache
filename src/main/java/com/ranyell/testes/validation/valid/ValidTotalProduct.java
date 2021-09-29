package com.ranyell.testes.validation.valid;

import com.ranyell.testes.validation.dtos.ItemProduct;
import com.ranyell.testes.validation.dtos.Order;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class ValidTotalProduct implements ConstraintValidator<ValidTotal, Order> {

    @Override
    public boolean isValid(Order listFilterProduct, ConstraintValidatorContext context) {
        Double sum = sumTotal(listFilterProduct);
        validation(listFilterProduct, context, sum);
        return Objects.equals(sum, listFilterProduct.getTotal());
    }

    private Double sumTotal(Order listFilterProduct) {
        return listFilterProduct.getItems().stream()
                .map(ItemProduct::getPrice)
                .reduce(0.0, Double::sum);
    }

    private void validation(Order listFilterProduct, ConstraintValidatorContext context, Double sum) {
        if (!Objects.equals(sum, listFilterProduct.getTotal())) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Total deve ser igual a soma dos valores")
                    .addPropertyNode("Total")
                    .addConstraintViolation();
        }
    }
}
