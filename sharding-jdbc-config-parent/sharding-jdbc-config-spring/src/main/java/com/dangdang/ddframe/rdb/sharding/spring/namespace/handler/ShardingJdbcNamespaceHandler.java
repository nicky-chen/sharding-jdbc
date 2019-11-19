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

package com.dangdang.ddframe.rdb.sharding.spring.namespace.handler;

import com.dangdang.ddframe.rdb.sharding.spring.namespace.parser.MasterSlaveDataSourceBeanDefinitionParser;
import com.dangdang.ddframe.rdb.sharding.spring.namespace.parser.ShardingJdbcDataSourceBeanDefinitionParser;
import com.dangdang.ddframe.rdb.sharding.spring.namespace.parser.ShardingJdbcStrategyBeanDefinitionParser;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * Spring命名空间处理器.
 * 
 * @author caohao
 * @author zhangliang
 */
public final class ShardingJdbcNamespaceHandler extends NamespaceHandlerSupport {
    
    @Override
    public void init() {//把sj配置信息注册到spring bean解析器引擎
        registerBeanDefinitionParser("strategy", new ShardingJdbcStrategyBeanDefinitionParser());//对分片策略的解析
        registerBeanDefinitionParser("data-source", new ShardingJdbcDataSourceBeanDefinitionParser());//对数据源的解析
        registerBeanDefinitionParser("master-slave-data-source", new MasterSlaveDataSourceBeanDefinitionParser());
    }
}
