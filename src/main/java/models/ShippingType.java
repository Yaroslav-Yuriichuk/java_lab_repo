package models;

import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;

@Setter
@EqualsAndHashCode
@AllArgsConstructor
@SuperBuilder
public abstract class ShippingType {
    @Getter
    private String shippingTypeName;
    private Company company;

    @Override
    public String toString() {
        return String.format("Shipping Type: %s%n%s%n",
                this.getShippingTypeName(),
                this.company.toString());
    }

    public Company getCompany() {
        return new Company(this.company);
    }

    public ShippingType(final ShippingType otherShippingType) {
        this(otherShippingType.shippingTypeName,
            new Company(otherShippingType.company));
    }

    public abstract ShippingType copy();
}
