package net.dixton.model.skin;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Skin {

    @Id
    private Long id;

    private SkinData skinData;
}
