package lk.ijse.fruitshop.fruitshop.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.fruitshop.fruitshop.customObj.ItemResponse;
import lk.ijse.fruitshop.fruitshop.customObj.UserErrorResponse;
import lk.ijse.fruitshop.fruitshop.customObj.impl.ItemErrorResponse;
import lk.ijse.fruitshop.fruitshop.dao.CustomerDAO;
import lk.ijse.fruitshop.fruitshop.dao.ItemDAO;
import lk.ijse.fruitshop.fruitshop.dto.impl.ItemDTO;
import lk.ijse.fruitshop.fruitshop.entity.UserEntity;
import lk.ijse.fruitshop.fruitshop.entity.impl.CustomerEntity;
import lk.ijse.fruitshop.fruitshop.entity.impl.ItemEntity;
import lk.ijse.fruitshop.fruitshop.exception.DataPersistFailedException;
import lk.ijse.fruitshop.fruitshop.exception.ItemNotFoundException;
import lk.ijse.fruitshop.fruitshop.service.ItemService;
import lk.ijse.fruitshop.fruitshop.util.AppUtil;
import lk.ijse.fruitshop.fruitshop.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemServiceIMPL implements ItemService {
    @Autowired
    private ItemDAO itemDAO;
    @Autowired
    private Mapping mapping;
    @Override
    public void saveItem(ItemDTO itemDTO) {
        itemDTO.setCode(AppUtil.createItemCode());
        ItemEntity Itemsave= itemDAO.save(mapping.convertToItemEntity(itemDTO));
        if(Itemsave == null && Itemsave.getCode() == null ) {
            throw new DataPersistFailedException("Cannot data saved");
        }
    }

    @Override
    public void updateItem(String code, ItemDTO itemDTO) {
        Optional<ItemEntity> updateById=itemDAO.findById(itemDTO.getCode());
        if(!updateById.isPresent()){
            throw new ItemNotFoundException("Item not found");
        }else {
            updateById.get().setDescription(itemDTO.getDescription());
            updateById.get().setPrice(itemDTO.getPrice());
            updateById.get().setQuantity(itemDTO.getQuantity());
        }
    }

    @Override
    public void deleteItem(String code) {
        Optional<ItemEntity> selectedItemCode = itemDAO.findById(code);
        if(selectedItemCode.isPresent()){
            itemDAO.deleteById(code);
        }else {
            throw new ItemNotFoundException("Item not found");
        }
    }

    @Override
    public List<ItemDTO> getAllItem() {
        return  mapping.convertToItemDTO(itemDAO.findAll());

    }

    @Override
    public ItemResponse getSelectItem(String code) {
        if(itemDAO.existsById(code)){
            ItemEntity itemEntityByItemCode = itemDAO.getItemEntitiesByCode(code);
            return mapping.convertToItemDTO(itemEntityByItemCode);
        }else {
            return new ItemErrorResponse(0, "Item not found");
        }
    }

}
