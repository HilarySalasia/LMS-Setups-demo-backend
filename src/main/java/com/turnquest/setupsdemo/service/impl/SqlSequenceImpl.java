package com.turnquest.setupsdemo.service.impl;

import com.turnquest.setupsdemo.repository.TqcParametersRepository;
import com.turnquest.setupsdemo.service.SqlSequence;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

@Service
@AllArgsConstructor
public class SqlSequenceImpl implements SqlSequence {

    private DataSource dataSource;
    @PersistenceContext
    private EntityManager entityManager;

    private final TqcParametersRepository tqcParametersRepository;

//    gin_crpc_code_seq.NEXTVAL
    public Long getNextClaimNumberSequenceValue() {
        Long nextSequenceValue = null;
        try (Connection conn = dataSource.getConnection();
             CallableStatement stmt = conn.prepareCall("{call gin_sequences_pkg.get_next_value(?, ?)}")) {
            stmt.setString(1, "C"); // Sequence name or identifier
            stmt.registerOutParameter(2, Types.NUMERIC);
            stmt.execute();
            nextSequenceValue = stmt.getLong(2);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving next claim number sequence value", e);
        }
        return nextSequenceValue;
    }

    public Long getNextCrpcCodeSequenceValue() {
        Long nextSequenceValue = null;
        try (Connection conn = dataSource.getConnection();
             CallableStatement stmt = conn.prepareCall("{call gin_crpc_code_seq.NEXTVAL()}")) {
//            stmt.setString(1, "C"); // Sequence name or identifier
//            stmt.registerOutParameter(2, Types.NUMERIC);
            stmt.execute();
            nextSequenceValue = stmt.getLong(2);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving next claim number sequence value", e);
        }
        return nextSequenceValue;
    }

    public Long getSequenceUsingSequenceName(String sequenceName) {
        Query query = entityManager.createNativeQuery("SELECT " + sequenceName + ".NEXTVAL FROM DUAL");
        return (Long) query.getSingleResult();
    }

    public Long generateRegClmtCode() {
        // Use a named query to fetch the next value from the sequence
        String sequenceName = "gin_clmt_code_seq"; // Replace with the actual sequence name
        Query query = entityManager.createNativeQuery("SELECT " + sequenceName + ".NEXTVAL FROM DUAL");
        return (Long) query.getSingleResult();
    }

    public String generateDivNo() {
        // Use a named query to fetch the next value from the sequence
        String sequenceName = "gin_div_no_seq"; // Replace with the actual sequence name
        Query query = entityManager.createNativeQuery("SELECT " + sequenceName + ".NEXTVAL FROM DUAL");
        Long divNo = (Long) query.getSingleResult();
        return String.format("%06d", divNo); // Format as a 6-digit string
    }

    public Long getNextGGTTransactionSequenceValue() {
        // Implement logic to fetch the next sequence value from the database or external service
        // Example using JDBC:
        Long nextSequenceValue = null;
        try (Connection conn = dataSource.getConnection();
             CallableStatement stmt = conn.prepareCall("{call ggt_trans_no_seq.nextval}")) {
            stmt.execute();
            nextSequenceValue = stmt.getLong(1);
        } catch (SQLException e) {
            // Handle exceptions appropriately
            throw new RuntimeException("Error retrieving next sequence value", e);
        }
        return nextSequenceValue;
    }

    public String getTQCParamNumber(String paramName) {

        return tqcParametersRepository.findParamValueByParamName(paramName);
    }
}