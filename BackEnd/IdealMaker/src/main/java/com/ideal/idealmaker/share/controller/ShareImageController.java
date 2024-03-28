package com.ideal.idealmaker.share.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ideal.idealmaker.share.data.ShareImageDto;
import com.ideal.idealmaker.share.service.ShareImageService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/share/image")
@RequiredArgsConstructor
public class ShareImageController {

	private final ShareImageService shareImageService;

	@GetMapping("/{ideal_id}")
	@ResponseStatus(HttpStatus.OK)
	public ShareImageDto getShareImageURL(@PathVariable("ideal_id") Long id){

		return shareImageService.getShareImageURL(id);
	}

}
