package org.example.eshopnew.promotion;

import org.mapstruct.Mapping;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PromotionMapper {

    @Mapping(target = "id", ignore = true)
    Promotion toEntity(CreatePromotionRequest request);

    @Mapping(target = "id", ignore = true)
    Promotion toEntity(UpdatePromotionRequest request);
}
