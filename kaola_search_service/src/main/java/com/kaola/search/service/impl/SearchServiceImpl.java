package com.kaola.search.service.impl;

import com.alibaba.dubbo.config.annotation.Service;

import com.kaola.pojo.TbItem;
import com.kaola.search.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.result.ScoredPage;

import java.util.HashMap;
import java.util.Map;

@Service(timeout = 3000)  //连接超时等待  3000毫秒
public class SearchServiceImpl implements SearchService {
    @Autowired
    private SolrTemplate solrTemplate;

  //搜索
    @Override
    public Map<String, Object> search(Map searchMap) {
        Map<String,Object>  map = new HashMap<>();
    //定义查询条件
        Query query = new SimpleQuery();
        Criteria  criteria = new Criteria("item_keywords").is(searchMap.get("keywords"));
        query.addCriteria(criteria);
        ScoredPage<TbItem> page = solrTemplate.queryForPage(query, TbItem.class);//执行搜索
         map.put("rows",page.getContent());//取出数据
        return map;
    }
}
