package t1708e.serviceclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import t1708e.serviceclient.service.ProductService;
import t1708e.serviceclient.service.ProductServiceServiceLocator;

import javax.xml.rpc.ServiceException;

@Configuration
public class ServiceConfig {

    @Bean
    ProductService studentService() throws ServiceException {
        ProductServiceServiceLocator locator = new ProductServiceServiceLocator();
        ProductService productService = locator.getProductServicePort();
        return productService;
    }
}
