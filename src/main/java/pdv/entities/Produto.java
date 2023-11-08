/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdv.entities;

import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author barce
 */
public class Produto {

    private int idProd;
    private int quantProdEstoque;
    private int unidProd;
    private String nomeProd;
    private BigDecimal precoProd;
    private Date dataVendaProd;

    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int codProd) {
        this.idProd = codProd;
    }

    public int getQuantProdEstoque() {
        return quantProdEstoque;
    }

    public void setQuantProdEstoque(int quantProdEstoque) {
        this.quantProdEstoque = quantProdEstoque;
    }

    public int getUnidProd() {
        return unidProd;
    }

    public void setUnidProd(int unidProd) {
        this.unidProd = unidProd;
    }

    public String getNomeProd() {
        return nomeProd;
    }

    public void setNomeProd(String nomeProd) {
        this.nomeProd = nomeProd;
    }

    public BigDecimal getPrecoProd() {
        return precoProd;
    }

    public void setPrecoProd(BigDecimal precoProd) {
        this.precoProd = precoProd;
    }

    public Date getDataVendaProd() {
        return dataVendaProd;
    }

    public void setDataVendaProd(Date dataVendaProd) {
        this.dataVendaProd = dataVendaProd;
    }

}