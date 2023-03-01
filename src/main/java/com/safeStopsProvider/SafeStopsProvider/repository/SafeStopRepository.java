package com.safeStopsProvider.SafeStopsProvider.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.safeStopsProvider.SafeStopsProvider.model.SafeStop;

@CrossOrigin
@Repository
public interface SafeStopRepository extends JpaRepository<SafeStop, Long> {

}
