package partner.api.bri.co.id.cardtokenotp;

import lombok.Data;

@Data
public class CardTokenOTPRequest {

    private String card_pan;
    private String phone_number;
    private String email;
}
