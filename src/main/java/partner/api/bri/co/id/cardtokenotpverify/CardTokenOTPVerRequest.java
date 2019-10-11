package partner.api.bri.co.id.cardtokenotpverify;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CardTokenOTPVerRequest {

    @NotEmpty(message = "must be filled")
    @NotNull(message = "cannot null")
    private String registration_token;


    @NotNull(message = "must be filled")
    private Integer passcode;
}
