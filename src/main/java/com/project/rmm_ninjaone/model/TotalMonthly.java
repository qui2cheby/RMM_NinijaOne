package com.project.rmm_ninjaone.model;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

/**
 * Class to Group by Services name with
 * a list of Months.
 */
@Getter
@Setter
@Slf4j
@ToString
@EqualsAndHashCode
@Builder
@AllArgsConstructor
public class TotalMonthly {
    private String name;
    private List<Period> periods;

    public TotalMonthly() {     }
}
