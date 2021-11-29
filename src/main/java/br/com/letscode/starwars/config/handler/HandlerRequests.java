package br.com.letscode.starwars.config.handler;

import br.com.letscode.starwars.usecase.exception.UseCaseException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class HandlerRequests {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleCustomFieldsValidationException(final MethodArgumentNotValidException exception) {
        final var errors = exception.getBindingResult()
                .getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        return ErrorResponse.builder().errors(errors).build();
    }

    @ExceptionHandler({UseCaseException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse constraintException(final UseCaseException exception) {
        return ErrorResponse.builder()
                .errors(List.of(exception.getMessage()))
                .build();
    }
}
