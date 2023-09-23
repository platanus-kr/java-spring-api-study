package com.project.springapistudy.beverages.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BeverageRepository extends JpaRepository<Beverage, Long> {

    List<Beverage> findByDeletedFalseOrderByUpdatedDesc();

}
