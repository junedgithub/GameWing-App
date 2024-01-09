package com.ty.gamewingmanagementapp.repository;

import com.ty.gamewingmanagementapp.dto.PlayArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PlayAreaRepository extends JpaRepository<PlayArea,Integer> {
    @Query("SELECT p FROM PlayArea p WHERE p.sport=?1")
    PlayArea findBySport(String sport);
}
