package br.com.letscode.starwars.controller.translator;

import br.com.letscode.starwars.controller.request.LocateRequest;
import br.com.letscode.starwars.domain.Locate;
import br.com.letscode.starwars.mapper.RebelMapper;
import lombok.experimental.UtilityClass;

@UtilityClass
public class LocateRequestToLocate {
    public Locate translate(final LocateRequest request) {
        return RebelMapper.INSTANCE.locateRequestToLocate(request);
    }
}
