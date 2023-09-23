package lk.ijse.gdse.service;


import lk.ijse.gdse.dto.OrdersDTO;
import lk.ijse.gdse.entity.OrderDetails;

import java.util.List;

public interface PurchaseOrderService {
    void purchaseOrder(OrdersDTO dto);
    void deleteOrder(String oid);
    void updateOrder(OrdersDTO dto);
    OrdersDTO searchOrder(String oid);
    List<OrderDetails> getAllOrder();
}
