package com.site.woolencreations.valuation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    private Date date;

//    public void setDate(Date date) throws ParseException {
//        date = new Date();
//        this.date = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(date));
//    }
}
//INSERT INTO VALUATION VALUES ('Bad choice', 1, 2, 1);