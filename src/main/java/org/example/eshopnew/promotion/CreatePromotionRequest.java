package org.example.eshopnew.promotion;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CreatePromotionRequest(
        String code,
        String discountType,
        BigDecimal value,
        LocalDateTime validUntil
) {
}
