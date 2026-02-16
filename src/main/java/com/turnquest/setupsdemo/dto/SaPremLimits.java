package com.turnquest.setupsdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaPremLimits {
    private int psplMinPrem;
    private Double psplMinContri;
    private Double psplMaxPrem;
    private Double psplMaxContri;
    private Double psplMinSa;
    private Double psplMaxSa;
}
