package manager;

import models.ItemOrdered;
import models.Shipping;
import models.ShippingType;

import java.util.ArrayList;
import lombok.Builder;

@Builder
public final class ShippingManager {
    private ArrayList<ItemOrdered> itemsOrdered;
    private ArrayList<ShippingType> shippingTypes;
    private ArrayList<Shipping> shippingOptions;

    public void createOptionslist() {
        for (ShippingType shippingType : this.shippingTypes) {
            this.shippingOptions.add(new Shipping(this.itemsOrdered, shippingType));
        }
    }

    public void displayAllOptions() {
        shippingOptions.forEach((shipping) -> System.out.println(shipping));
    }

    public void sortOptionsBy(final SortParameter sortParameter, final SortOrder sortOrder) {
        switch (sortOrder) {
            case ASCENDING:
                switch (sortParameter) {
                    case PRICE:
                        this.shippingOptions.sort(
                            (s1, s2) -> {
                                return s1.calculateShippingPrice()
                                        - s2.calculateShippingPrice(); });
                        break;
                    case DELIVERY_TIME:
                        this.shippingOptions.sort(
                            (s1, s2) -> {
                                return s1.getShippingTime()
                                    - s2.getShippingTime(); });
                        break;
                    default:
                        break;
                }
                break;
            case DESCENDING:
                switch (sortParameter) {
                    case PRICE:
                        this.shippingOptions.sort(
                            (s1, s2) -> {
                                return s2.calculateShippingPrice()
                                    - s1.calculateShippingPrice(); });
                        break;
                    case DELIVERY_TIME:
                        this.shippingOptions.sort(
                            (s1, s2) -> {
                                return s2.getShippingTime()
                                    - s1.getShippingTime(); });
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
    }

    public ArrayList<Shipping> searchByPrice(final int lowerBound, final int upperBound) {
        ArrayList<Shipping> options = new ArrayList<Shipping>() { };

        for (Shipping shipping : this.shippingOptions) {
            if (lowerBound <= shipping.calculateShippingPrice()
                && shipping.calculateShippingPrice() <= upperBound) {
                    options.add(new Shipping(shipping));
            }
        }

        options.sort(
            (s1, s2) -> {
                return s1.getShippingTime() - s2.getShippingTime(); });

        return options;
    }
}
