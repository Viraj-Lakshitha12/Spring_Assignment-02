package lk.ijse.gdse.controller;


import lk.ijse.gdse.dto.OrdersDTO;
import lk.ijse.gdse.service.PurchaseOrderService;
import lk.ijse.gdse.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/purchase_Order")
@CrossOrigin
public class PurchaseOrderController {

    @Autowired
    PurchaseOrderService purchaseOrderService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllItem(){
        return new ResponseUtil(200,"Success",purchaseOrderService.getAllOrder());
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil purchaseOrder(@RequestBody OrdersDTO ordersDTO){
        System.out.println(ordersDTO.toString());
        purchaseOrderService.purchaseOrder(ordersDTO);
        return new ResponseUtil(200,"Success",ordersDTO);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateOrder(@RequestBody OrdersDTO ordersDTO){
        purchaseOrderService.updateOrder(ordersDTO);
        return new ResponseUtil(200,"Success",ordersDTO);
    }
}
