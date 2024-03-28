package com.ideal.idealmaker.exception;

import lombok.Getter;

@Getter
public enum ExceptionMessage {

    EXTENSION_ILLEGAL("지원하지 않는 파일 확장자입니다."),
    TYPE_ILLEGAL("지원하지 않는 설문조사 타입입니다."),
    NOT_ALLOW_PAGE("잘못된 페이지 접근입니다.");


    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }
}
