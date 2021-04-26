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
        this.itemsOrdered = new ArrayList<ItemOrdered>(otherShipping.itemsOrdered);
        this.shippingType = new ShippingType(otherShipping.shippingType);
    }

    public ArrayList<ItemOrdered> getItemsOrdered() {
        return new ArrayList<ItemOrdered>(this.itemsOrdered);
    }

    public ShippingType getShippingType() {
        return new ShippingType(this.shippingType);
    }

    public int getShippingTime() {
        return this.shippingType.getCompany().getShippingTypeTimeDays()
                .get(this.shippingType.getShippingTypeName());
    }

    public int calculateShippingPrice() {
        Double totalPrice = 0.0;

        for (ItemOrdered item : itemsOrdered) {
            Double singlePrice = item.getPrice() * this.shippingType.getCompany().getCoefForOrderPrice();
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
        String shippingStr = "Items ordered:\n";

        for (ItemOrdered item : this.itemsOrdered) {
            shippingStr += "  " + item.toString();
        }

        shippingStr += this.shippingType.toString();

        shippingStr += "Shipping price: " + this.calculateShippingPrice() + "\n";
        shippingStr += "Total price: "
                + (this.calculatePriceWithoutShipping() + this.calculateShippingPrice()) + "\n";


        shippingStr += "Delivery time: " + this.getShippingTime() + " days\n";

        return shippingStr;
    }
}
