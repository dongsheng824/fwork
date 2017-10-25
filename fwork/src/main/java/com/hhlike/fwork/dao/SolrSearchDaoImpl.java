package com.hhlike.fwork.dao;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.SolrQuery.SortClause;
import org.apache.solr.client.solrj.beans.DocumentObjectBinder;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hhlike.fwork.core.ResultData;

@Service("solrSearchDao")
public class SolrSearchDaoImpl implements SolrSearchDao {

	@Value("${SOLR_URL}")
	private String solrUrl;
	
	@Override
	public void addOrUpdateItem(Object item) throws SolrServerException, IOException{
		HttpSolrClient solrClient = new HttpSolrClient.Builder(solrUrl).build();
		DocumentObjectBinder binder = new DocumentObjectBinder();
		SolrInputDocument document = binder.toSolrInputDocument(item);
		solrClient.add(document);
		solrClient.commit();
	}
	
	@Override
	public void addItemList(List<Object> itemList) throws SolrServerException, IOException{
		HttpSolrClient solrClient = new HttpSolrClient.Builder(solrUrl).build();
		solrClient.addBeans(itemList);
		solrClient.commit();
	}
	
	@Override
	public <T> List<T> searchByQuery(String query, Class<T> clazz, SortClause sortClause) throws SolrServerException, IOException{
		HttpSolrClient solrClient = new HttpSolrClient.Builder(solrUrl).build();
		SolrQuery solrQuery = new SolrQuery();
		solrQuery.setQuery(query);
		if (sortClause != null) {
			solrQuery.setSort(sortClause);
		}
		QueryResponse response = solrClient.query(solrQuery);
		return response.getBeans(clazz);
	}
	
	@Override
	public <T> ResultData searchByQueryPage(String query, Integer pageNum, Integer pageSize, Class<T> clazz, SortClause sortClause) throws SolrServerException, IOException{
		ResultData result = new ResultData();
		HttpSolrClient solrClient = new HttpSolrClient.Builder(solrUrl).build();
		SolrQuery solrQuery = new SolrQuery();
		solrQuery.setQuery(query);
		solrQuery.setStart(pageNum * pageSize);
		solrQuery.setRows(pageSize);
		if (sortClause != null) {
			solrQuery.setSort(sortClause);
		}
		QueryResponse response = solrClient.query(solrQuery);
		List<T> itemList = response.getBeans(clazz);
		result.addData("itemList", itemList);
		result.addData("count", response.getResults().getNumFound());
		return result;
	}
	
	@Override
	public void buildIndex(boolean isDelta) throws SolrServerException, IOException{
		HttpSolrClient solrClient = new HttpSolrClient.Builder(solrUrl).build();
		SolrQuery solrQuery = new SolrQuery();
		String command = isDelta ? "delta-import" : "full-import";
		String clean = isDelta ? "false" : "true";
		String optimize = isDelta ? "false" : "true";
		solrQuery.setParam("command", command);
		solrQuery.setParam("clean", clean);
		solrQuery.setParam("optimize", optimize);
		solrClient.query(solrQuery);
	}
}
