package com.project.rmm_ninjaone.response;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
@Builder
public class Response {
    private Object datos;
    private Integer codigo;
    private String mensaje;
}
