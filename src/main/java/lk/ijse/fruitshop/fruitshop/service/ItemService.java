package lk.ijse.fruitshop.fruitshop.service;

import lk.ijse.fruitshop.fruitshop.customObj.ItemResponse;
import lk.ijse.fruitshop.fruitshop.dto.impl.ItemDTO;

import java.util.List;

public interface ItemService {
    void saveItem(ItemDTO itemDTO);
    void updateItem(String code,ItemDTO itemDTO);
    void deleteItem(String code);
    List<ItemDTO> getAllItem();
    ItemResponse getSelectItem(String code);
}
