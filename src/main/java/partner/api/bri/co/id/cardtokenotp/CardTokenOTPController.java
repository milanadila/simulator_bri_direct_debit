package partner.api.bri.co.id.cardtokenotp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import partner.api.bri.co.id.response.ResponseOTP;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "sandbox/v1/directdebit/tokens")
public class CardTokenOTPController {

    @Autowired
    CardTokenOTPService cardTokenOTPService;

    @PostMapping
    public ResponseEntity<ResponseOTP> createToken(@RequestBody @Valid CardTokenOTPRequest cardTokenOTPRequest) {
        return cardTokenOTPService.createTokenOTP(cardTokenOTPRequest);
    }
}
