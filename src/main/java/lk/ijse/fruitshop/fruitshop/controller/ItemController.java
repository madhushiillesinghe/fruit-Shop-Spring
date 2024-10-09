package lk.ijse.fruitshop.fruitshop.controller;

import lk.ijse.fruitshop.fruitshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/items")
public class ItemController {
    @Autowired
    private ItemService itemService;
}
