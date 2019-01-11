package ru.sky.jrtesttask.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.sky.jrtesttask.model.Component;

public interface ComponentRepository extends JpaRepository<Component, Integer> {

    Page<Component> findAll(Pageable pageable);

    Page<Component> findAllByNameLike( String name, Pageable pageable);

    Page<Component> findAllByNeedFalse(Pageable pageable);

    Page<Component> findAllByNeedTrue(Pageable pageable);


}
