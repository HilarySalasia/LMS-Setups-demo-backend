package com.turnquest.setupsdemo.service.impl;

import com.turnquest.setupsdemo.dto.*;
import com.turnquest.setupsdemo.model.*;
import com.turnquest.setupsdemo.repository.*;
import com.turnquest.setupsdemo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;

@Service
public class ClaimCreationServiceImpl implements ClaimCreationService {

    private final GinClaimMasterBookingsService ginClaimMasterBookingsService;

    private final GinClaimCoinsurersRepository claimCoinsurersRepository;

    private final GinInsuredPropertyUndsRepository insuredPropertyUndsRepository;

    private final GinPolicyRiskSectionPerilsRepository policyRiskSectionPerilsRepository;

    private final GinClaimPerilExcessesTempRepository claimPerilExcessesRepository;

    private final GinClaimPerilsRepository claimPerilsRepository;
    private final GinGisTransactionsRepository gisTransactionsRepository;
    private final GinClaimRevisionsRepository claimRevisionsRepository;
    private final GinFileMasterRepository fileMasterRepository;

    private final SqlSequence sqlSequence;
    private final GinPolicyService ginPolicyService;
    private final GinInsuredPropertyUndsService ginInsuredPropertyUndsService;
    private final GinEventsService ginEventsService;
    private final GinCatastrophesService ginCatastrophesService;
    private final GinPolicySbuDtlsService ginPolicySbuDtlsService;
    private final GinPolicyCertsService ginPolicyCertsService;
    private final GinCoinsurersService ginCoinsurersService;
    private final PrcMapGroupedrsksPrcService prcMapGroupedrsksPrcService;
    private final CreateRiCessionsService createRiCessionsService;
    private final PerilLimitService perilLimitService;
    private final GinClaimPerilsTempRepository claimPerilsTempRepository;
    private final GinPerilService ginPerilService;
    private final GinClaimantService ginClaimantService;

    private final RevisionService revisionService;

    public ClaimCreationServiceImpl(GinClaimMasterBookingsService ginClaimMasterBookingsService,
                                    GinClaimCoinsurersRepository claimCoinsurersRepository,
                                    GinInsuredPropertyUndsRepository insuredPropertyUndsRepository,
                                    GinPolicyRiskSectionPerilsRepository policyRiskSectionPerilsRepository,
                                    GinClaimPerilExcessesRepository claimPerilExcessesRepository,
                                    GinClaimPerilsRepository claimPerilsRepository,
                                    GinGisTransactionsRepository gisTransactionsRepository,
                                    GinClaimRevisionsRepository claimRevisionsRepository,
                                    GinFileMasterRepository fileMasterRepository,
                                    SqlSequence sqlSequence,
                                    GinPolicyService ginPolicyService,
                                    GinInsuredPropertyUndsService ginInsuredPropertyUndsService,
                                    GinEventsService ginEventsService,
                                    GinCatastrophesService ginCatastrophesService,
                                    GinPolicySbuDtlsService ginPolicySbuDtlsService,
                                    GinPolicyCertsService ginPolicyCertsService,
                                    GinCoinsurersService ginCoinsurersService,
                                    PrcMapGroupedrsksPrcService prcMapGroupedrsksPrcService,
                                    CreateRiCessionsService createRiCessionsService,
                                    PerilLimitService perilLimitService,
                                    GinClaimPerilsTempRepository claimPerilsTempRepository,
                                    GinPerilService ginPerilService,
                                    GinClaimantService ginClaimantService,
                                    RevisionService revisionService) {
        this.ginClaimMasterBookingsService = ginClaimMasterBookingsService;
        this.claimCoinsurersRepository = claimCoinsurersRepository;
        this.insuredPropertyUndsRepository = insuredPropertyUndsRepository;
        this.policyRiskSectionPerilsRepository = policyRiskSectionPerilsRepository;
        this.claimPerilExcessesRepository = claimPerilExcessesRepository;
        this.claimPerilsRepository = claimPerilsRepository;
        this.gisTransactionsRepository = gisTransactionsRepository;
        this.claimRevisionsRepository = claimRevisionsRepository;
        this.fileMasterRepository = fileMasterRepository;
        this.sqlSequence = sqlSequence;
        this.ginPolicyService = ginPolicyService;
        this.ginInsuredPropertyUndsService = ginInsuredPropertyUndsService;
        this.ginEventsService = ginEventsService;
        this.ginCatastrophesService = ginCatastrophesService;
        this.ginPolicySbuDtlsService = ginPolicySbuDtlsService;
        this.ginPolicyCertsService = ginPolicyCertsService;
        this.ginCoinsurersService = ginCoinsurersService;
        this.prcMapGroupedrsksPrcService = prcMapGroupedrsksPrcService;
        this.createRiCessionsService = createRiCessionsService;
        this.perilLimitService = perilLimitService;
        this.claimPerilsTempRepository = claimPerilsTempRepository;
        this.ginPerilService = ginPerilService;
        this.ginClaimantService = ginClaimantService;
        this.revisionService = revisionService;
    }

