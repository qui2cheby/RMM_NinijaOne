package com.project.rmm_ninjaone.model;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * Class to Save the Total Price of each month in a Year.
 */
@Getter
@Setter
@Slf4j
@ToString
@EqualsAndHashCode
@Builder
@AllArgsConstructor
public class Period {
    private Integer monthNumber;
    private BigDecimal value;

    public Period() {}
}
