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
public class PremiumPlayer extends Player {

    @ManyToOne
    @JoinColumn(name = "skin_id")
    private Skin skin;

    private SkinData skinData;

}