    // Add other required repositories here

    // Add service for handling external packages and procedures
    @Autowired
    private ExternalPackageService externalPackageService;

    @Override
    public ClaimCreationResponse createNewClaim(ClaimCreationRequest request) {
        GinPolicies policy = ginPolicyService.getPolicyData(request.getIpuCode(), request.getPolBatchNo());
        GinInsuredPropertyUnds insuredProperty = ginInsuredPropertyUndsService.getGinInsuredPropertyUndsByIpuCode(
                request.getIpuCode()
        ).orElse(null);
        GinPolicySbuDtls policySbuDtls = ginPolicySbuDtlsService.getPolicySbuDetails(
                request.getIpuCode(),
                request.getPolBatchNo()
        );
        // 1. Validate input parameters
        validateInput(request);

        // 2. Generate a new claim number
        String claimNumber = ginClaimMasterBookingsService.generateClaimNumber(request);

        // 3. Create a new claim record in gin_claim_master_bookings
        GinClaimMasterBookings claimMasterBooking = createClaimMasterBooking(request, claimNumber);
        ginClaimMasterBookingsService.save(claimMasterBooking);

        // 4. Create related records in gin_claim_coinsurers
        createClaimCoinsurers(request, claimNumber);

        // 5. Handle related risks
        handleRelatedRisks(request, claimNumber);

        // 6. Process reinsurance cessions
        processReinsuranceCessions(request, claimNumber, policy, insuredProperty, policySbuDtls);

        // 7. Manage claim perils and claimants
        manageClaimPerilsAndClaimants(request, claimNumber, insuredProperty);

        // 8. Record claim transaction
        recordClaimTransaction(request, claimNumber);

        // 9. Create claim revisions
        createClaimRevisions(request, claimNumber);

        // 10. Handle total loss scenarios
        handleTotalLoss(request, claimNumber);

        // 11. Generate alerts
        generateAlerts(claimNumber);

        // 12. Update calendar activity
        updateCalendarActivity(request, claimNumber);

        // 13. Create claim file
        createClaimFile(claimNumber);

        // 14. Populate mandatory documents and statuses
        populateMandatoryDocumentsAndStatuses(claimNumber);

        // 15. Create claim notification details
        createClaimNotificationDetails(claimNumber);

        // 16. Clean up temporary data
        cleanupTemporaryData(request);

        // Prepare response
        ClaimCreationResponse response = new ClaimCreationResponse();
        response.setClaimNumber(claimNumber);
        return response;
    }

    private void validateInput(ClaimCreationRequest request) {
        // 1. Check for required fields
        if (request.getIpuCode() == null) {
            throw new IllegalArgumentException("IPU Code is required");
        }
        if (request.getPolBatchNo() == null) {
            throw new IllegalArgumentException("Policy Batch Number is required");
        }
        if (request.getClmReportDate() == null) {
            throw new IllegalArgumentException("Claim Report Date is required");
        }
        // ... Add checks for other required fields

        // 2. Validate data types
        if (request.getIpuCode() <= 0) {
            throw new IllegalArgumentException("IPU Code must be a positive number");
        }
        if (request.getPolBatchNo() <= 0) {
            throw new IllegalArgumentException("Policy Batch Number must be a positive number");
        }
        if (request.getCasCode() != null && request.getCasCode() <= 0) {
            throw new IllegalArgumentException("Case Code must be a positive number");
        }
        if (request.getSerial() != null && request.getSerial() <= 0) {
            throw new IllegalArgumentException("Serial Number must be a positive number");
        }
        if (request.getPerilCode() != null && request.getPerilCode() <= 0) {
            throw new IllegalArgumentException("Peril Code must be a positive number");
        }
        if (request.getPerilAmnt() != null && request.getPerilAmnt().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Peril Amount must be a positive number");
        }
        if (request.getEveCode() != null && request.getEveCode() <= 0) {
            throw new IllegalArgumentException("Event Code must be a positive number");
        }
        if (request.getCataCode() != null && request.getCataCode() <= 0) {
            throw new IllegalArgumentException("Catastrophe Code must be a positive number");
        }
        if (request.getBasicSal() != null && request.getBasicSal().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Basic Salary must be a positive number");
        }
        if (request.getAvgEarnings() != null && request.getAvgEarnings().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Average Earnings must be a positive number");
        }
        // ... Add checks for other data types

        // 3. Validate data ranges
        if (request.getCoinPayFull() != null && !request.getCoinPayFull().equalsIgnoreCase("O") &&
                !request.getCoinPayFull().equalsIgnoreCase("F")) {
            throw new IllegalArgumentException("Coin Pay Full must be 'O' or 'F'");
        }
        if (request.getNoRi() != null && !request.getNoRi().equalsIgnoreCase("N") &&
                !request.getNoRi().equalsIgnoreCase("Y")) {
            throw new IllegalArgumentException("No RI must be 'N' or 'Y'");
        }
        if (request.getSelfAsClmant() != null && !request.getSelfAsClmant().equalsIgnoreCase("N") &&
                !request.getSelfAsClmant().equalsIgnoreCase("Y")) {
            throw new IllegalArgumentException("Self as Claimant must be 'N' or 'Y'");
        }
        if (request.getLiabilityAdmtd() != null && !request.getLiabilityAdmtd().equalsIgnoreCase("N") &&
                !request.getLiabilityAdmtd().equalsIgnoreCase("Y")) {
            throw new IllegalArgumentException("Liability Admitted must be 'N' or 'Y'");
        }
        // ... Add checks for other data ranges

        // 4. Perform custom validation
        if (request.getCmbTentativeLossDate() != null) {
            try {
                LocalDate lossDate = LocalDate.parse(request.getCmbTentativeLossDate());

                if (lossDate.isAfter(LocalDate.now())) {
                    throw new IllegalArgumentException("Loss Date cannot be in the future");
                }
            } catch (DateTimeParseException e) {
                throw new IllegalArgumentException("Invalid date format for Tentative Loss Date");
            }
        }

        // Custom validation for Offduty dates
        if (request.getOffdutyWefDt() != null && request.getOffdutyWetDt() != null) {
            if (request.getOffdutyWefDt().isAfter(request.getOffdutyWetDt())) {
                throw new IllegalArgumentException("Offduty 'Wet' Date cannot be before 'Wef' Date");
            }
        }

        // Custom validation for Claim Report Date and Loss Date
        if (request.getClmReportDate() != null && request.getCmbTentativeLossDate() != null) {
            try {
                // Convert the String to LocalDate
                LocalDate lossDate = LocalDate.parse(request.getCmbTentativeLossDate());

                // Perform the comparison
                if (request.getClmReportDate().isBefore(lossDate)) {
                    throw new IllegalArgumentException("Claim Report Date cannot be before Loss Date");
                }
            } catch (DateTimeParseException e) {
                throw new IllegalArgumentException("Invalid date format for Tentative Loss Date");
            }
        }

        // 5. Check for existing claims based on specific criteria
        boolean existingClaim = checkExistingClaim(request);
        if (existingClaim) {
            throw new IllegalArgumentException("An existing claim already exists for this criteria");
        }

        // ... Add more validation checks as needed
    }



