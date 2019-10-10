package partner.api.bri.co.id.cardtokenotpverify;

import lombok.Data;

@Data
public class CardTokenOTPVerResponse {

    private String status;
    private String phone_number;
    private String device_id;
    private String card_token;
    private Location location;
    private String last4;
    private String email;
    private Metadata metadata;
    private String card_type;
    private String limit_transaction;
}
