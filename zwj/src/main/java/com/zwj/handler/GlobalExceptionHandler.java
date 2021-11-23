package com.zwj.handler;
import com.zwj.util.CommonResult;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.validation.UnexpectedTypeException;
import java.util.List;
import java.util.stream.Collectors;
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {MethodArgumentNotValidException.class, UnexpectedTypeException.class})
    public CommonResult<Void> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        // 获取所有异常
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        return CommonResult.validateFailed(errors.toString());
    }


}