    private GinClaimMasterBookings createClaimMasterBooking(ClaimCreationRequest request, String claimNumber) {
        GinPolicies policy = ginPolicyService.getPolicyData(request.getIpuCode(), request.getPolBatchNo());
        GinInsuredPropertyUnds insuredProperty = ginInsuredPropertyUndsService.getGinInsuredPropertyUndsByIpuCode(
                request.getIpuCode()
        ).orElse(null);
        GinPolicySbuDtls policySbuDtls = ginPolicySbuDtlsService.getPolicySbuDetails(
                request.getIpuCode(),
                request.getPolBatchNo()
        );
        // 1. Create a new GinClaimMasterBookings object
        GinClaimMasterBookings claimMasterBooking = new GinClaimMasterBookings();

        // 2. Set fields based on request and claim number
        claimMasterBooking.setCmbClaimNo(claimNumber);
        claimMasterBooking.setCmbClaimDate(Date.valueOf(LocalDate.now()));
        claimMasterBooking.setCmbLossDateTime(Date.valueOf(request.getClmReportDate()));
        claimMasterBooking.setCmbSclCode(request.getIpuCode());
        claimMasterBooking.setCmbPolPolicyNo(policy.getPolPolicyNo());
        claimMasterBooking.setCmbPolRenEndosNo(policy.getPolRenEndosNo());
        claimMasterBooking.setCmbPolBatchNo(request.getPolBatchNo());
        claimMasterBooking.setCmbPrpCode(policy.getPolPrpCode());
        claimMasterBooking.setCmbIpuCode(request.getIpuCode());
        claimMasterBooking.setCmbIpuPropertyId(insuredProperty != null ? insuredProperty.getIpuPropertyId() : null);
        claimMasterBooking.setCmbPolClientPolicyNo(policy.getPolClientPolicyNumber());
        claimMasterBooking.setCmbIpuId(insuredProperty != null ? insuredProperty.getIpuId() : null);
        claimMasterBooking.setCmbProCode(policy.getPolProCode());
        claimMasterBooking.setCmbTime(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
        claimMasterBooking.setCmbClaimStatus("B"); // Assuming initial status is 'B'
        claimMasterBooking.setCmbLopAuthorised("N");
        claimMasterBooking.setCmbRejected("N");
        claimMasterBooking.setCmbIpuPolinCode(insuredProperty != null ? insuredProperty.getIpuPolinCode() : null);
        claimMasterBooking.setCmbCurCode(policy.getPolCurCode());
        claimMasterBooking.setCmbCurSymbol(policy.getPolCurSymbol());
        claimMasterBooking.setCmbAgntAgentCode(policy.getPolAgntAgentCode());
        claimMasterBooking.setCmbUwYear(policy.getPolUwYear());
        claimMasterBooking.setCmbProShtDesc(policy.getPolProShtDesc());
        claimMasterBooking.setCmbPolInceptUwyr(policy.getPolInceptionUwyr());
        claimMasterBooking.setCmbStatusDate(Date.valueOf(LocalDate.now()));
        claimMasterBooking.setCmbEveCode(request.getEveCode());
        claimMasterBooking.setCmbEveShtDesc(ginEventsService.getEveShtDesc(request.getEveCode()));
        claimMasterBooking.setCmbCoinsurance(request.getCoinPayFull().equals("F") ? "Y" : "N");
        claimMasterBooking.setCmbBookedBy(request.getUser());
        claimMasterBooking.setCmbBookedDate(Date.valueOf(LocalDate.now()));
        claimMasterBooking.setCmbAdmitLiability(request.getLiabilityAdmtd().equals("Y") ? "Y" : "N");
        claimMasterBooking.setCmbNextReviewDt(request.getNextRevDate() != null ? Date.valueOf(LocalDate.parse(request.getNextRevDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))) : null);
        claimMasterBooking.setCmbCatCode(request.getCataCode());
        claimMasterBooking.setCmbCatShtDesc(ginCatastrophesService.getCataShtDesc(request.getCataCode()));
        claimMasterBooking.setCmbInsClaimNo(request.getRefNo());
        claimMasterBooking.setCmbAvrgBasicSalary(request.getBasicSal());
        claimMasterBooking.setCmbAvrgEarnings(request.getAvgEarnings());
        claimMasterBooking.setCmbOffdutyWefDt(Date.valueOf(request.getOffdutyWefDt()));
        claimMasterBooking.setCmbOffdutyWetDt(Date.valueOf(request.getOffdutyWetDt()));
        claimMasterBooking.setCmbPrdIncapacity(request.getOffdutyWetDt().toEpochDay() - request.getOffdutyWefDt().toEpochDay() + 1);
        claimMasterBooking.setCmbTpRecover(request.getTp());
        claimMasterBooking.setCmbPriorityLvl(request.getCmbPriorityLvl());
        claimMasterBooking.setCmbLocation(request.getCmbLocation());
        claimMasterBooking.setCmbUnitCode(policySbuDtls != null ? policySbuDtls.getPdlUnitCode() : null);
        claimMasterBooking.setCmbLocationCode(policySbuDtls != null ? policySbuDtls.getPdlLocationCode() : null);
        claimMasterBooking.setCmbVehOnmotion(request.getCmbVehOnmotion());
        claimMasterBooking.setCmbCertificateNumber(ginPolicyCertsService.findByPolcIpuCodeAndPolcStatus(
                request.getIpuCode(), "A").get()
                .getPolcCerCertNo().toString());
        claimMasterBooking.setCmbTentativeLossDate(request.getCmbTentativeLossDate());

        return claimMasterBooking;
    }

