package com.ideal.idealmaker.share.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ideal.idealmaker.ideal.domain.Ideal;
import com.ideal.idealmaker.share.data.ShareImageDto;
import com.ideal.idealmaker.share.repository.ShareImageRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/*
 * 	작성자 : 정여민
 * 	작성 일시 : 2024.03.25
 * 	업데이트 : 2024.03.25
 *	내용 : 이미지 공유 URL
 * */

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
@Slf4j
public class ShareImageService {
	private final ShareImageRepository shareImageRepository;

	@Transactional
	public ShareImageDto getShareImageURL(Long id){

		Ideal idealEntity = shareImageRepository.findIdealById(id);

		ShareImageDto shareImageDto = ShareImageDto.from(idealEntity);

		return shareImageDto;
	}
}
