package partner.api.bri.co.id.cardtokenotp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import partner.api.bri.co.id.response.ResponseOTP;

@Service
public class CardTokenOTPService {

    @Autowired
    Environment env;

    public ResponseEntity<ResponseOTP> createTokenOTP(CardTokenOTPRequest cardTokenOTPRequest) {
        CardTokenOTPResponse cardTokenOTPResponse = new CardTokenOTPResponse();
        ResponseEntity<ResponseOTP> res;

        String card_pan = cardTokenOTPRequest.getCard_pan();
        String errCode = card_pan.substring(card_pan.length() - 4);
        String errMsg = env.getProperty("err.code." + errCode);

        if (errMsg != null) {
            cardTokenOTPResponse.setStatus(errMsg);
            res = setResponse(HttpStatus.OK, cardTokenOTPResponse);
        } else {
            cardTokenOTPResponse.setStatus("PENDING_USER_VERIFICATION");
            cardTokenOTPResponse.setToken("TOK_CBF6XTIWO4HKQ3LJ2QPAGW445LORLPF5");
            res = setResponse(HttpStatus.BAD_REQUEST, cardTokenOTPResponse);
        }

        return res;
    }

    private ResponseEntity<ResponseOTP> setResponse(HttpStatus httpStatus, CardTokenOTPResponse cardTokenOTPResponse) {
        ResponseOTP response = new ResponseOTP();
        response.setBody(cardTokenOTPResponse);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
    }

}
