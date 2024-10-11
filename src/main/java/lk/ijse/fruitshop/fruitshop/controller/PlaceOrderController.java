package lk.ijse.fruitshop.fruitshop.controller;

import lk.ijse.fruitshop.fruitshop.dto.impl.OrderDTO;
import lk.ijse.fruitshop.fruitshop.exception.DataPersistFailedException;
import lk.ijse.fruitshop.fruitshop.service.ItemService;
import lk.ijse.fruitshop.fruitshop.service.PlaceOrderService;
import lk.ijse.fruitshop.fruitshop.service.ServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/placeOrder")
public class PlaceOrderController {
    @Autowired
//    private PlaceOrderService placeOrderService;
    PlaceOrderService placeOrderService= (PlaceOrderService) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceType.PLACEORDER);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void > createItem(@RequestBody OrderDTO buildorderDTO  ){
        try {
            placeOrderService.saveOrder(buildorderDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistFailedException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/allorders",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDTO> getAllOrders(){
        return placeOrderService.getAllOrder();
    }

}
