package models;

import java.util.HashMap;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.AllArgsConstructor;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public final class Company {
    private String name;
    private double rating;
    private int minimalShippingPrice;
    private double priceForOneKilo;
    private double coefForOrderPrice;
    private HashMap<String, Double> coefForShippingType;
    private HashMap<String, Integer> shippingTypeTimeDays;
    private HashMap<String, Double> coefForItemType;

    @Override
    public String toString() {
        return String.format("Company: %s%nRating: %s",
                this.getName(),
                this.getRating());
    }

    public Company(final Company otherCompany) {
        this(otherCompany.name,
            otherCompany.rating,
            otherCompany.minimalShippingPrice,
            otherCompany.priceForOneKilo,
            otherCompany.coefForOrderPrice,
            new HashMap<String, Double>(otherCompany.coefForShippingType),
            new HashMap<String, Integer>(otherCompany.shippingTypeTimeDays),
            new HashMap<String, Double>(otherCompany.coefForItemType));
    }

}
