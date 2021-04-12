package ro.fasttrackit.homework6.products.exceptions;

import lombok.Value;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductControllerAdvice {

    @ExceptionHandler(ResourceNotFoundException.class)
    ApiError handleResourceNotFoundException(ResourceNotFoundException exception) {
        return new ApiError(404, exception.getMessage());
    }
}

@Value
class ApiError {
    int code;
    String message;
}
