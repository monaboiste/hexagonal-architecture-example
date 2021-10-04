package com.github.monaboiste.domain.order.port.shared;

/**
 * Food order state representation. Enums are sorted by
 * order's lifecycle: from creation (NEW) to delivery (DELIVERED).
 */
public enum FoodOrderState {

    NEW,
    SENT_TO_RESTAURANT,
    ON_THE_WAY,
    DELIVERED
}
