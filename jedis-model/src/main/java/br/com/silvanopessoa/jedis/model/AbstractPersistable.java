package br.com.silvanopessoa.jedis.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Classe base para as entidades.
 *
 * @author silvano.pessoa
 * @param <T>
 *            the generic type
 * @since 28/10/2014 - 20:40:45
 */
public abstract class AbstractPersistable<T extends Serializable>{

    /**************************************************************/
    /************************* ATRIBUTOS **************************/
    /**************************************************************/

    /**
     * SERIAL VERSION UID.
     */
    private static final long serialVersionUID = 1L;

    /** O(a) id. */
    private T id;

    /**************************************************************/
    /********************** FUNCIONALIDADES ***********************/
    /**************************************************************/

    /*
     * (non-Javadoc)
     * 
     * @see br.com.silvanopessoa.rest.api.model.base.Persistable#isNew()
     */
    public boolean isNew() {
        return null == getId();
    }

    /**************************************************************/
    /************************** GET/SET ***************************/
    /**************************************************************/

    /**
     * Obtém o valor do(a)(s) id.
     *
     * @author silvano.pessoa
     * @return the id
     */
    public T getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id
     *            the new id
     */
    public void setId(final T id) {
        this.id = id;
    }

    /**************************************************************/
    /****************** EQUALS/HASHCODE/TOSTRING ******************/
    /**************************************************************/

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.id).hashCode();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof AbstractPersistable)) {
            return false;
        }
        AbstractPersistable<T> other = (AbstractPersistable<T>) obj;
        return new EqualsBuilder().append(this.id, other.id).isEquals();
    }

}
