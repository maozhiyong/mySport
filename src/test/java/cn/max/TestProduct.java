package cn.max;

import cn.max.core.bean.product.Product;
import cn.max.core.query.product.ProductQuery;
import cn.max.core.service.product.ProductService;
import frame.SpringJunitTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TestProduct extends SpringJunitTest{
    @Autowired
    ProductService productService;
    @Test
    public void testList() {
        List<Product> productList = productService.getProductList(new ProductQuery());
        for (Product product : productList) {
            System.out.println(product.toString());
        }
    }
}
