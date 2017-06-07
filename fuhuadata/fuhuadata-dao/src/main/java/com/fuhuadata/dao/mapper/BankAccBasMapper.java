package com.fuhuadata.dao.mapper;

import com.fuhuadata.domain.common.BankAccBas;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BankAccBasMapper extends BaseMapper<BankAccBas, Integer> {

    List<BankAccBas> listBankAccs(@Param("accType") short accType, @Param("customerId") Integer customerId);
}