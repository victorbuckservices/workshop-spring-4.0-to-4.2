package demo._41.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import demo._41.async.AsyncRestController;

/**
 * Created by nlabrot on 01/09/15.
 */
@ControllerAdvice
public class ResponseInterceptor implements ResponseBodyAdvice {

    private static final Logger LOG = LoggerFactory.getLogger(AsyncRestController.class);

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        LOG.info("beforeBodyWrite");
        return body;
    }
}
