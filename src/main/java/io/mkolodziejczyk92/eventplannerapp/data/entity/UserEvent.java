package io.mkolodziejczyk92.eventplannerapp.data.entity;

import io.mkolodziejczyk92.eventplannerapp.data.enums.StartingTime;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user_event")
public class UserEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    @Column(name = "starting_time")
    @Enumerated(EnumType.STRING)
    private StartingTime startingTime;

    @Column(name = "is_editable")
    private boolean isEditable;

    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
