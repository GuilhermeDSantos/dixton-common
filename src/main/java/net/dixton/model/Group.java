package net.dixton.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.dixton.model.server.Server;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Group {

    @Id
    private Long id;

    @OneToMany(mappedBy = "defaultGroup")
    private List<Server> servers;
}
