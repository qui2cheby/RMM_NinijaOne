package com.project.rmm_ninjaone.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;

@JsonAutoDetect
@Builder
@Table(name = "service")
@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
public class ServiceDTO {
    public ServiceDTO() {    }

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "service_name", unique = true)
    @JsonProperty
    private String serviceName;

    @Column(name = "price")
    @JsonProperty
    public BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "idDevice", referencedColumnName = "id",  nullable = false)
    @JsonProperty
    public Device idDevice;
}
