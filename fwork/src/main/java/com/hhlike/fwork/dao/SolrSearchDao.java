package com.hhlike.fwork.dao;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.SolrQuery.SortClause;

import com.hhlike.fwork.core.ResultData;

public interface SolrSearchDao {

	/**
	 * 创建或修改记录
	 * @param item
	 * @throws SolrServerException
	 * @throws IOException
	 */
	void addOrUpdateItem(Object item) throws SolrServerException, IOException;

	/**
	 * 批量添加多条记录
	 * @param itemList
	 * @throws SolrServerException
	 * @throws IOException
	 */
	void addItemList(List<Object> itemList) throws SolrServerException, IOException;

	/**
	 * 根据搜索条件查数据
	 * @param query
	 * @param clazz
	 * @return
	 * @throws SolrServerException
	 * @throws IOException
	 */
	<T> List<T> searchByQuery(String query, Class<T> clazz, SortClause sortClause)
			throws SolrServerException, IOException;

	/**
	 * 分页搜索
	 * @param query
	 * @param pageNum
	 * @param pageSize
	 * @param clazz
	 * @return
	 * @throws SolrServerException
	 * @throws IOException
	 */
	<T> ResultData searchByQueryPage(String query, Integer pageNum, Integer pageSize, Class<T> clazz,
			SortClause sortClause) throws SolrServerException, IOException;

	/**
	 * 重建索引
	 * @param isDelta true增量，false全量
	 * @throws SolrServerException
	 * @throws IOException
	 */
	void buildIndex(boolean isDelta) throws SolrServerException, IOException;

}