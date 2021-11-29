package br.com.letscode.starwars.mapper;

import br.com.letscode.starwars.controller.request.AddRebelRequest;
import br.com.letscode.starwars.controller.request.LocateRequest;
import br.com.letscode.starwars.controller.response.RebelResponse;
import br.com.letscode.starwars.domain.Locate;
import br.com.letscode.starwars.domain.Rebel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RebelMapper {

    RebelMapper INSTANCE = Mappers.getMapper(RebelMapper.class);

    @Mapping(target = "id", ignore = true)
    Rebel addRebelRequestToRebel(final AddRebelRequest request);

    RebelResponse rebelToRebelResponse(final Rebel rebel);

    @Mapping(target = "id", ignore = true)
    Locate locateRequestToLocate(final LocateRequest request);
}
