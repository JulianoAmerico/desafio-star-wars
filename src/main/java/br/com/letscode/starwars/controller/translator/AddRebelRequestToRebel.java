package br.com.letscode.starwars.controller.translator;

import br.com.letscode.starwars.controller.request.AddRebelRequest;
import br.com.letscode.starwars.domain.Rebel;
import br.com.letscode.starwars.mapper.RebelMapper;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AddRebelRequestToRebel {

    public Rebel translate(final AddRebelRequest request) {
        return RebelMapper.INSTANCE.addRebelRequestToRebel(request);
    }
}
