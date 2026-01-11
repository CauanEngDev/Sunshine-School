package com.cauandev.model;

import java.util.UUID;

/**
 * Interface pra garantir que as classes que a implementam tenham um Getter e um
 * equals com base no Id
 */
public interface Identifiable {
    UUID getId();
    boolean equals(Identifiable obj);
}
