package com.system.model;

import java.util.UUID;

public interface Identifiable {
    UUID getId();
    boolean equals(Identifiable obj);
}
