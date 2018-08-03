package com.yl.sql;

import com.yl.sql.able.*;
import com.yl.sql.able.Groupable;
import com.yl.sql.able.Joinable;
import com.yl.sql.able.Unionable;
import com.yl.sql.able.Whereable;

import java.util.function.Supplier;

/**
 * Select * from table [group by] | [union] | [join] | [where] | [where between] | [where in ()]
 */
public interface FromTablesSql extends SQL {

}
