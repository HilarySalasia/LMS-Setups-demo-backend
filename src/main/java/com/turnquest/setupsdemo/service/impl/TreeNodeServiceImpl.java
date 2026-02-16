package com.turnquest.setupsdemo.service.impl;

import com.turnquest.setupsdemo.dto.*;
import com.turnquest.setupsdemo.service.*;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TreeNodeServiceImpl implements TreeNodeService {
    private final LmsProductService lmsProductService;
    private final LmsProdOptionsService lmsProdOptionsService;
    private final PremiumMaskService premiumMaskService;
    private final OptBenefitService optBenefitService;
    public TreeNodeServiceImpl(
            LmsProductService lmsProductService,
            LmsProdOptionsService lmsProdOptionsService,
            PremiumMaskService premiumMaskService,
            OptBenefitService optBenefitService
    ) {
        this.lmsProductService = lmsProductService;
        this.lmsProdOptionsService = lmsProdOptionsService;
        this.premiumMaskService = premiumMaskService;
        this.optBenefitService = optBenefitService;
    }

    @Override
    public List<Map<String, Object>> getProductOptionsHierarchy(String claType) {

        // Fetch all product options
        List<ProductCodeDescDto> products = findProductCodeDescDtoData(claType);
        List<Map<String, Object>> rootNode = new ArrayList<>();
        for (ProductCodeDescDto productCodeDescDto : products) {
            // Create the root node
            Map<String, Object> productNode = new HashMap<>();
            productNode.put("code", productCodeDescDto.getProdCode());
            productNode.put("name", productCodeDescDto.getProdDesc());
            productNode.put("level", 0);
            productNode.put("expandable", true);


            List<Map<String, Object>> childrenList = new ArrayList<>();
            List<ProdOptionCodeDescDTO> prodOptionCodeDescDTOS = lmsProdOptionsService
                    .findPopCodeAndPopDescByPopProdCode(productCodeDescDto.getProdCode());
            // Add each product option as a child node
            for (ProdOptionCodeDescDTO prodOptionCodeDescDTO : prodOptionCodeDescDTOS) {
                Map<String, Object> childNode = new HashMap<>();
                childNode.put("code", prodOptionCodeDescDTO.getPopCode());
                childNode.put("name", prodOptionCodeDescDTO.getPopDesc());
                childNode.put("level", 1);
                childNode.put("expandable", false);
                System.out.println("ChildNode: " + childNode);
                childrenList.add(childNode);
            }
            System.out.println(productCodeDescDto.getProdCode());

            productNode.put("children", childrenList);

            rootNode.add(productNode);
        }

        return rootNode;

    }

    @Override
    public List<Map<String, Object>> getPremRatesTablesTreeNode(String claType) {

        // Fetch all product options
        List<ProductCodeDescDto> products = findProductCodeDescDtoData(claType);
        List<Map<String, Object>> rootNode = new ArrayList<>();
        for (ProductCodeDescDto productCodeDescDto : products) {
            // Create the root node
            Map<String, Object> productNode = new HashMap<>();
            productNode.put("code", productCodeDescDto.getProdCode());
            productNode.put("name", productCodeDescDto.getProdDesc());
            productNode.put("level", 0);
            productNode.put("expandable", true);

            List<Map<String, Object>> childrenList1 = new ArrayList<>();
            List<PremiumMaskCodeDescDTO> premiumMaskCodeDescDTOS = premiumMaskService
                    .findPremiumMaskTreeDetails(
                            productCodeDescDto.getProdCode(),claType);
            // Add each product option as a child node
            for (PremiumMaskCodeDescDTO premiumMaskCodeDescDTO : premiumMaskCodeDescDTOS) {
                Map<String, Object> childNode = new HashMap<>();
                childNode.put("code", premiumMaskCodeDescDTO.getPmasCode());
                childNode.put("name", premiumMaskCodeDescDTO.getPmasDesc());
                childNode.put("level", 1);
                childNode.put("expandable", false);
                System.out.println("ChildNode: " + childNode);

                List<Map<String, Object>> childrenList2 = new ArrayList<>();
                List<OptionBenefitPopCodePopDescOpbCodeDto> prodOptionCodeDescDTOS = optBenefitService
                        .findProdOptionDetailsByProdCode(productCodeDescDto.getProdCode());
                System.out.println("Data: " + prodOptionCodeDescDTOS+ " " +premiumMaskCodeDescDTO.getPmasProdCode());
                // Add each product option as a child node
                for (OptionBenefitPopCodePopDescOpbCodeDto optBen : prodOptionCodeDescDTOS) {
                    Map<String, Object> childNode1 = new HashMap<>();
                    childNode1.put("code", optBen.getPopCode());
                    childNode1.put("name", optBen.getPopDesc());
                    childNode1.put("level", 2);
                    childNode1.put("expandable", false);
                    System.out.println("ChildNode: " + childNode1);

                    List<Map<String, Object>> childrenList3 = new ArrayList<>();
                    List<CoverTypeDetailsDTO> coverTypeDetailsDTOS = optBenefitService
                            .findCoverTypesDetailsByPopCodeAndObpCode(BigDecimal.valueOf(optBen.getPopCode()));
                    // Add each product option as a child node
                    for (CoverTypeDetailsDTO coverTypeDetail : coverTypeDetailsDTOS) {
                        Map<String, Object> childNode2 = new HashMap<>();
                        childNode2.put("code", coverTypeDetail.getPctCode());
                        childNode2.put("name", coverTypeDetail.getCvtDesc());
                        childNode2.put("level", 3);
                        childNode2.put("expandable", false);
                        childrenList3.add(childNode2);
                    }
                    childNode1.put("children", childrenList3);
                    childrenList2.add(childNode1);
                }
                childNode.put("children", childrenList2);
                childrenList1.add(childNode);
            }
            productNode.put("children", childrenList1);

            rootNode.add(productNode);
        }

        return rootNode;
    }

    private  List<ProductCodeDescDto> findProductCodeDescDtoData(String claType) {
        return lmsProductService.findProdCodeAndProdDescByLmsClasses_claType(claType);
    }
}
