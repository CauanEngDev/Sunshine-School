package com.cauandev.util;

import com.cauandev.model.Identifiable;

import java.util.List;
import java.util.UUID;

/**
 * Classe de funções referentes ao Id
 */
public class IdFunctions {

    /**
     * Função que cria e verifica novos Ids únicos
     * @param list lista de instâncias que implementam a interface Identifiable
     * @return retorna o novo Id após verificação
     * @param <T> tipo da lista que garante que toas as instâncias implementam Identifiable
     */
    public static <T extends Identifiable> UUID uniqueId(List<T> list){
        UUID uuid;
        // Cria um lista de Ids únicos através do stream
        List<UUID> listId = list.stream()
                .map(Identifiable::getId)
                .toList();

        do {
            uuid = UUID.randomUUID();
            //Não sai do while se o Id já tiver sido criado
        } while (listId.contains(uuid));

        return uuid;
    }
}
