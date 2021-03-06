/*
 * Copyright 1999-2015 dangdang.com.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package com.dangdang.ddframe.rdb.sharding.parsing.parser.statement.dml.delete;

import com.dangdang.ddframe.rdb.sharding.parsing.lexer.token.DefaultKeyword;
import com.dangdang.ddframe.rdb.sharding.parsing.parser.AbstractSQLParser;
import com.dangdang.ddframe.rdb.sharding.parsing.parser.statement.SQLStatementParser;
import com.dangdang.ddframe.rdb.sharding.parsing.parser.statement.dml.DMLStatement;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Delete语句解析器.
 *
 * @author zhangliang
 */
@RequiredArgsConstructor
@Getter(AccessLevel.PROTECTED)
public abstract class AbstractDeleteParser implements SQLStatementParser {
    
    private final AbstractSQLParser sqlParser;
    
    private final DMLStatement deleteStatement;
    
    public AbstractDeleteParser(final AbstractSQLParser sqlParser) {
        this.sqlParser = sqlParser;
        deleteStatement = new DMLStatement();
    }
    
    @Override
    public DMLStatement parse() {//delete语句解析方法
        sqlParser.getLexer().nextToken();
        skipBetweenDeleteAndTable();
        sqlParser.parseSingleTable(deleteStatement);
        sqlParser.skipUntil(DefaultKeyword.WHERE);
        sqlParser.parseWhere(deleteStatement);
        return deleteStatement;
    }
    
    protected abstract void skipBetweenDeleteAndTable();
}
