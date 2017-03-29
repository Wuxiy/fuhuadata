package com.fuhuadata.dao;

import com.fuhuadata.domain.BCode;
import com.fuhuadata.domain.query.QueryBCode;

import java.sql.SQLException;
import java.util.List;

public interface BCodeDao {

    int insertBcode(BCode record);

    BCode getBcodeByQuery(QueryBCode queryBCode);

    int setCurrentVal(BCode record);
}