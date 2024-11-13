package net.dixton.model.account;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.dixton.model.skin.Skin;
import net.dixton.model.skin.SkinData;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
public class AccountPremium extends Account {

    @ManyToOne
    @JoinColumn(name = "skin_id")
    private Skin skin;

    private SkinData skinData;

}
