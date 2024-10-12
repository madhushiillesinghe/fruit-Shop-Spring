package lk.ijse.fruitshop.fruitshop.controller;

import jakarta.validation.Valid;
import lk.ijse.fruitshop.fruitshop.dto.impl.OrderDTO;
import lk.ijse.fruitshop.fruitshop.exception.DataPersistFailedException;
import lk.ijse.fruitshop.fruitshop.service.PlaceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
@CrossOrigin(origins = "*" ,allowedHeaders ="*" )
@RestController
@RequestMapping(value = "/api/v1/placeOrder")
public class PlaceOrderController {
    @Autowired
    private PlaceOrderService placeOrderService;
    static Logger logger = LoggerFactory.getLogger(PlaceOrderController.class);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void > createItem(@Valid @RequestBody OrderDTO buildorderDTO  ){
        try {
            placeOrderService.saveOrder(buildorderDTO);
            logger.info("Order saved : " + buildorderDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistFailedException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            logger.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/allorders",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDTO> getAllOrders(){
        return placeOrderService.getAllOrder();
    }
}
