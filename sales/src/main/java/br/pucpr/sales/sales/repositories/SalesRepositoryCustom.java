package br.pucpr.sales.sales.repositories;

import java.util.List;

import br.pucpr.sales.sales.entities.Sale;

public interface SalesRepositoryCustom {
    List<Sale> findTodaysSales();
}