    private void createClaimCoinsurers(ClaimCreationRequest request, String claimNumber) {
        // 1. Get the list of coinsurers from the external service
        List<GinClaimCoinsurers> coinsurers = ginCoinsurersService.getClaimCoinsurers(request.getPolBatchNo());

        // 2. Set the claim number for each coinsurer
        coinsurers.forEach(coinsurer -> coinsurer.setCmbClaimNo(claimNumber));

        // 3. Save the coinsurers to the database using JPA
        claimCoinsurersRepository.saveAll(coinsurers);
    }

    private void handleRelatedRisks(ClaimCreationRequest request, String claimNumber) {
        // 1. Get the related risks for the current Ipu code
        List<GinInsuredPropertyUnds> relatedRisks = ginInsuredPropertyUndsService.getRelatedRisks(request.getIpuCode());

        // 2. Check if there are any related risks
        if (!relatedRisks.isEmpty()) {
            // 3. For each related risk, check if it already has a claim for the same loss date
            relatedRisks.forEach(relatedRisk -> {
                // Use JPA to check if a claim exists for the related risk and loss date
                boolean claimExists = ginClaimMasterBookingsService.existsByIpuCodeAndLossDateTime(
                        relatedRisk.getIpuCode(),
                        request.getClmReportDate().atStartOfDay().toLocalDate()
                );

                // If no claim exists, create a new claim for the related risk
                if (!claimExists) {
                    // Create a new claim for the related risk using the external package service
                    String relatedClaimNumber = ginClaimMasterBookingsService.createRelatedClaim(
                            relatedRisk.getIpuCode(),
                            request.getClmReportDate(),
                            request.getUser()
                    );

                    // Link the related claim to the current claim using the external service
//                    externalPackageService.linkRelatedClaims(claimNumber, relatedClaimNumber);
                    prcMapGroupedrsksPrcService.prcMapGroupedrsksPrc(
                            request.getClmReportDate().toString(),
                            BigDecimal.valueOf(relatedRisk.getIpuRelrCode()),
                            BigDecimal.valueOf(relatedRisk.getIpuCode()),
                            relatedClaimNumber
                    );
                }
            });
        }
    }



