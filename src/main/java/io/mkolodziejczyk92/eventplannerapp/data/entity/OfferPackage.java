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

    @Column(length = 1000)
    private String description;

    private int duration;
    private double price;
    private String specials;

    @Column(name = "other_details", length = 1000)
    private String otherDetails;

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
