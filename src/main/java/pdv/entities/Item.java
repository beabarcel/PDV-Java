/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdv.entities;

import java.math.BigDecimal;

/**
 *
 * @author barce
 */
public class Item {

    private int id;
    private String nome;
    private BigDecimal preco;
    private int quantVenda;
    private BigDecimal precoTotal;
    private Produto idProd; 

    public int getIdItem() {
        return id;
    }

    public void setIdItem(int idItem) {
        this.id = idItem;
    }

    public String getNomeItem() {
        return nome;
    }

    public void setNomeItem(String nomeItem) {
        this.nome = nomeItem;
    }

    public BigDecimal getPrecoItem() {
        return preco;
    }

    public void setPrecoItem(BigDecimal precoItem) {
        this.preco = precoItem;
    }
    
    public BigDecimal getPrecoTotalItem(){
        return precoTotal;
    }
    
    public void setPretoTotalItem(BigDecimal precoTotalItem){
        this.precoTotal = precoTotalItem;
    }
    
    public int getQuantVendalItem(){
        return quantVenda;
    }
    
    public void setQuantVendaItem(int quantVendaItem){
        this.quantVenda = quantVendaItem;
    }
    
    public Produto getIdProd(){
        return idProd;
    }
    
    public void setIdProd (Produto idProd){
        this.idProd = idProd;
    }
}
