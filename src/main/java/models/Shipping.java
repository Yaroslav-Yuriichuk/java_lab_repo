package models;

import java.util.ArrayList;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.AllArgsConstructor;

@Setter
@EqualsAndHashCode
@AllArgsConstructor
public final class Shipping {
    private ArrayList<ItemOrdered> itemsOrdered;
    private ShippingType shippingType;

    public Shipping(final Shipping otherShipping) {
        this(new ArrayList<ItemOrdered>(otherShipping.itemsOrdered),
            otherShipping.shippingType.copy());
    }

    public ArrayList<ItemOrdered> getItemsOrdered() {
        return new ArrayList<ItemOrdered>(this.itemsOrdered);
    }

    public ShippingType getShippingType() {
        return this.shippingType.copy();
    }

    public int getShippingTime() {
        return this.shippingType.getCompany().getShippingTypeTimeDays()
                .get(this.shippingType.getShippingTypeName());
    }

    public int calculateShippingPrice() {
        Double totalPrice = 0.0;

        for (ItemOrdered item : itemsOrdered) {
            Double singlePrice = item.getPrice()
                    * this.shippingType.getCompany().getCoefForOrderPrice();

            singlePrice += item.getWeight() * this.shippingType.getCompany().getPriceForOneKilo();

            singlePrice *= this.shippingType.getCompany().getCoefForShippingType()
                    .get(this.shippingType.getShippingTypeName());
            singlePrice *= this.shippingType.getCompany().getCoefForItemType()
                    .get(item.getItemType().toString());

             totalPrice += singlePrice * item.getItemCount();
        }

        if (totalPrice <= this.shippingType.getCompany().getMinimalShippingPrice()) {
            return this.shippingType.getCompany().getMinimalShippingPrice();
        }
        return totalPrice.intValue();
    }

    public int calculatePriceWithoutShipping() {
        int totalPrice = 0;

        for (ItemOrdered item : this.itemsOrdered) {
            totalPrice += item.getPrice() * item.getItemCount();
        }

        return totalPrice;
    }

    @Override
    public String toString() {
        StringBuilder shippingStrBuilder = new StringBuilder("Items ordered:\n");

        for (ItemOrdered item : this.itemsOrdered) {
            shippingStrBuilder.append("  ");
            shippingStrBuilder.append(item.toString());
        }

        shippingStrBuilder.append(this.shippingType.toString());

        shippingStrBuilder.append("Shipping price: ");
        shippingStrBuilder.append(this.calculateShippingPrice());
        shippingStrBuilder.append("\n");

        shippingStrBuilder.append("Total price: ");
        shippingStrBuilder.append(
            this.calculatePriceWithoutShipping() + this.calculateShippingPrice());
        shippingStrBuilder.append("\n");

        shippingStrBuilder.append("Delivery time: ");
        shippingStrBuilder.append(this.getShippingTime());
        shippingStrBuilder.append(" days\n");

        return shippingStrBuilder.toString();
    }
}
