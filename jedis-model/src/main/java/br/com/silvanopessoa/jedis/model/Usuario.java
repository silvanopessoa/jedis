package br.com.silvanopessoa.jedis.model;

import java.util.Date;


/**
 * O(a) Class Usuario.
 *
 * @author silvano.pessoa
 * @since 28/10/2014 - 21:31:26
 */
public class Usuario extends AbstractPersistable<Long> {

    /** O(a) login. */
    private String login;

    /** O(a) data alteracao. */
    private Date dataAlteracao;

    /**
     * Obtém o valor do(a)(s) data alteracao.
     *
     * @author silvano.pessoa
     * @return o(a) data alteracao
     */
    public Date getDataAlteracao() {
        return dataAlteracao;
    }

    /**
     * Determina o(a) data alteracao.
     *
     * @author silvano.pessoa
     * @param dataAlteracao
     *            o(a) novo(a) data alteracao
     */
    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
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
