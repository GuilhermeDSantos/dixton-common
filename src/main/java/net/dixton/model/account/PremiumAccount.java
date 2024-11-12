package net.dixton.model.account;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.dixton.model.Skin;
import net.dixton.model.SkinData;

@Entity
@Getter
@Setter
@ToString
public class PremiumAccount extends Account {

    @ManyToOne
    @JoinColumn(name = "skin_id")
    private Skin skin;

    private SkinData skinData;

}
