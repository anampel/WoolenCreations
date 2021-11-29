package com.site.woolencreations.valuation;

import com.site.woolencreations.product.Product;
import com.site.woolencreations.product.ProductRepository;
import com.site.woolencreations.user.User;
import com.site.woolencreations.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class ValuationService {
    private final ValuationRepository valuationRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public ValuationService(ValuationRepository valuationRepository, UserRepository userRepository, ProductRepository productRepository) {
        this.valuationRepository = valuationRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    public Optional<Valuation> findAllPerProduct(Long prodID) {
        return valuationRepository.findByIdProductId(prodID);
    }


    /**
     * add a valuation only if the user_id and the product_id pair does not exist
     *
     * @param valuation
     */
    public void addValuation(Valuation valuation, Long userId, Long productId) {
        try {
            ValuationId valuationId = new ValuationId();
            Optional<User> user = userRepository.findUserByID(userId);
            Optional<Product> product = productRepository.findProductById(productId);
            valuationId.setProductId(product.get());
            valuationId.setUserId(user.get());
            valuation.setId(valuationId);

            Date date = new Date(System.currentTimeMillis());
            valuation.setDate(date);
            valuationRepository.save(valuation);
        } catch (Exception e) {
            throw new IllegalArgumentException("IllegalArgument returned from findById()");
        }
    }
}
