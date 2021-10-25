package com.example.demo.exception;

import com.example.demo.model.responseModel.ResponseToUser;
import org.dom4j.rule.Mode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Calendar;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    ResponseEntity<?> springAuthException(SpringAuthenticationException e){
        ResponseToUser response = new ResponseToUser("Authentication Exception", e.getMessage(), e.getErrorCode(), HttpStatus.NOT_ACCEPTABLE, Calendar.getInstance().getTime());
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler
    ResponseEntity<?> customException(CustomException e){
        ResponseToUser response = new ResponseToUser("Simple Exception", e.getError().name(), e.getErrorCode(), HttpStatus.NOT_ACCEPTABLE, Calendar.getInstance().getTime());
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler
    String emailValException(ConstraintViolationException e, Model model) {
        model.addAttribute("error", "INVALID_EMAIL");
        return "signup";
    }

    @ExceptionHandler
    ResponseEntity<?> sqlException(SQLException e){
        ResponseToUser response = new ResponseToUser("MySQL Exception", e.getMessage(), e.getErrorCode(), HttpStatus.NOT_ACCEPTABLE, Calendar.getInstance().getTime());
        return ResponseEntity.badRequest().body(response);
    }
}
