package br.com.vanguardasistemas.adapter.interceptor;

import java.lang.reflect.Type;
import java.util.Map;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

@ControllerAdvice
public class EmptyStringToNullInterceptor extends RequestBodyAdviceAdapter {

  @Override
  public boolean supports(
    @NonNull MethodParameter methodParameter,
    @NonNull Type targetType,
    @NonNull Class<? extends HttpMessageConverter<?>> converterType
  ) {
    return true;
  }

  @Override
  public @NonNull Object afterBodyRead(
    @NonNull Object body,
    @NonNull HttpInputMessage inputMessage,
    @NonNull MethodParameter parameter,
    @NonNull Type targetType,
    @NonNull Class<? extends HttpMessageConverter<?>> converterType
  ) {
    if (body instanceof Map) {
      convertEmptyStringsToNull((Map<?, ?>) body);
    }
    return body;
  }

  @SuppressWarnings("unchecked")
  private void convertEmptyStringsToNull(Map<?, ?> map) {
    map.forEach((key, value) -> {
      if (value instanceof String && ((String) value).trim().isEmpty()) {
        ((Map<Object, Object>) map).put(key, null);
      } else if (value instanceof Map) {
        convertEmptyStringsToNull((Map<?, ?>) value);
      }
    });
  }
} 