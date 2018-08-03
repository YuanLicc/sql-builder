package com.yl.sql.imp;

import com.yl.sql.JoinOnTableAliasSql;
import com.yl.sql.JoinOnTableSql;

public class JoinOnTableSqlImp implements JoinOnTableSql {

    public JoinOnTableAliasSql aliasJoinTables(String... alias) {

        return new JoinOnTableAliasSqlImp();
    }

}
