package br.com.silvanopessoa.jedis.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * The Class Person.
 */
public class Person extends AbstractPersistable<Long> implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The name. */
	private String name;
	
	/** The modify date. */
	private Date modifyDate;
	
	/** The documents. */
	private List<Document> documents;

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the modify date.
	 *
	 * @return the modify date
	 */
	public Date getModifyDate() {
		return modifyDate;
	}

	/**
	 * Sets the modify date.
	 *
	 * @param modifyDate the new modify date
	 */
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	/**
	 * Gets the documents.
	 *
	 * @return the documents
	 */
	public List<Document> getDocuments() {
		return documents;
	}

	/**
	 * Sets the documents.
	 *
	 * @param documents the new documents
	 */
	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}
	
}
