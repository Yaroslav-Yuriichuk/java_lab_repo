package ua.lviv.iot;

import java.util.ArrayList;
import java.util.HashMap;
import models.ItemOrdered;
import models.ItemType;
import models.Company;
import models.Courier;
import models.Department;
import models.Postamat;
import models.Shipping;
import models.ShippingType;
import manager.ShippingManager;
import manager.SortOrder;
import manager.SortParameter;

public class App {
    public static void main(String[] args) {
        final Company novaPoshta = new Company(
                "Nova Poshta", 4.7, 45, 7.0, 0.017,
                new HashMap<String, Double>() {{
                    put("Courier", 1.04);
                    put("Postamat", 1.02);
                    put("Department", 1.0); }},
                new HashMap<String, Integer>() {{
                    put("Courier", 1);
                    put("Postamat", 3);
                    put("Department", 2); }},
                new HashMap<String, Double>() {{
                    put("FRAGILE", 1.03);
                    put("LIQUID", 1.02);
                    put("REGULAR", 1.0); }});

        final Company ukrPoshta = new Company(
                "Ukr Poshta", 4.4, 35, 6.9, 0.016,
                new HashMap<String, Double>() {{
                    put("Courier", 1.04);
                    put("Postamat", 1.02);
                    put("Department", 1.03); }},
                new HashMap<String, Integer>() {{
                    put("Courier", 2);
                    put("Postamat", 4);
                    put("Department", 3); }},
                new HashMap<String, Double>() {{
                    put("FRAGILE", 1.01);
                    put("LIQUID", 1.01);
                    put("REGULAR", 1.0); }});

        final ArrayList<ShippingType> shippingTypes = new ArrayList<ShippingType>() {{
            add(Courier.builder()
                .shippingTypeName("Courier")
                .company(novaPoshta)
                .name("Ivan")
                .age(26)
                .phoneNumber("380664825492")
                .build());

            add(Courier.builder()
                .shippingTypeName("Courier")
                .company(ukrPoshta)
                .name("Petro")
                .age(31)
                .phoneNumber("380668397492")
                .build());

            add(Postamat.builder()
                    .shippingTypeName("Postamat")
                    .company(novaPoshta)
                    .location("Komarova str.")
                    .id(345)
                    .build());

            add(Postamat.builder()
                    .shippingTypeName("Postamat")
                    .company(ukrPoshta)
                    .location("Holovna str.")
                    .id(36)
                    .build());

            add(Department.builder()
                    .shippingTypeName("Department")
                    .company(novaPoshta)
                    .location("Univrs. str.")
                    .id(234)
                    .build());

            add(Department.builder()
                    .shippingTypeName("Department")
                    .company(ukrPoshta)
                    .location("Haharina str.")
                    .id(45)
                    .build());
        }};

        final ArrayList<ItemOrdered> itemsOrdered = new ArrayList<ItemOrdered>() {{
            add(new ItemOrdered("Acer E5", 17000, 2.1, 1, ItemType.REGULAR));
            add(new ItemOrdered("Vase", 1100, 0.5, 2, ItemType.FRAGILE));
        }};

        ShippingManager shippingManager = ShippingManager.builder()
                .itemsOrdered(itemsOrdered)
                .shippingTypes(shippingTypes)
                .shippingOptions(new ArrayList<Shipping>() { })
                .build();

        shippingManager.createOptionslist();

        System.out.println("All option sorted by delivery time in ascending order\n");
        shippingManager.sortOptionsBy(SortParameter.DELIVERY_TIME, SortOrder.ASCENDING);
        shippingManager.displayAllOptions();

        System.out.println("\nAll option sorted by price in descending order\n");
        shippingManager.sortOptionsBy(SortParameter.PRICE, SortOrder.DESCENDING);
        shippingManager.displayAllOptions();

        System.out.println("\nAll option in range from 340 hrn. up to 360 hrn.\n");
        for (Shipping shipping : shippingManager.searchByPrice(340, 360)) {
            System.out.println(shipping);
        }

    }
}
