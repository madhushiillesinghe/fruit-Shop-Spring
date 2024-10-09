package lk.ijse.fruitshop.fruitshop.service;

import lk.ijse.fruitshop.fruitshop.customObj.CustomerResponse;
import lk.ijse.fruitshop.fruitshop.customObj.NoteResponse;
import lk.ijse.fruitshop.fruitshop.dto.NoteDto;
import lk.ijse.fruitshop.fruitshop.dto.impl.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO customerDTO);
    void updateCustomer(String cusId,CustomerDTO customerDTO);
    void deleteCustomer(String cusId);
    List<CustomerDTO> getAllCustomer();
    CustomerResponse getSelectCustomer(String cusId);
}
