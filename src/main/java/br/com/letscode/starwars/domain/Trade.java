package br.com.letscode.starwars.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Trade {

    private Rebel rebelRequester;

    private Rebel rebelReceiver;
}
