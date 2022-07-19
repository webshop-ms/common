package com.webshop.common.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDto {

    private UUID id;

    private String name;

    private BigDecimal unitPrice;

}
