package com.yl.sql;

public final class ParametersUtil {

    public static final String[][] columns = {{"id", "name", "sex", "phone"}, {"id", "name", "code"}};
    public static final String[][] wrongColumns = {{"id", "name", "sex", "phone"}};
    public static final String[][] alias = {{"userId", "userName", "userSex", "userPhone"}, {"roleId", "roleName", "roleCode"}};
    public static final String[][] wrongAlias = {{"userId", "userName", "userSex", "userPhone"}};
    public static final String[] tables = {"user", "role"};
    public static final String[] wrongTables = {"user"};
    public static final String[][] groups = {{"user", "id"}, {"user", "name"}, {"role", "id"}};

}
