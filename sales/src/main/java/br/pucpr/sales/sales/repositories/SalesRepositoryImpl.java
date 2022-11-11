package br.pucpr.sales.sales.repositories;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.pucpr.sales.sales.entities.Sale;

public class SalesRepositoryImpl implements SalesRepositoryCustom {
    
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Sale> findTodaysSales() {
        try {
            Query query = entityManager.createNativeQuery(
                "SELECT * FROM sales WHERE sale_date = ?", 
                Sale.class
            );
    
            query.setParameter(1, new Date(System.currentTimeMillis()));
    
            List<Sale> sale = query.getResultList();
            
            return sale;
        } catch (Exception e) {
            
        }
        return null;
    }
}
