package com.site.woolencreations.misc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Table(name = "CATEGORY")
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Category {
    @Id
    @SequenceGenerator(
            name = "category_sequence",
            sequenceName = "category_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "category_sequence"
    )
    private int categoryId;
    private String categoryName;
    private String subCategory;
}


//INSERT INTO Category (CATEGORY_ID, CATEGORY_NAME, ITEM, SUB_CATEGORY) VALUES (1, 'Men', 'Hat', 'Accessories ');
//INSERT INTO Category (CATEGORY_ID, CATEGORY_NAME, ITEM, SUB_CATEGORY) VALUES (2, 'Men', 'Scarf', 'Accessories ');
//INSERT INTO Category (CATEGORY_ID, CATEGORY_NAME, ITEM, SUB_CATEGORY) VALUES (3, 'Men', 'Gloves', 'Accessories ' );
//INSERT INTO Category (CATEGORY_ID, CATEGORY_NAME, ITEM, SUB_CATEGORY) VALUES (4, 'Men', 'Clasp', 'Accessories ' );
//INSERT INTO Category (CATEGORY_ID, CATEGORY_NAME, ITEM, SUB_CATEGORY) VALUES (5, 'Men', 'Sweaters', 'Clothes ');
//INSERT INTO Category (CATEGORY_ID, CATEGORY_NAME, ITEM, SUB_CATEGORY) VALUES (6, 'Men', 'Jacket', 'Clothes ');
//INSERT INTO Category (CATEGORY_ID, CATEGORY_NAME, ITEM, SUB_CATEGORY) VALUES (7, 'Men', 'Socks', 'Underwear ');
//INSERT INTO Category (CATEGORY_ID, CATEGORY_NAME, ITEM, SUB_CATEGORY) VALUES (8, 'Women', 'Hat', 'Accessories');
//INSERT INTO Category (CATEGORY_ID, CATEGORY_NAME, ITEM, SUB_CATEGORY) VALUES (9, 'Women', 'Scarf', 'Accessories');
//INSERT INTO Category (CATEGORY_ID, CATEGORY_NAME, ITEM, SUB_CATEGORY) VALUES (10, 'Women', 'Gloves', 'Accessories');
//INSERT INTO Category (CATEGORY_ID, CATEGORY_NAME, ITEM, SUB_CATEGORY) VALUES (11, 'Women', 'Bohemian toe cap', 'Accessories');
//INSERT INTO Category (CATEGORY_ID, CATEGORY_NAME, ITEM, SUB_CATEGORY) VALUES (12, 'Women', 'Headbands', 'Accessories');
//INSERT INTO Category (CATEGORY_ID, CATEGORY_NAME, ITEM, SUB_CATEGORY) VALUES (13, 'Women', 'Earrings', 'Accessories');
//INSERT INTO Category (CATEGORY_ID, CATEGORY_NAME, ITEM, SUB_CATEGORY) VALUES (14, 'Women', 'Bracelet', 'Accessories');
//INSERT INTO Category (CATEGORY_ID, CATEGORY_NAME, ITEM, SUB_CATEGORY) VALUES (15, 'Women', 'Necklaces', 'Accessories');
//INSERT INTO Category (CATEGORY_ID, CATEGORY_NAME, ITEM, SUB_CATEGORY) VALUES (16, 'Women', 'Clasp', 'Accessories');
//INSERT INTO Category (CATEGORY_ID, CATEGORY_NAME, ITEM, SUB_CATEGORY) VALUES (17, 'Women', 'Skirts', 'Clothes');
//INSERT INTO Category (CATEGORY_ID, CATEGORY_NAME, ITEM, SUB_CATEGORY) VALUES (18, 'Women', 'Sweaters', 'Clothes');
//INSERT INTO Category (CATEGORY_ID, CATEGORY_NAME, ITEM, SUB_CATEGORY) VALUES (19, 'Women', 'Jacket', 'Clothes');
//INSERT INTO Category (CATEGORY_ID, CATEGORY_NAME, ITEM, SUB_CATEGORY) VALUES (20, 'Women', 'Socks', 'Underwear');
//INSERT INTO Category (CATEGORY_ID, CATEGORY_NAME, ITEM, SUB_CATEGORY) VALUES (21, 'Women', 'Bra', 'Underwear');
//INSERT INTO Category (CATEGORY_ID, CATEGORY_NAME, ITEM, SUB_CATEGORY) VALUES (22, 'Kids', 'Hat', 'Accessories');
//INSERT INTO Category (CATEGORY_ID, CATEGORY_NAME, ITEM, SUB_CATEGORY) VALUES (23, 'Kids', 'Scarf', 'Accessories');
//INSERT INTO Category (CATEGORY_ID, CATEGORY_NAME, ITEM, SUB_CATEGORY) VALUES (24, 'Kids', 'Gloves', 'Accessories');
//INSERT INTO Category (CATEGORY_ID, CATEGORY_NAME, ITEM, SUB_CATEGORY) VALUES (25, 'Kids', 'Toys', 'Accessories');
//INSERT INTO Category (CATEGORY_ID, CATEGORY_NAME, ITEM, SUB_CATEGORY) VALUES (26, 'Kids', 'Clasp', 'Accessories');
//INSERT INTO Category (CATEGORY_ID, CATEGORY_NAME, ITEM, SUB_CATEGORY) VALUES (27, 'Kids', 'Skirts', 'Clothes');
//INSERT INTO Category (CATEGORY_ID, CATEGORY_NAME, ITEM, SUB_CATEGORY) VALUES (28, 'Kids', 'Sweaters', 'Clothes');
//INSERT INTO Category (CATEGORY_ID, CATEGORY_NAME, ITEM, SUB_CATEGORY) VALUES (29, 'Kids', 'Jacket', 'Clothes');
//INSERT INTO Category (CATEGORY_ID, CATEGORY_NAME, ITEM, SUB_CATEGORY) VALUES (30, 'Kids', 'Socks', 'Underwear');
//INSERT INTO Category (CATEGORY_ID, CATEGORY_NAME, ITEM, SUB_CATEGORY) VALUES (31, 'Home', 'Blankets', 'Bedroom');
//INSERT INTO Category (CATEGORY_ID, CATEGORY_NAME, ITEM, SUB_CATEGORY) VALUES (32, 'Home', 'Bottle case', 'Kitchen');
//INSERT INTO Category (CATEGORY_ID, CATEGORY_NAME, ITEM, SUB_CATEGORY) VALUES (33, 'Home', 'Christmas decorations', 'Decoration');

