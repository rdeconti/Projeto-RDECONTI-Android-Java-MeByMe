package com.prosper.day.databasedefinition;

 /* ****************************************************************************
 /* Copyright (C) 2016 The Android Open Source Project
 /*
 /* Licensed under the Apache License, Version 2.0 (the "License");
 /* you may not use this file except in compliance with the License.
 /* You may obtain a copy of the License at
 /*
 /*     http://www.apache.org/licenses/LICENSE-2.0
 /*
 /* Unless required by applicable law or agreed to in writing, software
 /* distributed under the License is distributed on an "AS IS" BASIS,
 /* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 /* See the License for the specific language governing permissions and
 /* limitations under the License.
 /* ****************************************************************************
 /* Created by Rosemeire Deconti on 2019 / July
 /* ****************************************************************************/

public class SqliteDatabaseCommand {

    // *********************************************************************************************
    // ** Sqlite commands and attributes to be used to manage databases
    // *********************************************************************************************
    public static final String SQLITE_DROP_TABLE = "DROP TABLE IF EXISTS ";
    public static final String SQLITE_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS ";
    public static final String SQLITE_ATTRIBUTE_INTEGER = " INTEGER ";
    public static final String SQLITE_ATTRIBUTE_TEXT = " TEXT ";
    public static final String SQLITE_ATTRIBUTE_BLOB = " BLOB ";
    public static final String SQLITE_ATTRIBUTE_BYTE = " BYTE[] ";
    public static final String SQLITE_ATTRIBUTE_LONG = " LONG ";
    public static final String SQLITE_ATTRIBUTE_PRIMARY_KEY = "PRIMARY KEY ";
    public static final String SQLITE_ATTRIBUTE_AUTOINCREMENT = "AUTOINCREMENT ";
    public static final String SQLITE_ATTRIBUTE_NOTNULL = "NOT NULL ";
    public static final String SQLITE_COMMAND_SELECT = "SELECT ";
    public static final String SQLITE_COMMAND_FROM = " FROM ";
    public static final String SQLITE_COMMAND_WHERE = " WHERE ";
    public static final String SQLITE_COMMAND_LESS_EQUAL = " <= ";
    public static final String SQLITE_COMMAND_GREATER_EQUAL = " >= ";
    public static final String SQLITE_COMMAND_EQUAL = " = ";
    public static final String SQLITE_COMMAND_GREATER = " > ";
    public static final String SQLITE_COMMAND_LESS = " < ";
    public static final String SQLITE_COMMAND_AND = " AND ";
    public static final String SQLITE_COMMAND_OR = " OR ";
    public static final String SQLITE_COMMAND_ORDER_BY = " ORDER BY ";
    public static final String SQLITE_COMMAND_ASCENDING = " ASC ";
    public static final String SQLITE_COMMAND_DESCENDING = " DESC ";
    public static final String SQLITE_COMMAND_ASTERISK = " * ";
    public static final String SQLITE_COMMAND_QUOTES = "'";
    public static final String SQLITE_COMMAND_SUM = " SUM ";
    public static final String SQLITE_COMMAND_PARENTHESIS_LEFT = " ( ";
    public static final String SQLITE_COMMAND_PARENTHESIS_RIGHT = " ) ";
    public static final String SQLITE_COMMAND_COMMA = " , ";
    public static final String SQLITE_COMMAND_GROUP_BY = " GROUP BY ";
    public static final String SQLITE_COMMAND_COUNT_FROM = "SELECT COUNT(*) FROM ";

}
