package partner.api.bri.co.id.cardtokenotpverify;

import lombok.Data;

@Data
public class CardTokenOTPVerRequest {

    private String registration_token;
    private Integer passcode;
}
