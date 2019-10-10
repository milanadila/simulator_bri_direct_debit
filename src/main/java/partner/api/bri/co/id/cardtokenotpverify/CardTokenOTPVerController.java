package partner.api.bri.co.id.cardtokenotpverify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import partner.api.bri.co.id.response.ResponseOTP;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "sandbox/v1/directdebit/tokens")
public class CardTokenOTPVerController {

    @Autowired
    CardTokenOTPVerService cardTokenOTPVerService;

    @PatchMapping
    public ResponseEntity<ResponseOTP> createTokenVerify(@RequestBody @Valid CardTokenOTPVerRequest cardTokenOTPVerRequest) {
        return cardTokenOTPVerService.createTokenVer(cardTokenOTPVerRequest);
    }
}
