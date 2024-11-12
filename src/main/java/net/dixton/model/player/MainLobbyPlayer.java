package net.dixton.model.player;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class MainLobbyPlayer extends Player {

    private Boolean playersHidden;

}
