package com.project.rmm_ninjaone.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import javax.persistence.*;

@JsonAutoDetect
@Builder
@Table(name = "device")
@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Device {
    public Device() { }

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "system_name", unique = true)
    @JsonProperty
    private String system_name;

    @Column(name = "type")
    @JsonProperty
    private String type;

}
