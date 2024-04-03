package com.ideal.idealmaker.exception;

import lombok.Getter;

@Getter
public enum ExceptionMessage {

    EXTENSION_ILLEGAL("지원하지 않는 파일 확장자입니다."),
    NOT_ALLOW_PAGE("잘못된 페이지 접근입니다."),
    ENTITY_NOT_FOUND("요청한 이미지를 찾을 수 없습니다."),
    TYPE_ILLEGAL("?"),
    DTO_NOT_FOUND("DTO를 저장할 수 없습니다."),
    URL_NOT_FOUND("URL을 생성할 수 없습니다."),
    ;



    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }
}
