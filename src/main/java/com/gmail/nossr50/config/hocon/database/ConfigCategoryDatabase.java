package com.gmail.nossr50.config.hocon.database;

import ninja.leaping.configurate.objectmapping.Setting;
import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;

@ConfigSerializable
public class ConfigCategoryDatabase {

    @Setting(value = "User_Name", comment = "The authorized user for your MySQL/MariaDB DB")
    private String username;

    @Setting(value = "User_Password", comment = "The password for your authorized user")
    private String password;

    @Setting(value = "Database_Name", comment = "The database name for your DB, this DB must already exist on the SQL server.")
    private String databaseName;

    @Setting(value = "Table_Prefix", comment = "The Prefix that will be used for tables in your DB")
    private String tablePrefix;
}
