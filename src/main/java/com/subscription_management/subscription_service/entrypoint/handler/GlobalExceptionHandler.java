package com.subscription_management.subscription_service.entrypoint.handler;

import com.subscription_management.subscription_service.core.domain.exception.CustomerNotFoundException;
import com.subscription_management.subscription_service.core.domain.exception.InvalidSubscriptionOperationException;
import com.subscription_management.subscription_service.core.domain.exception.PlanNotFoundException;
import com.subscription_management.subscription_service.core.domain.exception.SubscriptionNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jmx.export.metadata.ManagedOperation;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(SubscriptionNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleSubscriptionNotFound(SubscriptionNotFoundException ex){
        return buildErrorResponse(
                HttpStatus.NOT_FOUND,
                "Subscription not found",
                ex.getMessage()
        );
    }

    @ExceptionHandler(PlanNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handlePlanNotFound(PlanNotFoundException ex){
        return buildErrorResponse(
                HttpStatus.NOT_FOUND,
                "Plan not found",
                ex.getMessage()
        );
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleCustomerNotFound(CustomerNotFoundException ex){
        return buildErrorResponse(
                HttpStatus.NOT_FOUND,
                "Customer not found",
                ex.getMessage()
        );
    }

    @ExceptionHandler(InvalidSubscriptionOperationException.class)
    public ResponseEntity<Map<String, Object>> handleInvalidOperation(
            InvalidSubscriptionOperationException ex){
        return buildErrorResponse(
                HttpStatus.BAD_REQUEST,
                "Invalid Subscription Operation",
                ex.getMessage()
        );
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> handleIllegalArgument(IllegalArgumentException ex){
        return buildErrorResponse(
                HttpStatus.BAD_REQUEST,
                "Invalid Argument",
                ex.getMessage()
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGenericException(Exception ex){
        return buildErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Internal Server Error",
                ex.getMessage()
        );
    }

    private ResponseEntity<Map<String, Object>> buildErrorResponse(HttpStatus status, String error,
                                                                   String messsage){
        Map<String, Object> body = Map.of(
                "timestamp", LocalDateTime.now(),
                "status", status.value(),
                "error", error,
                "message", messsage
        );

        return ResponseEntity.status(status).body(body);
    }

}
