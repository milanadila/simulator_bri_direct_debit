package partner.api.bri.co.id.cardtokenotp;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class CardTokenOTPRequest {

    @Length(max = 16, message = "max 16 character")
    @NotEmpty(message = "must be filled")
    @NotNull(message = "cannot null")
    private String card_pan;

    @Length(max = 15, message = "max 15 character")
    @NotEmpty(message = "must be filled")
    @NotNull(message = "cannot null")
    private String phone_number;

    @Length(max = 50, message = "max 50 character")
    @NotEmpty(message = "must be filled")
    @NotNull(message = "cannot null")
    private String email;
}
