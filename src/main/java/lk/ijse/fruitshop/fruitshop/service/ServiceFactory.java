package lk.ijse.fruitshop.fruitshop.service;

import lk.ijse.fruitshop.fruitshop.service.impl.CustomerServiceIMPL;
import lk.ijse.fruitshop.fruitshop.service.impl.ItemServiceIMPL;
import lk.ijse.fruitshop.fruitshop.service.impl.PlaceOrderServiceIMPL;

public class ServiceFactory {
    private static ServiceFactory serviceFactory;
    private ServiceFactory(){
    }
    public static ServiceFactory getServiceFactory(){
        return (serviceFactory==null)?serviceFactory=new ServiceFactory():serviceFactory;
    }
    public static SuperService getService(ServiceType serviceType){
        switch (serviceType){
            case CUSTOM:return new CustomerServiceIMPL();
            case ITEM:return  new ItemServiceIMPL();
            case PLACEORDER:return  new PlaceOrderServiceIMPL();
            default: return null;
        }

    }
    public enum ServiceType{
        CUSTOM,ITEM,PLACEORDER
    }
}
