package com.yl.sql;

import com.yl.sql.imp.SelectSqlImp;

public interface SqlBuilder {

    static public SelectSql buildSelectSql() {
        return new SelectSqlImp();
    }

}
