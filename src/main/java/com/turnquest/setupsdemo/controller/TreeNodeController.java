package com.turnquest.setupsdemo.controller;

import com.turnquest.setupsdemo.service.TreeNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/tree")
public class TreeNodeController {

    private final TreeNodeService treeNodeService;

    @Autowired
    public TreeNodeController(TreeNodeService treeNodeService) {
        this.treeNodeService = treeNodeService;
    }

    @GetMapping("/product-options-hierarchy")
    public List<Map<String, Object>> getProductOptionsHierarchy(@RequestParam String claType) {
        return treeNodeService.getProductOptionsHierarchy(claType);
    }

    @GetMapping("/prem-rates-tables")
    @Cacheable(value = "premRatesTablesTreeNode")
    public List<Map<String, Object>> getPremRatesTablesTreeNode(@RequestParam String claType) {
        return treeNodeService.getPremRatesTablesTreeNode(claType);
    }
}