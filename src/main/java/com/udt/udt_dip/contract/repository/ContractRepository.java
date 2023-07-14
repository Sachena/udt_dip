package com.udt.udt_dip.contract.repository;

import com.udt.udt_dip.contract.domain.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface ContractRepository {

    Contract findById(String id);

    void save(Contract contract);
}
