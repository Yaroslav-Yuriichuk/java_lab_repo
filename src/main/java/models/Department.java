package models;

import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public final class Department extends ShippingType {
    private String location;
    private int id;

    @Override
    public ShippingType copy() {
        return Department.builder()
                .shippingTypeName(this.getShippingTypeName())
                .company(this.getCompany())
                .location(this.location)
                .id(this.id)
                .build();
    }
}
