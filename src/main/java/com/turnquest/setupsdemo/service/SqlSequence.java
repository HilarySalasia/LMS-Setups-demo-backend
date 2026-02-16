package com.turnquest.setupsdemo.service;

public interface SqlSequence {
    Long getNextClaimNumberSequenceValue();

    Long getNextCrpcCodeSequenceValue();
    Long generateRegClmtCode();
    Long getSequenceUsingSequenceName(String sequenceName);
    String generateDivNo();
    Long getNextGGTTransactionSequenceValue();
    public String getTQCParamNumber(String paramName);
}
