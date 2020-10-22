package pl.kk.tacocloud.models;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Order {

    private Long id;
    private Date placedAt;
    @NotBlank(message = "Fist name and last name are obligatory!")
    private String name;
    @NotBlank(message = "Street field is obligatory!")
    private String street;
    @NotBlank(message = "City field is obligatory!")
    private String city;
    @NotBlank(message = "State field is obligatory!")
    private String state;
    @NotBlank(message = "Zip Code field is obligatory!")
    private String zip;
    @CreditCardNumber(message = "This is not a valid number of credit card!")
    private String ccNumber;
    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$", message = "Value must me in \"MM/YY\" format!")
    private String ccExpiration;
    @Digits(integer = 3, fraction = 0, message = "Invalid CVV Code!")
    private String ccCVV;

    private List<Taco> tacos = new ArrayList<>();

    public void addDesign(Taco design) {
        tacos.add(design);
    }

}
