package com.project.rmm_ninjaone.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@JsonAutoDetect
@Builder
@Table(name = "ledger", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Ledger {
    public Ledger() {    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idService", referencedColumnName = "id",  nullable = false)
    @JsonProperty
    public ServiceDTO idService;

    @Column(name = "unit_price")
    public BigDecimal unitPrice;

    @Column(name = "total_price")
    public BigDecimal totalPrice;

    @Column(name = "quantity")
    @JsonProperty
    public Integer quantity;

    @Column(name = "created")
    public LocalDateTime created;

    @JsonProperty @Transient public Integer year;
}
