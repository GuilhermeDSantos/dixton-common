package net.dixton.services;

import net.dixton.exceptions.server.ServerNotFoundException;
import net.dixton.model.server.Server;

import java.util.List;

public interface ServerService {

    Server findById(Long id) throws ServerNotFoundException;
    List<Server> findAll();

}
