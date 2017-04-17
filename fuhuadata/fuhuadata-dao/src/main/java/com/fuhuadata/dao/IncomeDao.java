package com.fuhuadata.dao;

import com.fuhuadata.domain.Income;

/**
 * Created by hexingfu on 2017/4/17.
 */
public interface IncomeDao  {

    Income getByCode(String code);
}