//Products: Hat, Scarf, Gloves, Clasp, Sweaters, Jackets, Socks, Bohemian toe cap, Headbands, Earrings,
//          Bracelet, Necklaces, Skirts, Bra, Toys, Blankets, Bottle case, Christmas decorations

//INSERT INTO Category (CATEGORY_ID, CATEGORY_NAME) VALUES ('Men');
//INSERT INTO Category (CATEGORY_ID, CATEGORY_NAME) VALUES ('Women');
//INSERT INTO Category (CATEGORY_ID, CATEGORY_NAME) VALUES ('Kids');
//INSERT INTO Category (CATEGORY_ID, CATEGORY_NAME) VALUES ('Home');
//INSERT INTO Category (CATEGORY_ID, CATEGORY_NAME) VALUES ('Accessories');
//INSERT INTO Category (CATEGORY_ID, CATEGORY_NAME) VALUES ('Clothes');
//INSERT INTO Category (CATEGORY_ID, CATEGORY_NAME) VALUES ('Underwear');
//INSERT INTO Category (CATEGORY_ID, CATEGORY_NAME) VALUES ('Bedroom');
//INSERT INTO Category (CATEGORY_ID, CATEGORY_NAME) VALUES ('Kitchen');
//INSERT INTO Category (CATEGORY_ID, CATEGORY_NAME) VALUES ('Decoration');

