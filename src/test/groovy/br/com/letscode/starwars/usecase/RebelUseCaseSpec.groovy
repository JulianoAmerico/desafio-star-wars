package br.com.letscode.starwars.usecase

import br.com.letscode.starwars.domain.*
import br.com.letscode.starwars.repository.RebelRepository
import spock.lang.Specification

class RebelUseCaseSpec extends Specification {
    RebelRepository rebelRepository = Mock(RebelRepository)
    RebelUseCase rebelUseCase = new RebelUseCase(rebelRepository)

    def "It should add rebel with success"() {
        given: "a valid rebel"
        def rebel = getRebel()

        when: "use case add rebel is called"
        def rebelAdded = rebelUseCase.addRebel(rebel)

        then: "repository save with sucess"
        rebelRepository.save(_ as Rebel) >> {
            getRebelWithIds()
        }

        and: "assert rebel"
        getRebelWithIds().id == rebelAdded.id
    }

    static def getRebel() {
        return Rebel.builder()
                .age(18)
                .gender(Gender.MASCULINO)
                .inventory(Inventory.builder()
                        .items(List.of(Item.builder().name("Comida").point(1).build()))
                        .build())
                .locate(Locate.builder().latitude("1234").longitude("5678").build())
                .build()
    }

    static def getRebelWithIds() {
        return Rebel.builder()
                .id(1)
                .age(18)
                .gender(Gender.MASCULINO)
                .inventory(Inventory.builder()
                        .id(1)
                        .items(List.of(Item.builder()
                                .id(1)
                                .name("Comida")
                                .point(1).build()))
                        .build())
                .locate(Locate.builder()
                        .id(1)
                        .latitude("1234")
                        .longitude("5678")
                        .build())
                .build()
    }
}
