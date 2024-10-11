package lk.ijse.fruitshop.fruitshop.controller;

import lk.ijse.fruitshop.fruitshop.customObj.ItemResponse;
import lk.ijse.fruitshop.fruitshop.dto.impl.ItemDTO;
import lk.ijse.fruitshop.fruitshop.exception.DataPersistFailedException;
import lk.ijse.fruitshop.fruitshop.exception.ItemNotFoundException;
import lk.ijse.fruitshop.fruitshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/items")
public class ItemController {
    @Autowired
    private ItemService itemService;
    static Logger logger = LoggerFactory.getLogger(ItemController.class);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void > createItem(@RequestBody ItemDTO buildItemDTO  ){
        try {
            itemService.saveItem(buildItemDTO);
            logger.info("Item saved : " + buildItemDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistFailedException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            logger.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{code}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void>  updateItem(@PathVariable ("code") String code,@RequestBody ItemDTO updateItemdto) {
        try {
            itemService.updateItem(code,updateItemdto);
            logger.info("Item updated : " + updateItemdto);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (ItemNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping(value = "/{code}")
    public ResponseEntity<String> deleteItem(@PathVariable ("code") String code) {
        try {
            itemService.deleteItem(code);
            logger.info("Item deleted : " + code);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (ItemNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/allitems",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ItemDTO> getAllItems(){
        return itemService.getAllItem();
    }
    @GetMapping(value = "/{code}",produces =MediaType.APPLICATION_JSON_VALUE )
    public ItemResponse getItem(@PathVariable("code") String code){
        return itemService.getSelectItem(code);
    }
}
