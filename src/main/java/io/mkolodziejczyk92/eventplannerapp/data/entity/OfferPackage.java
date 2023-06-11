package io.mkolodziejczyk92.eventplannerapp.data.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "package")
public class OfferPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private double price;
    private String specials;

    @Column(name = "max_amount_of_people")
    private Integer maxAmountOfPeople;

    @Column(name = "is_own_food_available")
    private Boolean isOwnFoodAvailable;

    @Column(name = "is_own_drink_available")
    private Boolean isOwnDrinkAvailable;

    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;

}
