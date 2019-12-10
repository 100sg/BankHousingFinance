package skbaek.homework.demo.Exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import skbaek.homework.demo.domain.ApiResponseVO;

import javax.servlet.http.HttpServletRequest;
import java.net.ConnectException;

@Slf4j
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SomeExceptionHandler {

    @ExceptionHandler(ConnectException.class)
    @ResponseBody
    public ResponseEntity<?> handleException(HttpServletRequest request, ConnectException ex) {
        ApiResponseVO res = new ApiResponseVO();
        res.setResultFAIL(null);
        res.setReason(ex.getMessage());
        res.setStatus("DB Disconnection");
        log.error("Exception request path : {}", request.getRequestURI());
        log.error("Exception Error : {}", ex.getMessage());
        return ResponseEntity.ok(res);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<?> handleException(HttpServletRequest request, Exception ex) {
        ApiResponseVO res = new ApiResponseVO();
        res.setResultFAIL(null);
        res.setReason(ex.getMessage());
        log.error("Exception request path : {}", request.getRequestURI());
        log.error("Exception Error : {}", ex.getMessage());
        return ResponseEntity.ok(res);
    }

}
