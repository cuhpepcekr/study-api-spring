package org.cuhpepcekr.api.advice;

import lombok.RequiredArgsConstructor;
import org.cuhpepcekr.api.advice.exception.CUserNotFoundException;
import org.cuhpepcekr.api.model.response.CommonResult;
import org.cuhpepcekr.api.service.ResponseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestControllerAdvice
// @RestControllerAdvice(basePackages = “com.rest.api”) 특정 패키지 하위의 Controller에만 로직이 적용되게도 할 수 있습니다.
public class ExceptionAdvice {

    private final ResponseService responseService;

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected CommonResult defaultException(HttpServletRequest request, Exception e) {
        return responseService.getFailResult();
    }

    @ExceptionHandler(CUserNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected CommonResult userNotFoundException(HttpServletRequest request, CUserNotFoundException e) {
        return responseService.getFailResult();
    }
}