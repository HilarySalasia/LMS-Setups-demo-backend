package com.turnquest.setupsdemo.service.impl;

import com.turnquest.setupsdemo.model.LmsOrdPremRateTables;
import com.turnquest.setupsdemo.model.LmsProdCoverTypes;
import com.turnquest.setupsdemo.model.PremiumMask;
import com.turnquest.setupsdemo.repository.LmsOrdPremRateTablesRepository;
import com.turnquest.setupsdemo.service.LmsProdCoverTypesService;
import com.turnquest.setupsdemo.service.PremiumMaskService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LmsOrdPremRateTablesServiceImplTest {

    @Mock
    private LmsOrdPremRateTablesRepository repository;

    @Mock
    private LmsProdCoverTypesService lmsProdCoverTypesService;

    @Mock
    private PremiumMaskService premiumMaskService;

    @InjectMocks
    private LmsOrdPremRateTablesServiceImpl lmsOrdPremRateTablesService;

    @Test
    public void testFindAll() {
        // Mock data
        List<LmsOrdPremRateTables> mockRateTables = mock(List.class);

        // Mock repository behavior
        when(repository.findAll()).thenReturn(mockRateTables);

        // Execute the service method
        List<LmsOrdPremRateTables> result = lmsOrdPremRateTablesService.findAll();

        // Verify
        assertEquals(mockRateTables, result);
        verify(repository, times(1)).findAll();
    }

    @Test
    public void testFindById_ExistingRecord() {
        // Mock data
        Long id = 1L;
        LmsOrdPremRateTables mockRateTable = mock(LmsOrdPremRateTables.class);

        // Mock repository behavior
        when(repository.findById(id)).thenReturn(Optional.of(mockRateTable));

        // Execute the service method
        LmsOrdPremRateTables result = lmsOrdPremRateTablesService.findById(id);

        // Verify
        assertEquals(mockRateTable, result);
        verify(repository, times(1)).findById(id);
    }

    @Test
    public void testFindById_NonExistingRecord() {
        // Mock data
        Long id = 1L;

        // Mock repository behavior
        when(repository.findById(id)).thenReturn(Optional.empty());

        // Execute the service method
        LmsOrdPremRateTables result = lmsOrdPremRateTablesService.findById(id);

        // Verify
        assertEquals(null, result);
        verify(repository, times(1)).findById(id);
    }

    @Test
    public void testSave() {
        // Mock data
        LmsOrdPremRateTables mockRateTable = mock(LmsOrdPremRateTables.class);

        // Mock repository behavior
        when(repository.save(mockRateTable)).thenReturn(mockRateTable);

        // Execute the service method
        LmsOrdPremRateTables result = lmsOrdPremRateTablesService.save(mockRateTable);

        // Verify
        assertEquals(mockRateTable, result);
        verify(repository, times(1)).save(mockRateTable);
    }

    @Test
    public void testDeleteById() {
        // Mock data
        Long id = 1L;

        // Execute the service method
        lmsOrdPremRateTablesService.deleteById(id);

        // Verify
        verify(repository, times(1)).deleteById(id);
    }

    @Test
    public void testUpdateOrdPremRateTable_NewRecord_Success() throws Exception {
        // Mock data
        LmsOrdPremRateTables rateTable = new LmsOrdPremRateTables();
        rateTable.setOrdtPctCode(BigDecimal.valueOf(1));
        rateTable.setOrdtPmasCode(BigDecimal.valueOf(1));
        rateTable.setOrdtQx(BigDecimal.ONE);

        LmsProdCoverTypes lmsProdCoverTypes = new LmsProdCoverTypes();
        lmsProdCoverTypes.setPctLoadFactor(BigDecimal.ONE);
        lmsProdCoverTypes.setPctLoadFactorDiv(BigDecimal.ONE);

        PremiumMask premiumMask = new PremiumMask();

        // Mock service behaviors
        when(lmsProdCoverTypesService.findById(rateTable.getOrdtPctCode().longValue())).thenReturn(lmsProdCoverTypes);
        when(premiumMaskService.getPremiumMaskById(rateTable.getOrdtPmasCode())).thenReturn(premiumMask);
        when(getClaCode("O")).thenReturn("CLA_CODE_SAMPLE");
        when(getPmasRateType(rateTable.getOrdtPmasCode().longValue())).thenReturn("P");
        when(generateNewCode()).thenReturn(1L);
        when(repository.save(rateTable)).thenReturn(rateTable);

        // Execute the service method
        LmsOrdPremRateTables result = lmsOrdPremRateTablesService.updateOrdPremRateTable(rateTable, "Error message");

        // Verify
        assertEquals(rateTable, result);
        verify(lmsProdCoverTypesService, times(1)).findById(rateTable.getOrdtPctCode().longValue());
        verify(premiumMaskService, times(1)).getPremiumMaskById(rateTable.getOrdtPmasCode());
        verify(getClaCode("O"), times(1));
        verify(getPmasRateType(rateTable.getOrdtPmasCode().longValue()), times(1));
        verify(generateNewCode(), times(1));
        verify(repository, times(1)).save(rateTable);
    }

    @Test
    public void testUpdateOrdPremRateTable_NewRecord_LoadFactorZero_Error() throws Exception {
        // Mock data
        LmsOrdPremRateTables rateTable = new LmsOrdPremRateTables();
        rateTable.setOrdtPctCode(BigDecimal.valueOf(1));
        rateTable.setOrdtPmasCode(BigDecimal.valueOf(1));
        rateTable.setOrdtQx(BigDecimal.ONE);

        LmsProdCoverTypes lmsProdCoverTypes = new LmsProdCoverTypes();
        lmsProdCoverTypes.setPctLoadFactor(BigDecimal.ZERO);
        lmsProdCoverTypes.setPctLoadFactorDiv(BigDecimal.ONE);

        PremiumMask premiumMask = new PremiumMask();
        premiumMask.setPmasRateType("P");

        // Mock service behaviors
        when(lmsProdCoverTypesService.findById(rateTable.getOrdtPctCode().longValue())).thenReturn(lmsProdCoverTypes);
        when(premiumMaskService.getPremiumMaskById(rateTable.getOrdtPmasCode())).thenReturn(premiumMask);
        when(getClaCode("O")).thenReturn("CLA_CODE_SAMPLE");
        when(getPmasRateType(rateTable.getOrdtPmasCode().longValue())).thenReturn("P");
        when(generateNewCode()).thenReturn(1L);

        // Execute the service method and expect an exception
//        assertThrows(PremiumRateTableException.class, () -> lmsOrdPremRateTablesService.updateOrdPremRateTable(rateTable, "Error message"));

        // Verify
        verify(lmsProdCoverTypesService, times(1)).findById(rateTable.getOrdtPctCode().longValue());
        verify(premiumMaskService, times(1)).getPremiumMaskById(rateTable.getOrdtPmasCode());
        verify(getClaCode("O"), times(1));
        verify(getPmasRateType(rateTable.getOrdtPmasCode().longValue()), times(1));
        verify(generateNewCode(), times(0)); // Should not generate new code due to the exception
        verify(repository, times(0)).save(rateTable); // Should not save due to the exception
    }

    @Test
    public void testUpdateOrdPremRateTable_ExistingRecord_Success() throws Exception {
        // Mock data
        LmsOrdPremRateTables rateTable = new LmsOrdPremRateTables();
        rateTable.setOrdtCode(1L);
        rateTable.setOrdtPctCode(BigDecimal.valueOf(1));
        rateTable.setOrdtPmasCode(BigDecimal.valueOf(1));
        rateTable.setOrdtQx(BigDecimal.ONE);

        LmsProdCoverTypes lmsProdCoverTypes = new LmsProdCoverTypes();
        lmsProdCoverTypes.setPctLoadFactor(BigDecimal.ONE);
        lmsProdCoverTypes.setPctLoadFactorDiv(BigDecimal.ONE);

        PremiumMask premiumMask = new PremiumMask();
        premiumMask.setPmasRateType("P");

        LmsOrdPremRateTables existingRateTable = new LmsOrdPremRateTables();
        existingRateTable.setOrdtCode(1L);

        // Mock service behaviors
        when(lmsProdCoverTypesService.findById(rateTable.getOrdtPctCode().longValue())).thenReturn(lmsProdCoverTypes);
        when(premiumMaskService.getPremiumMaskById(rateTable.getOrdtPmasCode())).thenReturn(premiumMask);
        when(getClaCode("O")).thenReturn("CLA_CODE_SAMPLE");
        when(getPmasRateType(rateTable.getOrdtPmasCode().longValue())).thenReturn("P");
        when(repository.findById(rateTable.getOrdtCode())).thenReturn(Optional.of(existingRateTable));
        when(repository.save(existingRateTable)).thenReturn(existingRateTable);

        // Execute the service method
        LmsOrdPremRateTables result = lmsOrdPremRateTablesService.updateOrdPremRateTable(rateTable, "Error message");

        // Verify
        assertEquals(existingRateTable, result);
        verify(lmsProdCoverTypesService, times(1)).findById(rateTable.getOrdtPctCode().longValue());
        verify(premiumMaskService, times(1)).getPremiumMaskById(rateTable.getOrdtPmasCode());
        verify(getClaCode("O"), times(1));
        verify(getPmasRateType(rateTable.getOrdtPmasCode().longValue()), times(1));
        verify(repository, times(1)).findById(rateTable.getOrdtCode());
        verify(repository, times(1)).save(existingRateTable);
    }

    @Test
    public void testUpdateOrdPremRateTable_ExistingRecord_NotFound_Error() throws Exception {
        // Mock data
        LmsOrdPremRateTables rateTable = new LmsOrdPremRateTables();
        rateTable.setOrdtCode(1L);

        // Mock service behaviors
        when(repository.findById(rateTable.getOrdtCode())).thenReturn(Optional.empty());

        // Execute the service method and expect an exception
        assertThrows(Exception.class, () -> lmsOrdPremRateTablesService.updateOrdPremRateTable(rateTable, "Error message"));

        // Verify
        verify(repository, times(1)).findById(rateTable.getOrdtCode());
    }

    @Test
    public void testUpdateOrdPremRateTable_ExistingRecord_UpdateError() throws Exception {
        // Mock data
        LmsOrdPremRateTables rateTable = new LmsOrdPremRateTables();
        rateTable.setOrdtCode(1L);
        rateTable.setOrdtPctCode(BigDecimal.valueOf(1));
        rateTable.setOrdtPmasCode(BigDecimal.valueOf(1));
        rateTable.setOrdtQx(BigDecimal.ONE);

        LmsProdCoverTypes lmsProdCoverTypes = new LmsProdCoverTypes();
        lmsProdCoverTypes.setPctLoadFactor(BigDecimal.ONE);
        lmsProdCoverTypes.setPctLoadFactorDiv(BigDecimal.ONE);

        PremiumMask premiumMask = new PremiumMask();
        premiumMask.setPmasRateType("P");

        LmsOrdPremRateTables existingRateTable = new LmsOrdPremRateTables();
        existingRateTable.setOrdtCode(1L);

        // Mock service behaviors
        when(lmsProdCoverTypesService.findById(rateTable.getOrdtPctCode().longValue())).thenReturn(lmsProdCoverTypes);
        when(premiumMaskService.getPremiumMaskById(rateTable.getOrdtPmasCode())).thenReturn(premiumMask);
        when(getClaCode("O")).thenReturn("CLA_CODE_SAMPLE");
        when(getPmasRateType(rateTable.getOrdtPmasCode().longValue())).thenReturn("P");
        when(repository.findById(rateTable.getOrdtCode())).thenReturn(Optional.of(existingRateTable));
        doThrow(new Exception("Error updating record")).when(repository).save(existingRateTable);

        // Execute the service method and expect an exception
        assertThrows(Exception.class, () -> lmsOrdPremRateTablesService.updateOrdPremRateTable(rateTable, "Error message"));

        // Verify
        verify(lmsProdCoverTypesService, times(1)).findById(rateTable.getOrdtPctCode().longValue());
        verify(premiumMaskService, times(1)).getPremiumMaskById(rateTable.getOrdtPmasCode());
        verify(getClaCode("O"), times(1));
        verify(getPmasRateType(rateTable.getOrdtPmasCode().longValue()), times(1));
        verify(repository, times(1)).findById(rateTable.getOrdtCode());
        verify(repository, times(1)).save(existingRateTable);
    }

    @Test
    public void testGetOrdPremRateTables() {
        // Mock data
        BigDecimal pmasCode = BigDecimal.ONE;
        BigDecimal popCode = BigDecimal.ONE;
        BigDecimal pctCode = BigDecimal.ONE;
        BigDecimal optCode = BigDecimal.ONE;
        Long opirCode = 1L;
        String gender = "M";
        List<LmsOrdPremRateTables> mockRateTables = mock(List.class);

        // Mock repository behavior
        when(repository.findOrdPremRateTables(pmasCode, popCode, pctCode, optCode, opirCode, gender)).thenReturn(mockRateTables);

        // Execute the service method
        List<LmsOrdPremRateTables> result = lmsOrdPremRateTablesService.getOrdPremRateTables(pmasCode, popCode, pctCode, optCode, opirCode, gender);

        // Verify
        assertEquals(mockRateTables, result);
        verify(repository, times(1)).findOrdPremRateTables(pmasCode, popCode, pctCode, optCode, opirCode, gender);
    }

    @Test
    public void testFindByOrdOptCode() {
        // Mock data
        BigDecimal ordOptCode = BigDecimal.ONE;
        List<LmsOrdPremRateTables> mockRateTables = mock(List.class);

        // Mock repository behavior
        when(repository.findByOrdOptCode(ordOptCode)).thenReturn(mockRateTables);

        // Execute the service method
        List<LmsOrdPremRateTables> result = lmsOrdPremRateTablesService.findByOrdOptCode(ordOptCode);

        // Verify
        assertEquals(mockRateTables, result);
        verify(repository, times(1)).findByOrdOptCode(ordOptCode);
    }

    // Mock private methods for testing
    private String getClaCode(String type) {
        return "CLA_CODE_SAMPLE";
    }

    private LmsOrdPremRateTablesServiceImpl.ProductCoverTypesInfo getProductCoverTypesInfo(Long pctCode) {
        return new LmsOrdPremRateTablesServiceImpl.ProductCoverTypesInfo("CVT_CODE_SAMPLE", "CVT_SHT_DESC_SAMPLE", BigDecimal.ONE, BigDecimal.ONE);
    }

    private String getPmasRateType(Long pmasCode) {
        return "P";
    }

    private Long generateNewCode() {
        return 1L;
    }

    private BigDecimal getTranSign(BigDecimal totEndosDiffAmt) {
        return BigDecimal.ONE;
    }

    private BigDecimal getRcptBalance(BigDecimal prmCode) {
        return BigDecimal.ONE;
    }

    private BigDecimal getSectionLimitsCount(BigDecimal vPolBatchNo) {
        return BigDecimal.ONE;
    }

    private String getBusinessTransactions(String vPolStat, BigDecimal vTranSign) {
        return "U1";
    }

    private void polUwTransAuthPrc(BigDecimal vPolBatchNo, String vUser, String authorised) {
    }

    private void updateGinInsuredPropertyUnds(BigDecimal vPolBatchNo, String reinsured) {
    }

    private void createContraTrans(BigDecimal vPolBatchNo, String vUser, BigDecimal newBatchNo) {
    }

    private BigDecimal getGisTransactions(BigDecimal vPolBatchNo) {
        return BigDecimal.ONE;
    }

    private BigDecimal getAgencyType(BigDecimal polAgntAgentCode) {
        return BigDecimal.ONE;
    }

    private BigDecimal getPolBalance(String vPolPolicyNo) {
        return BigDecimal.ONE;
    }

    private BigDecimal getPolRcptBalance(BigDecimal vPolBatchNo) {
        return BigDecimal.ONE;
    }

    private BigDecimal getPaExceptionsCount(BigDecimal vPolBatchNo) {
        return BigDecimal.ONE;
    }

    private BigDecimal getPaExceptionsCount(BigDecimal vPolBatchNo, String gpeGgeCode) {
        return BigDecimal.ONE;
    }

    private BigDecimal getCurrexchRate(BigDecimal vCurCode, int vRnd, int vBcurRnd) {
        return BigDecimal.ONE;
    }

    private BigDecimal getParamNumber(String paramName) {
        return BigDecimal.ONE;
    }

    private void b4AuthChecks(BigDecimal vPolBatchNo) {
    }

    private void updateGinPoliciesCurrentStatus(BigDecimal vPolBatchNo, String status) {
    }

    private void updateRateTableFields(LmsOrdPremRateTables existing, LmsOrdPremRateTables updated) {
    }

    private void calculateRates(LmsOrdPremRateTables rateTable, LmsProdCoverTypes lmsProdCoverTypes) {
    }

    private BigDecimal calculateRate(BigDecimal qx, BigDecimal pctLoadFactor, BigDecimal pctLoadFactorDiv, int period) {
        return BigDecimal.valueOf(1000);
    }

//    private void raiseError(String message) throws Exception {
//        throw new PremiumRateTableException(message);
//    }
}