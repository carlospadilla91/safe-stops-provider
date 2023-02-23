package com.safeStopsProvider.SafeStopsProvider.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.safeStopsProvider.SafeStopsProvider.model.SafeStop;

@Repository
public interface SafeStopRepository extends JpaRepository<SafeStop, Long> {

}
