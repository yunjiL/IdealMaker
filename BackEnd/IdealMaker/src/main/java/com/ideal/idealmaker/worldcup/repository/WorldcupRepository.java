package com.ideal.idealmaker.worldcup.repository;

import com.ideal.idealmaker.ideal.domain.Ideal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WorldcupRepository extends JpaRepository<Ideal, Long> {

}

