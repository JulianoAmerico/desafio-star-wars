package br.com.letscode.starwars.controller.translator;

import br.com.letscode.starwars.controller.response.RebelResponse;
import br.com.letscode.starwars.domain.Rebel;
import br.com.letscode.starwars.mapper.RebelMapper;
import lombok.experimental.UtilityClass;

@UtilityClass
public class RebelToRebelResponse {

    public RebelResponse translate(final Rebel rebel) {
        return RebelMapper.INSTANCE.rebelToRebelResponse(rebel);
    }
}
