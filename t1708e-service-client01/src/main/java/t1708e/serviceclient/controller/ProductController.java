package t1708e.serviceclient.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import t1708e.serviceclient.service.Product;
import t1708e.serviceclient.service.ProductService;

import javax.validation.Valid;
import java.rmi.RemoteException;
import java.util.List;

@Controller
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model) {
        return "product/form";
    }

    @RequestMapping(value = "/store", method = RequestMethod.POST)
    public String store(@Valid Product product, BindingResult bindingResult, @RequestParam("name") String name,
                        @RequestParam("price") double price,
                        @RequestParam("quantity") int quantity) throws RemoteException {
        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);
        productService.addProduct(product);
        return "redirect:/product/list";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getList(Model model) throws RemoteException {
        Product[] products = new Gson().fromJson(productService.getAllProduct(), Product[].class);
        model.addAttribute("products",products);
        return "product/list";
    }
    @RequestMapping(value = "/sell", method = RequestMethod.GET)
    public String updateForm(Model model) throws RemoteException {
        Product[] products = new Gson().fromJson(productService.getAllProduct(), Product[].class);
        model.addAttribute("products",products);
        model.addAttribute("isSellFalse",false);
        return "product/sellForm";
    }
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Model model,@Valid Product product, BindingResult bindingResult,

                        @RequestParam("quantity") int quantity,
                        @RequestParam("id")int id) throws RemoteException {

        boolean isSell = productService.sellProduct(id,quantity);
        if (isSell){
            return "redirect:/product/list";
        }
        else {
            Product[] products = new Gson().fromJson(productService.getAllProduct(), Product[].class);
            model.addAttribute("products",products);
            model.addAttribute("isSellFalse",true);
            return "product/sellForm";
        }
    }
}
