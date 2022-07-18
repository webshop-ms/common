package com.webshop.common.model.model.entity;

import com.webshop.common.transformer.UuidGenerator;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@MappedSuperclass
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Identity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "uuid", unique = true, updatable = false)
    @GeneratorType(type = UuidGenerator.class, when = GenerationTime.INSERT)
    @Type(type = "uuid-char")
    private UUID uuid;
}
