package lk.ijse.fruitshop.fruitshop.controller;

import lk.ijse.fruitshop.fruitshop.customObj.CustomerResponse;
import lk.ijse.fruitshop.fruitshop.dto.impl.CustomerDTO;
import lk.ijse.fruitshop.fruitshop.exception.CustomerNotFound;
import lk.ijse.fruitshop.fruitshop.exception.DataPersistFailedException;
import lk.ijse.fruitshop.fruitshop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/customers")
public class CustomerController {
    @Autowired
    private CustomerService  customerService;
    static Logger logger = LoggerFactory.getLogger(CustomerController.class);
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void > createCustomer(@RequestBody CustomerDTO buildCustomerDTO  ){
        try {
            customerService.saveCustomer(buildCustomerDTO);
            logger.info("Customer saved : " + buildCustomerDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistFailedException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            logger.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{cusId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void>  updateCustomer(@PathVariable ("cusId") String cusId,@RequestBody CustomerDTO updateCustomerdto) {
        try {
            customerService.updateCustomer(cusId,updateCustomerdto);
            logger.info("Customer updated : " + updateCustomerdto);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CustomerNotFound e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping(value = "/{cusId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable ("cusId") String cusId) {
        try {
            customerService.deleteCustomer(cusId);
            logger.info("Customer deleted : " + cusId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CustomerNotFound e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/allcustomers",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CustomerDTO> getAllCustomers(){
        return customerService.getAllCustomer();
    }
    @GetMapping(value = "/{cusId}",produces =MediaType.APPLICATION_JSON_VALUE )
    public CustomerResponse getCustomer(@PathVariable("cusId") String cusId){
        return customerService.getSelectCustomer(cusId);
    }
}