    private void processReinsuranceCessions(
            ClaimCreationRequest request,
            String claimNumber,
            GinPolicies policy,
            GinInsuredPropertyUnds insuredProperty,
            GinPolicySbuDtls policySbuDtls
    ) {
        createRiCessionsService.createRiCessions(
                claimNumber,
                request.getIpuCode(),
                insuredProperty.getIpuPropertyId(), // Assuming this is available in the request object
                BigDecimal.valueOf(policy.getPolUwYear()),
                BigDecimal.valueOf(insuredProperty.getIpuSecSclCode()),
                BigDecimal.valueOf(request.getPolBatchNo()),
                BigDecimal.valueOf(policy.getPolCurCode()),
                policy.getPolCurSymbol(),
                policy.getPolLoaded().equals("Y") ? "Y" : "N",
                request.getClmReportDate(),
                request.getNoRi().equals("Y") ? "Y" : "N",
                BigDecimal.valueOf(insuredProperty.getIpuCovtCode())
        );

//        // 1. Get reinsurance cession information from the external service
//        ReinsuranceCessionData cessionData = externalPackageService.getReinsuranceCessionData(request.getIpuCode(), request.getPolBatchNo(), request.getClmReportDate());
//
//        // 2. Check if reinsurance cession is required
//        if (cessionData != null) {
//            // 3. Process reinsurance cession using the external service
//            externalPackageService.processReinsuranceCession(claimNumber, cessionData);
//        }
    }

    private void manageClaimPerilsAndClaimants(ClaimCreationRequest request,
                                               String claimNumber,
                                               GinInsuredPropertyUnds insuredProperty) {


// ... Inside your service method ...
        List<GinClmPerilsTemp> perilsTemp = claimPerilsTempRepository.findAllByCptGrpCode(request.getPerilCode());
        perilsTemp.forEach(temp -> {
            PerilLimitResponse perilLimitResp = perilLimitService.getPerilLimits(
                    temp.getCptPerilCode().longValue(),
                    temp.getCptPerilLevel(),
                    request.getPerilAmnt(),
                    insuredProperty.getIpuCovtCode(),
                    request.getIpuCode());
            List<GinPerils> vPerilsTab = new ArrayList<>();

            for (PerilDto perilDto : perils) {
                SclPerilsRecDto peril = new SclPerilsRecDto();

                // Map properties from the DTO to the Peril object
                peril.setSpPerCode(perilDto.getSpPerCode());
                peril.setSpPerShtDesc(perilDto.getSpPerShtDesc());
                peril.setPerDesc(perilDto.getPerDesc());
                peril.setSpPerilType(perilDto.getSpPerilType());
                peril.setSpPerilLimit(perilDto.getSpPerilLimit());
                peril.setSpSiOrLimit(perilDto.getSpSiOrLimit());
                peril.setExcess(perilDto.getExcess());
                peril.setExcessType(perilDto.getExcessType());
                peril.setPerilLvl(perilDto.getPerilLvl());
                peril.setPerilCode(perilDto.getPerilCode());
                peril.setPerAmount(perilDto.getPerAmount());
                peril.setSiOrLimit(perilDto.getSiOrLimit());
                peril.setSsprmCode(perilDto.getSsprmCode());
                peril.setMainperilcode(perilDto.getMainPeril());
                peril.setPerilUwRate(perilDto.getUwrate());


                // Set additional properties not retrieved from the repository
                peril.setPerAmount(temp.getCptPerilAmt());
                peril.setSpPerilLimit(perilLimitResp.getPLimit());
                peril.setExcess(perilLimitResp.getELimit());
                peril.setSsPrDepreciationPct(perilLimitResp.getDepRate());
                peril.setPerPaymentType(request.getPerilPayType());
                peril.setMultiplier(perilLimitResp.getMultplier());
                peril.setClmpLiabAdmission(temp.getCptLiabilityAddmission());
                peril.setClmpLiabDate(temp.getCptLiabAddmDate());
                peril.setCptCode(temp.getCptCode());

                ClaimantResponse claimantResponse = ginClaimantService.handleClaimant(
                        claimNumber,
                        request.getPerilPayType(),
                        request.getCommmode(),
                        temp.getCptLiabilityAddmission(),
                        temp.getCptThirdParty(),
                        temp.getCptPerilAmt().longValue(),
                        temp.getCptCldCode().longValue(),
                        request.getIpuCode()
                );

                peril.setClmpClaimant("Y");
                peril.setClmpRegClmtCode(BigDecimal.valueOf(claimantResponse.getRegClmtCode()));
                peril.setClmpRegCldCode(BigDecimal.valueOf(claimantResponse.getCldCode()));

                vPerilsTab.add(peril);
            }

            List<GinClaimPerilExcessesTemp> perilExcesses = claimPerilExcessesRepository
                    .findAllByCpetCptCode(temp.getCptClmpCode().longValue());
            if (!perilExcesses.isEmpty()) {
                // Save the excess records in the database
                claimPerilExcessesRepository.saveAll(perilExcesses);

                // Construct the peril excess codes string
                StringBuilder perilExcessCodes = new StringBuilder();
                for (GinClaimPerilExcessesTemp excess : perilExcesses) {
                    if (!perilExcessCodes.isEmpty()) {
                        perilExcessCodes.append(",");
                    }
                    perilExcessCodes.append(excess.getCpetCode());
                }
//                claimPeril.setClmpPerilExcessCodes(perilExcessCodes.toString()); // Assuming you have this field in GinClaimPerils
            }

            return vPerilsTab;
        });


        // 1. Retrieve claim perils from the external service


        List<PerilDto> perilDtoList = ginPerilService.findPerilsByPerilLvlAndPerilCode(
                request.getPerilLvl(),
                request.getPerilCode(),
                request.getPolBatchNo(),
                request.getIpuCode());


    }

//        List<PerilDto> perils = perilService.getPerils(curPerilsTemp.getCptPerilLevel(),
//                curPerilsTemp.getCptPerilCode(),
//                polBatchNo, ipuCode);
//
//        // 2. Process each claim peril
//        perilsTemp.forEach(claimPeril -> {
//            // 2.1 Set the claim number and other related fields
//            claimPeril.setCptC(claimNumber);
//            claimPeril.setClmpLiabAdmission(request.getClnmtLiabAdm().equals("Y") ? "Y" : "N");
//            claimPeril.setClmpLiabDate(request.getClaimNotDate());
//            claimPeril.setClmpPaymentType(request.getPerilPayType());
//            claimPeril.setClmpClaimant("Y");
//            claimPeril.setClmpRegClmtCode(externalPackageService.getClaimantCode(claimNumber, claimPeril.getClmpCldCode()));

