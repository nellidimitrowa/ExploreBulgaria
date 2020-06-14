package com.example.explorebulgaria.repositories.base;

import java.io.IOException;
import java.util.List;

public interface Repository<T> {

    List<T> getAll() throws IOException;

    T getById(int id) throws IOException;
}
