package com.system.util;

import com.system.model.Identifiable;

import java.util.List;
import java.util.UUID;

public class IdFunctions {
    public static <T extends Identifiable> UUID uniqueId(List<T> list){
        UUID uuid;
        List<UUID> listId = list.stream()
                .map(Identifiable::getId)
                .toList();

        do {
            uuid = UUID.randomUUID();
        } while (listId.contains(uuid));

        return uuid;
    }
}