            // 2.2 Handle Peril Excesses


//
//        // 3. Save the claim perils to the database
//        claimPerilsRepository.saveAll(claimPerils);
//
//        // 4. Create/Update claimants based on peril details
//        createOrUpdateClaimants(claimPerils, claimNumber, request);
//    }

//    private void createOrUpdateClaimants(List<GinClaimPerils> claimPerils, String claimNumber, ClaimCreationRequest request) {
//        claimPerils.forEach(claimPeril -> {
//            // Check if the claimant already exists for this claim
//            if (claimPeril.getClmpRegClmtCode() != null && claimPeril.getClmpRegClmtCode() > 0) {
//                // Claimant already exists, update the existing record
//                externalPackageService.updateClaimant(claimNumber, claimPeril.getClmpCldCode(), claimPeril.getClmpRegClmtCode(),
//                        request.getPaymode(), request.getCommmode(), claimPeril.getClmpLiabAdmission());
//            } else {
//                // Claimant doesn't exist, create a new claimant record
//                externalPackageService.createClaimant(claimNumber, claimPeril.getClmpCldCode(), request.getPaymode(),
//                        request.getCommmode(), claimPeril.getClmpLiabAdmission(), claimPeril.getClmpRegClmtCode());
//            }
//        });
//    }

    private void recordClaimTransaction(ClaimCreationRequest request, String claimNumber) {
        // 1. Create a new GinGisTransactions object
        GinGisTransactions transaction = new GinGisTransactions();
        GinPolicies policy = ginPolicyService.getPolicyData(request.getPolBatchNo(), request.getIpuCode());
        // 2. Set the transaction details
        transaction.setGgtDocRef(request.getDocRef());
        transaction.setGgtTransNo(sqlSequence.getNextGGTTransactionSequenceValue());
        transaction.setGgtPolPolicyNo(policy.getPolPolicyNo());
        transaction.setGgtCmbClaimNo(claimNumber);
        transaction.setGgtProCode(policy.getPolProCode());
        transaction.setGgtPolBatchNo(request.getPolBatchNo());
        transaction.setGgtProShtDesc(policy.getPolProShtDesc());
        transaction.setGgtBtrTransCode("LO"); // Assuming "LO" is the transaction code for claim creation
        transaction.setGgtDoneBy(request.getUser());
        transaction.setGgtDoneDate(java.util.Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        transaction.setGgtClientPolicyNumber(policy.getPolClientPolicyNumber());
        transaction.setGgtUwClmTran("C"); // Assuming "C" is the code for claim transaction
        transaction.setGgtTransDate(java.util.Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        transaction.setGgtEffectiveDate(java.util.Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));

        // 3. Save the transaction to the database
        gisTransactionsRepository.save(transaction);
    }

    private void createClaimRevisions(ClaimCreationRequest request, String claimNumber) {
        // 1. Retrieve the list of claim perils for this claim
        List<GinClaimPerils> claimPerils = claimPerilsRepository.findAllByClmpCmbClaimNo(claimNumber);

        // 2.  Create a new GinClaimRevisions object
        GinClaimRevisions claimRevision = new GinClaimRevisions();

        // 3. Set claim revision fields
        claimRevision.setClmrevCmbClaimNo(claimNumber);
        claimRevision.setClmrevGgtTransNo(externalPackageService.getNextTransactionSequenceValue());
        claimRevision.setClmrevDate(new Date(LocalDate.now().toEpochDay()));
        claimRevision.setClmrevGgtTranType("LO"); // Assuming "LO" is the revision type for claim creation
        claimRevision.setClmrevStatus("A"); // Assuming "A" is the active status for the revision
        claimRevision.setClmrevDoneBy(request.getUser());
        claimRevision.setClmrevRgcdCode(request.getRgcdCode()); // Assuming you have this data in the request
        claimRevision.setClmrevPerilExcessCodes(null); // Initialize with null and populate later
        claimRevision.setClmrevIpuCode(request.getIpuCode());
        // Set other fields as needed

        // 4. Populate peril excess codes for the claim revision
        StringBuilder perilExcessCodes = new StringBuilder();
        claimPerils.forEach(claimPeril -> {
            List<GinClaimPerilExcessesTemp> perilExcesses = claimPerilExcessesRepository.findAllByCpetCptCode(claimPeril.getClmpCode());
            if (!perilExcesses.isEmpty()) {
                perilExcesses.forEach(perilExcess -> {
                    if (perilExcessCodes.length() > 0) {
                        perilExcessCodes.append(",");
                    }
                    perilExcessCodes.append(perilExcess.getCpetCode());
                });
            }
        });
        claimRevision.setClmrevRevPerilExcessCodes(perilExcessCodes.toString());

        // 5. Save the claim revision to the database
        claimRevisionsRepository.save(claimRevision);
    }

    private void handleTotalLoss(ClaimCreationRequest request, String claimNumber) {
        // 1. Check if the claim is a total loss (based on request or external service)
        boolean isTotalLoss = request.getCoinPayFull().equalsIgnoreCase("F"); // Assuming "F" indicates a total loss in the request
        // Alternatively, you can use an external service to determine total loss:
        // boolean isTotalLoss = externalPackageService.isTotalLossClaim(request.getIpuCode(), request.getClmReportDate());

        // 2. If it's a total loss, update the claim record with the coinsurance amount
        if (isTotalLoss) {
            // Retrieve the coinsurance percentage from the external service
            BigDecimal coinsurancePercentage = externalPackageService.getCoinsurancePercentage(request.getPolBatchNo());

            // Calculate the coinsurance amount
            BigDecimal coinsuranceAmount = coinsurancePercentage.multiply(externalPackageService.getIpuValue(request.getIpuCode()));

            // Update the claim record in the database using JPA
            GinClaimMasterBookings claim = claimMasterBookingsRepository.findById(claimNumber).orElseThrow(() -> new EntityNotFoundException("Claim not found"));
            claim.setIpuValue(coinsuranceAmount);
            claimMasterBookingsRepository.save(claim);
        }
    }

    private void generateAlerts(String claimNumber) {
        // 1. Get the alert configuration for claim creation
        AlertConfiguration alertConfig = externalPackageService.getClaimCreationAlertConfig();

        // 2. Check if alerts are enabled for claim creation
        if (alertConfig.isEnabled()) {
            // 3. Get the list of users to notify
            List<String> recipients = alertConfig.getRecipients();

            // 4. Construct the alert message
            String alertMessage = String.format("New claim created: %s", claimNumber);

            // 5. Send alerts using the external alert service
            externalPackageService.sendAlerts(recipients, alertMessage);
        }
    }

    private void updateCalendarActivity(ClaimCreationRequest request, String claimNumber) {
        // 1. Get the calendar activity configuration from the external service
        CalendarActivityConfig calendarConfig = externalPackageService.getCalendarActivityConfig();

        // 2. Check if calendar activity updates are enabled
        if (calendarConfig.isEnabled()) {
            // 3.  Construct the calendar activity description
            String activityDescription = String.format("CLAIM REVIEW - %s", claimNumber);

            // 4.  Get the next review date from the request
            LocalDate nextReviewDate = request.getNextRevDate() != null ? LocalDate.parse(request.getNextRevDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) : null;

            // 5. Update the calendar activity using the external service
            externalPackageService.updateCalendarActivity(activityDescription, nextReviewDate, request.getClaimnextuserreview());
        }
    }

    private void createClaimFile(String claimNumber) {
        // 1. Check if a file record already exists for this claim
        boolean fileExists = fileMasterRepository.existsByFilmFileNo(claimNumber);

        // 2. If a file record doesn't exist, create a new file record
        if (!fileExists) {
            // Retrieve the client name from the external service
            String clientName = externalPackageService.getClientName(claimMasterBookingsRepository.findById(claimNumber).get().getPrpCode());

            // Create a new GinFileMaster object
            GinFileMaster claimFile = new GinFileMaster();
            claimFile.setFilmFileNo(claimNumber);
            claimFile.setFilmFileDesc(clientName);
            claimFile.setFilmType("U"); // Assuming "U" is the file type for claims
            claimFile.setFilmOpenDt(LocalDate.now());
            claimFile.setFilmLocation("HOME");
            claimFile.setFilmLocationDept("HOME");
            // ... (Set other fields as needed) ...

            // Save the file record to the database
            fileMasterRepository.save(claimFile);
        }
    }

    private void populateMandatoryDocumentsAndStatuses(String claimNumber) {
        // 1. Get the mandatory documents and statuses based on the claim's section code
        List<MandatoryDocumentStatus> mandatoryItems = externalPackageService.getMandatoryDocumentsAndStatuses(
                claimMasterBookingsRepository.findById(claimNumber).get().getSclCode()
        );

        // 2. Process each mandatory document and status
        mandatoryItems.forEach(item -> {
            // 2.1 Create a new GinClaimMandatoryDocuments object
            GinClaimMandatoryDocuments document = new GinClaimMandatoryDocuments();
            document.setClmdCmbClaimNo(claimNumber);
            document.setClmdDocCode(item.getDocumentCode());
            document.setClmdDocDesc(item.getDocumentDescription());
            document.setClmdStatus(item.getStatus());
            // ... (Set other fields as needed) ...

            // 2.2 Save the document record to the database
            claimMandatoryDocumentsRepository.save(document);

            // 2.3 Create a new GinClaimMandatoryStatuses object
            GinClaimMandatoryStatuses status = new GinClaimMandatoryStatuses();
            status.setClmsCmbClaimNo(claimNumber);
            status.setClmsStatusCode(item.getStatusCode());
            status.setClmsStatusDesc(item.getStatusDescription());
            // ... (Set other fields as needed) ...

            // 2.4 Save the status record to the database
            claimMandatoryStatusesRepository.save(status);
        });

        //>>> Recheck this code <<<
    }

    private void createClaimNotificationDetails(String claimNumber) {
        // 1. Get the notification configuration for claim creation
        NotificationConfig notificationConfig = externalPackageService.getClaimCreationNotificationConfig();

        // 2. Check if notifications are enabled for claim creation
        if (notificationConfig.isEnabled()) {
            // 3. Get the list of recipients
            List<String> recipients = notificationConfig.getRecipients();

            // 4. Get the claim details from the database
            GinClaimMasterBookings claim = claimMasterBookingsRepository.findById(claimNumber).orElseThrow(() -> new EntityNotFoundException("Claim not found"));

            // 5. Construct the notification message
            String notificationMessage = String.format("A new claim (%s) has been created for policy %s. \n" +
                            "Claim details: \n" +
                            "Policy Batch Number: %s \n" +
                            "Loss Date: %s \n" +
                            "Claimant: %s",
                    claimNumber,
                    claim.getPolPolicyNo(), // Assuming you have polPolicyNo in the claim object
                    claim.getPolBatchNo(),
                    claim.getLossDateTime(),
                    // ... (Add other relevant claim details as needed) ...
                    // (You might need to fetch additional details from external services or the database)
            );

            // 6. Send notifications using the external notification service
            externalPackageService.sendNotifications(recipients, notificationMessage);
        }
    }

    private void cleanupTemporaryData(ClaimCreationRequest request) {
        // 1. Delete temporary data related to the claim perils
        claimPerilExcessesRepository.deleteAllByCpetCptCodeIn(
                claimPerilsRepository.findAllByClmpCmbClaimNo(claimNumber)
                        .stream()
                        .map(GinClaimPerils::getClmpCode)
                        .collect(Collectors.toList())
        );

        // 2. Delete temporary data related to the claim process
        // (Implement based on your specific temporary data structures and requirements)
        // Example:
        // externalPackageService.deleteTemporaryData(claimNumber);
    }

    private boolean checkExistingClaim(ClaimCreationRequest request) {
        // 1. Define the criteria for checking existing claims
        // Example criteria:
        // - Ipu Code
        // - Loss Date (truncated to the date component)
        // - Policy Batch Number

        // 2. Implement the query based on the criteria
        // Example using JPQL (Java Persistence Query Language):
        LocalDate lossDate = null;

        // Convert the String cmbTentativeLossDate to LocalDate
        if (request.getCmbTentativeLossDate() != null) {
            try {
                lossDate = LocalDate.parse(request.getCmbTentativeLossDate());
            } catch (DateTimeParseException e) {
                throw new IllegalArgumentException("Invalid date format for Tentative Loss Date");
            }
        }

        // Perform repository lookup with converted LocalDate
        List<GinClaimMasterBookings> existingClaims = claimMasterBookingsRepository.findAllByIpuCodeAndLossDateTimeAndPolBatchNo(
                request.getIpuCode(),
                lossDate, // Pass the converted LocalDate
                request.getPolBatchNo()
        );

        // 3. Check if any existing claims are found
        return !existingClaims.isEmpty();
    }

    // Add helper methods for creating/handling related entities (coinsurers, perils, claimants, etc.)

}