package ru.bellintegrator.educational_project.aop;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import ru.bellintegrator.educational_project.aop.dto.ErrorDto;
import ru.bellintegrator.educational_project.aop.dto.ResultDto;
import ru.bellintegrator.educational_project.aop.dto.ResultDtoForVoid;

@RestControllerAdvice
public class ResponseBodyHandler implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {


        if (body == null) {
            ResultDtoForVoid resultDtoForVoid = new ResultDtoForVoid();
            resultDtoForVoid.setResult("success");
            return resultDtoForVoid;
        } else if (body.getClass() == ErrorDto.class) {
            return body;
        } else {
            ResultDto resultDto = new ResultDto();
            resultDto.setData(body);
            return resultDto;
        }

    }
}
