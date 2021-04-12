package ro.fasttrackit.homework6.products.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Category {
    FOOD("Food"),
    DRINKS("Drinks"),
    ELECTRONICS("Electronics"),
    CLOTHES("Clothes");

    private final String categoryName;
}
