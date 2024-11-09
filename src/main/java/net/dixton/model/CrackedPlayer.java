package net.dixton.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class CrackedPlayer extends Player {

    @ManyToOne(optional = false)
    @JoinColumn(name = "skin_id")
    private Skin skin;

}
