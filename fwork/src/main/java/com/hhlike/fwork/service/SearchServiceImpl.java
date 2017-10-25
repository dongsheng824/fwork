package com.hhlike.fwork.service;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery.SortClause;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hhlike.fwork.core.ResultData;
import com.hhlike.fwork.dao.SolrSearchDao;

@Service("searchService")
public class SearchServiceImpl implements SearchService {

	@Autowired
	private SolrSearchDao solrSearchDao;
	
	@Override
	public void addOrUpdateItem(Object item) throws SolrServerException, IOException {
		solrSearchDao.addOrUpdateItem(item);
	}

	@Override
	public void addItemList(List<Object> itemList) throws SolrServerException, IOException {
		solrSearchDao.addItemList(itemList);
	}

	@Override
	public <T> List<T> searchByQuery(String query, Class<T> clazz, SortClause sortClause)
			throws SolrServerException, IOException {
		return solrSearchDao.searchByQuery(query, clazz, sortClause);
	}

	@Override
	public <T> ResultData searchByQueryPage(String query, Integer pageNum, Integer pageSize, Class<T> clazz,
			SortClause sortClause) throws SolrServerException, IOException {
		return solrSearchDao.searchByQueryPage(query, pageNum, pageSize, clazz, sortClause);
	}

	@Override
	public void buildIndex(boolean isDelta) throws SolrServerException, IOException {
		solrSearchDao.buildIndex(isDelta);
	}

}
