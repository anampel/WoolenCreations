package com.site.woolencreations.advertisement;

import com.site.woolencreations.order.OrderService;
import com.site.woolencreations.product.Product;
import com.site.woolencreations.product.ProductService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AdvertisementService {
    private final ProductService productService;
    private final OrderService orderService;

    public AdvertisementService(ProductService productService, OrderService orderService) {
        this.productService = productService;
        this.orderService = orderService;
    }

    public List<Product> targetedAdvertisement(@RequestParam Long customerId,
                                               @RequestBody List<Long> productIds) {
        List<Product> userProducts = null;
        List<Product> visitedProducts = null;

        if (customerId != null) {
            userProducts = (orderService.findProductIdsByUserOrderingHistory(customerId)).stream().map(orderProduct -> orderProduct.getProduct()).collect(Collectors.toList());

        }
        if (productIds != null && !productIds.isEmpty()) {
            //TODO here I do not have the customerId so I will take other info to decide for example I will have a list with productId from cookies  or recently visited products.
            //Generally frond-end will share here info about user's preference based on his/her
            visitedProducts = productService.findProductsByIdIn(productIds);
        }
        //Here... merge two lists and keep duplicate  values with a  weight...

        //productMap< productId, weight>

        Map<Long, Integer> productMap = new HashMap<>();


//        List<String> preferredCategoryNames = productList
//                .stream()
//                .flatMap(product -> product.getCategoryList().stream().map(Category::getCategoryName))
//                .collect(Collectors.toList());
//
//        List<Double> preferredPrice = productList
//                .stream()
//                .map(Product::getPrice)
//                .collect(Collectors.toList());
//
//        List<Integer> preferredProductPoints = productList
//                .stream()
//                .map(Product::getPoints)
//                .collect(Collectors.toList());

        return customerTargetedProducts(null, null, null);


    }


    /**
     * For advertisement purposes
     *
     * @param preferredCategoryNames
     * @param preferredPrice
     * @param preferredProductPoints
     * @return
     */
    public List<Product> customerTargetedProducts(List<String> preferredCategoryNames, List<Double> preferredPrice, List<Integer> preferredProductPoints) {

        //TODO Here we will combine the input info in order to query the DB and take products that matches  customer's profile.
        return null;
    }

    /**
     * Cache some info in order to make app faster and do not query the database every time
     * @param colour
     * @return
     */
    @Cacheable(value = "productsWithColour", cacheManager = "CacheManager", sync = true)
    public List<Integer> determineProductIdsByColour(String colour){
        return null;
    }

}
