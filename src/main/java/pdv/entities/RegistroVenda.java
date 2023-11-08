/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdv.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author barce
 */
public class RegistroVenda {
    private List<Venda> vendas;

    public RegistroVenda() {
        this.vendas = new ArrayList<>();
    }

    public void incluirVenda(Venda venda) {
        vendas.add(venda);
    }

    public List<Venda> obterVendas() {
        return vendas;
    }
}

