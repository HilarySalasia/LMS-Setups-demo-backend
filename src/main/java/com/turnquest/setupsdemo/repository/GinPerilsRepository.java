package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.dto.PerilDto;
import com.turnquest.setupsdemo.model.GinPerils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GinPerilsRepository extends JpaRepository<GinPerils, Long> {
    @Query(nativeQuery = true,
            value = "SELECT p.per_code sp_per_code, p.per_sht_desc sp_per_sht_desc, p.per_desc, " +
                    "       p.peril_type sp_peril_type, p.peril_limit sp_peril_limit, " +
                    "       p.si_or_limit sp_si_or_limit, p.excess, p.excess_type, p.peril_lvl, " +
                    "       p.peril_code, NULL per_amount, " +
                    "       CASE p.si_or_limit " +
                    "           WHEN 'SI' THEN 'Risk Sum Insured' " +
                    "           WHEN 'SL' THEN 'Section SI/Limit' " +
                    "           WHEN 'PL' THEN 'Peril Limit' " +
                    "           WHEN 'UL' THEN 'Unlimited' " +
                    "           ELSE p.si_or_limit " +
                    "       END si_or_limit, " +
                    "       p.ssprm_code, p.mainperil, p.uwrate " +
                    "FROM ( " +
                    "   SELECT prspr.prspr_per_code per_code, " +
                    "           prspr.prspr_per_sht_desc per_sht_desc, c.per_desc, " +
                    "           prspr.prspr_peril_type peril_type, " +
                    "           prspr.prspr_peril_limit peril_limit, " +
                    "           prspr.prspr_si_or_limit si_or_limit, prspr.prspr_excess excess, " +
                    "           prspr.prspr_excess_type excess_type, " +
                    "           prspr.prspr_mandatory mandatory, prspr.prspr_sec_code sec_code, " +
                    "           prspr.prspr_excess_min excess_min, " +
                    "           prspr.prspr_excess_max excess_max, " +
                    "           prspr.prspr_expire_on_claim expire_on_claim, " +
                    "           prspr.prspr_person_limit person_limit, " +
                    "           prspr.prspr_claim_limit claim_limit, 'R' peril_lvl, " +
                    "           prspr.prspr_code peril_code, prspr.prspr_ssprm_code ssprm_code, " +
                    "           d.per_code mainperil, prspr.prspr_prem_rate uwrate " +
                    "   FROM gin_pol_risk_section_perils prspr " +
                    "   JOIN gin_perils c ON prspr.prspr_per_code = c.per_code " +
                    "   JOIN gin_perils d ON d.per_code = b.ssprm_per_code " +
                    "   JOIN gin_sections s ON prspr.prspr_sec_code = s.sect_code " +
                    "   JOIN gin_subcl_sction_perils_map a ON prspr.prspr_ssprm_code = a.ssprm_code " +
                    "   JOIN gin_subcl_sction_perils_map b ON a.ssprm_code = b.ssprm_code " +
                    "   WHERE s.sect_type <> 'CB' " +
                    "       AND b.ssprm_per_type = 'P' " +
                    "       AND prspr.prspr_pol_batch_no = :polBatchNo " +
                    "       AND prspr.prspr_ipu_code = :ipuCode " +
                    "   UNION ALL " +
                    "   SELECT pspr.pspr_per_code per_code, " +
                    "           pspr.pspr_per_sht_desc per_sht_desc, c.per_desc, " +
                    "           pspr.pspr_peril_type peril_type, " +
                    "           pspr.pspr_peril_limit peril_limit, " +
                    "           pspr.pspr_si_or_limit si_or_limit, pspr.pspr_excess excess, " +
                    "           pspr.pspr_excess_type excess_type, " +
                    "           pspr.pspr_mandatory mandatory, pspr.pspr_sec_code sec_code, " +
                    "           pspr.pspr_excess_min excess_min, " +
                    "           pspr.pspr_excess_max excess_max, " +
                    "           pspr.pspr_expire_on_claim expire_on_claim, " +
                    "           pspr.pspr_person_limit person_limit, " +
                    "           pspr.pspr_claim_limit claim_limit, 'P' peril_lvl, " +
                    "           pspr.pspr_code peril_code, pspr.pspr_ssprm_code ssprm_code, " +
                    "           c.per_code mainperil, NULL uwrate " +
                    "   FROM gin_policy_section_perils pspr " +
                    "   JOIN gin_perils c ON pspr.pspr_per_code = c.per_code " +
                    "   WHERE pspr.pspr_pol_batch_no = :polBatchNo " +
                    "       AND pspr.pspr_sspr_code NOT IN ( " +
                    "           SELECT prspr.prspr_sspr_code " +
                    "           FROM gin_pol_risk_section_perils prspr " +
                    "           WHERE prspr.prspr_pol_batch_no = :polBatchNo " +
                    "               AND prspr.prspr_ipu_code = :ipuCode " +
                    "       ) " +
                    "   UNION ALL " +
                    "   SELECT sspr.sspr_per_code per_code, " +
                    "           sspr.sspr_per_sht_desc per_sht_desc, c.per_desc, " +
                    "           sspr.sspr_peril_type peril_type, " +
                    "           sspr.sspr_peril_limit peril_limit, " +
                    "           sspr.sspr_si_or_limit si_or_limit, sspr.sspr_excess excess, " +
                    "           sspr.sspr_excess_type excess_type, " +
                    "           sspr.sspr_mandatory mandatory, sspr.sspr_sec_code sec_code, " +
                    "           sspr.sspr_excess_min excess_min, " +
                    "           sspr.sspr_excess_max excess_max, " +
                    "           sspr.sspr_expire_on_claim expire_on_claim, " +
                    "           sspr.sspr_person_limit person_limit, " +
                    "           sspr.sspr_claim_limit claim_limit, 'S' peril_lvl, " +
                    "           sspr.sspr_code peril_code, sm.ssprm_code ssprm_code, " +
                    "           c.per_code mainperil, NULL uwrate " +
                    "   FROM gin_subcl_sction_perils sspr " +
                    "   JOIN gin_perils c ON sspr.sspr_per_code = c.per_code " +
                    "   JOIN gin_subcl_sction_perils_map sm ON sspr.sspr_code = sm.ssprm_sspr_code " +
                    "   JOIN gin_insured_property_unds ipu ON sm.ssprm_scl_code = ipu.ipu_sec_scl_code " +
                    "                                    AND sm.ssprm_bind_code = ipu.ipu_bind_code " +
                    "   JOIN gin_policy_insured_limits pil ON ipu.ipu_code = pil.pil_ipu_code " +
                    "                                    AND sm.ssprm_sect_code = pil.pil_sect_code " +
                    "   JOIN gin_sections s ON sm.ssprm_sect_code = s.sect_code " +
                    "   WHERE sspr.sspr_code NOT IN ( " +
                    "           SELECT prspr.prspr_sspr_code " +
                    "           FROM gin_pol_risk_section_perils prspr " +
                    "           WHERE prspr.prspr_pol_batch_no = :polBatchNo " +
                    "               AND prspr.prspr_ipu_code = :ipuCode " +
                    "       ) " +
                    "       AND sspr.sspr_code NOT IN ( " +
                    "           SELECT pspr.pspr_sspr_code " +
                    "           FROM gin_policy_section_perils pspr " +
                    "           WHERE pspr.pspr_pol_batch_no = :polBatchNo " +
                    "       ) " +
                    "       AND ipu.ipu_code = :ipuCode " +
                    ") p " +
                    "WHERE p.peril_lvl = :perilLvl AND p.peril_code = :perilCode"
    )
    List<PerilDto> findPerilsByPerilLvlAndPerilCode(@Param("perilLvl") String perilLvl, @Param("perilCode") Long perilCode,
                                                    @Param("polBatchNo") Long polBatchNo, @Param("ipuCode") Long ipuCode);
}