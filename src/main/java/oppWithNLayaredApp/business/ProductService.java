package oppWithNLayaredApp.business;

import oppWithNLayaredApp.core.logging.Logger;
import oppWithNLayaredApp.dataAccess.HibernateProductDao;
import oppWithNLayaredApp.dataAccess.JdbcProductDao;
import oppWithNLayaredApp.dataAccess.ProductDao;
import oppWithNLayaredApp.entities.Product;

import java.util.List;

public class ProductService {
    private ProductDao productDao;

    private List<Logger>loggers;

    public ProductService(ProductDao productDao, List<Logger> loggers) {
        this.productDao = productDao;
        this.loggers=loggers;

    }

    public void add(Product product)throws Exception{
        // iş kuralları business Rules

        if (product.getUnitPrice()<10){
            throw new Exception("Ürün fiyatı 10 dan küçük olamaz.");
        }

        productDao.add(product);
        for (Logger logger:loggers){ //[db,file,mail]
            logger.log(product.getName());
        }

    }
}
