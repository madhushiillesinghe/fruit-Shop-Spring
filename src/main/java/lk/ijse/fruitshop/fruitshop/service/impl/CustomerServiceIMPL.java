package lk.ijse.fruitshop.fruitshop.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.fruitshop.fruitshop.customObj.CustomerResponse;
import lk.ijse.fruitshop.fruitshop.customObj.impl.CustomerErrorResponse;
import lk.ijse.fruitshop.fruitshop.dao.CustomerDAO;
import lk.ijse.fruitshop.fruitshop.dto.impl.CustomerDTO;
import lk.ijse.fruitshop.fruitshop.entity.impl.CustomerEntity;
import lk.ijse.fruitshop.fruitshop.exception.CustomerNotFound;
import lk.ijse.fruitshop.fruitshop.exception.DataPersistFailedException;
import lk.ijse.fruitshop.fruitshop.exception.ItemNotFoundException;
import lk.ijse.fruitshop.fruitshop.service.CustomerService;
import lk.ijse.fruitshop.fruitshop.util.AppUtil;
import lk.ijse.fruitshop.fruitshop.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceIMPL implements CustomerService {
    @Autowired
    private CustomerDAO customerDAO;
    @Autowired
    private Mapping mapping;

    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        customerDTO.setId(AppUtil.createCustomerId());
        CustomerEntity customersave= customerDAO.save(mapping.convertToCustomerEntity(customerDTO));
        if(customersave == null && customersave.getId() == null ) {
            throw new DataPersistFailedException("Cannot data saved");
        }
    }

    @Override
    public void updateCustomer(String cusId, CustomerDTO customerDTO) {
        Optional<CustomerEntity> updateById=customerDAO.findById(cusId);
        if(!updateById.isPresent()){
            throw new CustomerNotFound("Customer not found");
        }else {
            updateById.get().setName(customerDTO.getName());
            updateById.get().setAddress(customerDTO.getAddress());
            updateById.get().setSalary(customerDTO.getSalary());
        }
    }

    @Override
    public void deleteCustomer(String cusId) {
        Optional<CustomerEntity> selectedCustomerId = customerDAO.findById(cusId);
        if(selectedCustomerId.isPresent()){
            customerDAO.deleteById(cusId);
        }else {
            throw new ItemNotFoundException("Customer not found");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        return  mapping.convertToCustomerDTO(customerDAO.findAll());
    }

    @Override
    public CustomerResponse getSelectCustomer(String cusId) {
        if(customerDAO.existsById(cusId)){
            Optional<CustomerEntity> customerEntityByCusId = customerDAO.findById(cusId);
            return mapping.convertToCustomerDTO(customerEntityByCusId.get());
        }else {
            return new CustomerErrorResponse(0, "User not found");
        }
    }
}
