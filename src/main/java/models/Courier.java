package models;

import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public final class Courier extends ShippingType {
    private String name;
    private int age;
    private String phoneNumber;

    @Override
    public ShippingType copy() {
        return Courier.builder()
                .shippingTypeName(this.getShippingTypeName())
                .company(this.getCompany())
                .name(this.name)
                .age(this.age)
                .phoneNumber(this.phoneNumber)
                .build();
    }
}
