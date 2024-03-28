package com.ideal.idealmaker.share.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ideal.idealmaker.ideal.domain.Ideal;

/*
 * 	작성자 : 정여민
 * 	작성 일시 : 2024.03.25
 * 	업데이트 : 2024.03.25
 * */
@Repository
public interface ShareImageRepository extends JpaRepository<Ideal, Long> {
	Ideal findIdealById(Long id);

}
