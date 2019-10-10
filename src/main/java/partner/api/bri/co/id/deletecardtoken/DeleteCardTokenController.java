package partner.api.bri.co.id.deletecardtoken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import partner.api.bri.co.id.response.ResponseOTP;

@RestController
@RequestMapping(value = "sandbox/v1/directdebit/tokens")
public class DeleteCardTokenController {

    @Autowired
    DeleteCardTokenService deleteCardTokenService;

    @DeleteMapping
    public ResponseEntity<ResponseOTP> deleteToken(@RequestBody DeleteCardTokenRequest deleteCardTokenRequest) {
        return deleteCardTokenService.deleteTokenOTP(deleteCardTokenRequest);
    }
}
