package br.com.silvanopessoa.jedis.model;

import java.io.Serializable;
import java.util.Date;

/**
 * O(a) Class Usuario.
 *
 * @author silvano.pessoa
 * @since 28/10/2014 - 21:31:26
 */
public class User extends AbstractPersistable<Long> implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** O(a) login. */
    private String login;

    /** O(a) data alteracao. */
    private Date modifyDate;

    /**
     * Gets the modify date.
     * 
     * @author silvano.pessoa
     * @return the modify date
     */
    public Date getModifyDate() {
		return modifyDate;
	}

	/**
	 * Sets the modify date.
	 *
	 * @author silvano.pessoa
	 * @param modifyDate the new modify date
	 */
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	/**
     * Obtém o valor do(a)(s) login.
     *
     * @author silvano.pessoa
     * @return o(a) login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Determina o(a) login.
     *
     * @author silvano.pessoa
     * @param login
     *            o(a) novo(a) login
     */
    public void setLogin(String login) {
        this.login = login;
    }

}
