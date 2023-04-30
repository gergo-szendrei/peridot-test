package hu.gergo.szendrei.peridot.shared.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import hu.gergo.szendrei.peridot.shared.exception.dto.CustomRuntimeExceptionDto;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler
	public ResponseEntity<String> handleException(CustomRuntimeExceptionDto e) {
        e.getOriginalException().printStackTrace();
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler
	public ResponseEntity<String> handleException(Exception e) {
        e.printStackTrace();
		return new ResponseEntity<String>("Something went wrong!", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
