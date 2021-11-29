package br.com.letscode.starwars.config.handler;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ErrorResponse {

    private List<String> errors;
}
