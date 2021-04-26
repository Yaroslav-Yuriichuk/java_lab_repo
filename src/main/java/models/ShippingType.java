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
public class ShippingType {
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
        this.shippingTypeName = otherShippingType.shippingTypeName;
        this.company = new Company(otherShippingType.company);
    }
}
