package oppWithNLayaredApp;

import oppWithNLayaredApp.business.ProductService;
import oppWithNLayaredApp.core.logging.DatabaseLogger;
import oppWithNLayaredApp.core.logging.FileLogger;
import oppWithNLayaredApp.core.logging.Logger;
import oppWithNLayaredApp.core.logging.MailLogger;
import oppWithNLayaredApp.dataAccess.HibernateProductDao;
import oppWithNLayaredApp.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Product product1=new Product(1,"I Phone Xr",10000);
        List<Logger> loggers=new ArrayList<>();
        loggers.add(new DatabaseLogger());
        loggers.add(new FileLogger());
        loggers.add(new MailLogger());
        ProductService productService=new ProductService(new HibernateProductDao(),loggers);
        try {
            productService.add(product1);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
