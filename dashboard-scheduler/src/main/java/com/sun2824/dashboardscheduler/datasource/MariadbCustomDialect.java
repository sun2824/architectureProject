package com.sun2824.dashboardscheduler.datasource;

import org.hibernate.dialect.MariaDB103Dialect;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.StandardBasicTypes;

public class MariadbCustomDialect extends MariaDB103Dialect {

    public MariadbCustomDialect(){
        super();
        registerFunction(
                "json_value",
                new StandardSQLFunction("json_value", StandardBasicTypes.STRING)
        );
    }
}
