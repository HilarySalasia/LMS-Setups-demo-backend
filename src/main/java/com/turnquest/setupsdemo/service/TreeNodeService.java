package com.turnquest.setupsdemo.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface TreeNodeService {

    List<Map<String, Object>> getProductOptionsHierarchy(String claType);

    List<Map<String, Object>> getPremRatesTablesTreeNode(String claType);
}
