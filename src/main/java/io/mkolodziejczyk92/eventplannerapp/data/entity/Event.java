package io.mkolodziejczyk92.eventplannerapp.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "events")
public class Event extends AbstractEntity{

    private String name;

    @OneToMany(mappedBy = "event")
    private List<Offer> offers;

}
