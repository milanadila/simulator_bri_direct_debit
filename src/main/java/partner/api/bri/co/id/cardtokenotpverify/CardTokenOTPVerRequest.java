package partner.api.bri.co.id.cardtokenotpverify;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class CardTokenOTPVerRequest {

    @NotEmpty(message = "must be filled")
    @NotNull(message = "cannot null")
    private String registration_token;


    @NotEmpty(message = "cannot null")
    @NotNull(message = "must be filled")
    @Length(min = 6, message = "min 6 character")
    private String passcode;
}
