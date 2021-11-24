package com.site.woolencreations.misc;

import com.site.woolencreations.product.Product;
import com.site.woolencreations.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "VALUATION")
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Valuation implements Serializable {
    @EmbeddedId
    private ValuationId id;
    private String description;
    private int stars;


}
