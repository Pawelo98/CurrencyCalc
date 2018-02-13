package com.github.pawelo98.order;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OrderDTOMapper {

    public static OrderDTO toOrderDTO(Order order){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
    /*    orderDTO.setProductName(order.getProducts().getName()); */
        return orderDTO;
    }

    public static List<OrderDTO> toOrderDTO(Collection<Order> orders){
        List<OrderDTO> result = new ArrayList<OrderDTO>();
        for(Order order : orders){
            result.add(toOrderDTO(order));
        }
        return result;
    }
}
