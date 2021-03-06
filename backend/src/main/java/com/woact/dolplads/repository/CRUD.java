package com.woact.dolplads.repository;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by dolplads on 12/10/2016.
 */
public interface CRUD<E, T> {
    T save(@Valid @NotNull T entity);

    T findById(@NotNull E id);

    void remove(@NotNull T entity);

    List<T> findAll();


}
