package partner.api.bri.co.id.deletecardtoken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import partner.api.bri.co.id.response.ResponseOTP;

@Service
public class DeleteCardTokenService {

    @Autowired
    Environment env;

    public ResponseEntity<ResponseOTP> deleteTokenOTP(DeleteCardTokenRequest deleteCardTokenRequest) {
        DeleteCardTokenResponse deleteCardTokenResponse = new DeleteCardTokenResponse();
        ResponseEntity<ResponseOTP> res;
        String card_token = deleteCardTokenRequest.getCard_token();
        String errCode = card_token.substring(card_token.length() - 4);
        String errMsg = env.getProperty("err.code." + errCode);

        if (errMsg != null){
            deleteCardTokenResponse.setStatus(errCode);
            res = setResponse(HttpStatus.BAD_REQUEST, deleteCardTokenResponse);
        } else {
            deleteCardTokenResponse.setStatus("0000");
            res = setResponse(HttpStatus.OK, deleteCardTokenResponse);
        }

        return res;
    }

    private ResponseEntity<ResponseOTP> setResponse(HttpStatus httpStatus, DeleteCardTokenResponse deleteCardTokenResponse) {
        ResponseOTP response = new ResponseOTP();
        response.setBody(deleteCardTokenResponse);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
    }
}
