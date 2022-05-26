package com.site.woolencreations.product;

import com.site.woolencreations.category.Category;
import com.site.woolencreations.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/v1/product")
/**
 * Send request to postman
 * GET
 * http://localhost:8080/api/v1/product/findAll?name='kaskol'
 * */
public class ProductController {
    private final ProductService productService;
    private final OrderService orderService;

    private static final String defaultPageNo = "0";
    private static final String defaultPageSize = "25";
    private static final String defaultSortMethod = "ASC";
    private static final String defaultSortColumn = "name";


    @Autowired
    public ProductController(ProductService productService, OrderService orderService) {
        this.productService = productService;
        this.orderService = orderService;
    }

    @GetMapping("/findByName")
    public Optional<Product> getProductByName(@RequestParam String name) {
        return productService.findProductByName(name);
    }

    @GetMapping("/findById")
    public Optional<Product> getProductByName(@RequestParam Long id) {
        return productService.findProductById(id);
    }

    @GetMapping("/findByDescription")
    public Optional<Product> getProductByDescription(@RequestParam String descr) {
        return productService.findProductsByDescriptionContains(descr);
    }

    @GetMapping("/findAll")
    public List<Product> getProduct(@RequestParam(defaultValue = defaultPageNo) int page,
                                    @RequestParam(defaultValue = defaultPageSize) int size,
                                    @RequestParam(defaultValue = defaultSortMethod) String sort,
                                    @RequestParam(defaultValue = defaultSortColumn) String sortColumn) {
        return productService.getProduct(page, size, sort, sortColumn);
    }

    @GetMapping("/findByKeyword")
    public List<Product> getProductByKeyword(@RequestParam(defaultValue = defaultPageNo) int page,
                                             @RequestParam(defaultValue = defaultPageSize) int size,
                                             @RequestParam(defaultValue = defaultSortMethod) String sort,
                                             @RequestParam(defaultValue = defaultSortColumn) String sortColumn,
                                             @RequestParam String keyword) {
        return productService.findProductsByKeyword(keyword, page, size, sort, sortColumn);
    }

    @GetMapping("/findByCategory")
    public List<Product> getProductByCategory(@RequestParam(defaultValue = defaultPageNo) int page,
                                              @RequestParam(defaultValue = defaultPageSize) int size,
                                              @RequestParam(defaultValue = defaultSortMethod) String sort,
                                              @RequestParam(defaultValue = defaultSortColumn) String sortColumn,
                                              @RequestParam String category1) {
        return productService.findProductsByCategory(page, size, sort, sortColumn, category1);
    }

    @GetMapping("/findByTwoCategories")
    public List<Product> getProductByTwoCategories(@RequestParam(defaultValue = defaultPageNo) int page,
                                                   @RequestParam(defaultValue = defaultPageSize) int size,
                                                   @RequestParam(defaultValue = defaultSortMethod) String sort,
                                                   @RequestParam(defaultValue = defaultSortColumn) String sortColumn,
                                                   @RequestParam String category1,
                                                   @RequestParam String category2) {
        return productService.findProductsBySubCategory(page, size, sort, sortColumn, category1, category2);
    }

    @GetMapping("/findByDiscount")
    public List<Product> findProductByDiscount(@RequestParam(defaultValue = defaultPageNo) int page,
                                               @RequestParam(defaultValue = defaultPageSize) int size,
                                               @RequestParam(defaultValue = defaultSortMethod) String sort,
                                               @RequestParam(defaultValue = defaultSortColumn) String sortColumn,
                                               @RequestParam Double discount) {
        return productService.findProductByDiscount(page, size, sort, sortColumn, discount);
    }

    @GetMapping("/findAllProductsInOffer")
    public List<Product> findAllProductsInOffer(@RequestParam(defaultValue = defaultPageNo) int page,
                                                @RequestParam(defaultValue = defaultPageSize) int size,
                                                @RequestParam(defaultValue = defaultSortMethod) String sort,
                                                @RequestParam(defaultValue = defaultSortColumn) String sortColumn) {
        return productService.findAllProductsInOffer(page, size, sort, sortColumn);
    }

    @PostMapping("/add")
    public String registerNewProduct(@RequestBody Product product) {
        productService.addNewProduct(product);
        return "Success";
    }

    @PostMapping("/addList")
    public String registerNewListProducts(@RequestBody List<Product> products) {
        productService.addNewListProducts(products);
        return "Success";
    }

    @PutMapping("/edit")
    public String editUser(@RequestBody Product product) {
        productService.editProduct(product);
        return "Success";
    }

    @DeleteMapping("/delete")
    public String deleteProduct(@RequestParam Long id) {
        productService.deleteProduct(id);
        return "Success";

    }


    /**
     *  Advertisement Algorithm
     */
    @PostMapping("/advertisement")
    public List<Product> targetedAdvertisement(@RequestParam Long customerId,
                                               @RequestBody List<Long> productIds) {
        List<Product> productList;
        if (customerId != null) {
            productList = (orderService.findProductIdsByUserOrderingHistory(customerId)).stream().map(orderProduct -> orderProduct.getProduct()).collect(Collectors.toList());
        } else {
            //TODO here I do not have the customerId so I will take other info to decide for example I will haave a list with productId from cookies  ?
            productList = productService.findProductsByIdIn(productIds);
        }

        List<String> preferredCategoryNames = productList
                .stream()
                .flatMap(product -> product.getCategoryList().stream().map(Category::getCategoryName))
                .collect(Collectors.toList());

        List<Double> preferredPrice = productList
                .stream()
                .map(Product::getPrice)
                .collect(Collectors.toList());

        List<Integer> preferredProductPoints = productList
                .stream()
                .map(Product::getPoints)
                .collect(Collectors.toList());

        return productService.customerTargetedProducts(preferredCategoryNames, preferredPrice, preferredProductPoints);


    }

    }
