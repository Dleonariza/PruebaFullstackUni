package com.uni.PruebaFullStackV1.Services;

import com.uni.PruebaFullStackV1.Models.DetailOrder;
import com.uni.PruebaFullStackV1.Repositories.DetailOrderRepository;
import com.uni.PruebaFullStackV1.Services.InterfacesImplements.IDetailOrder;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DetailOrderService implements IDetailOrder {

    private final DetailOrderRepository detailOrderRepository;

    @Override
    public DetailOrder createDetailOrder(DetailOrder detailOrder) {
        return detailOrderRepository.save(detailOrder);
    }

    @Override
    public DetailOrder updateDetailOrder(Long id, DetailOrder detailOrder) {
        return null;
    }

    @Override
    public DetailOrder findDetailOrderById(Long id) {
        return detailOrderRepository.getReferenceById(id);
    }

    @Override
    public List<DetailOrder> allDetailsOrders() {
        return detailOrderRepository.findAll();
    }

    @Override
    public String deleteDetailOrder(Long id) {
        detailOrderRepository.deleteById(id);
        return "Detail order:" + findDetailOrderById(id).getId() +"deleted";
    }
}
