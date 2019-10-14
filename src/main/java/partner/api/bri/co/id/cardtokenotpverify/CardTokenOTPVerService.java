package partner.api.bri.co.id.cardtokenotpverify;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import partner.api.bri.co.id.response.ResponseOTP;

@Service
public class CardTokenOTPVerService {

    @Autowired
    Environment env;

    public ResponseEntity<ResponseOTP> createTokenVer(CardTokenOTPVerRequest cardTokenOTPVerRequest) {
        CardTokenOTPVerResponse cardTokenOTPVerResponse = new CardTokenOTPVerResponse();
        Location location = new Location();
        Metadata metadata = new Metadata();
        ResponseEntity<ResponseOTP> res;

        String pas_code = cardTokenOTPVerRequest.getPasscode();
        String errCode = pas_code.substring(pas_code.length() - 4);
        String errMsg = env.getProperty("err.code." + errCode);

        if (errMsg != null) {
            cardTokenOTPVerResponse.setStatus(errCode);
            res = setResponse(HttpStatus.BAD_REQUEST, cardTokenOTPVerResponse);
        } else {
            cardTokenOTPVerResponse.setStatus("0000");
            cardTokenOTPVerResponse.setPhone_number("6285641403241");
            cardTokenOTPVerResponse.setDevice_id("09864ADCASA");
            cardTokenOTPVerResponse.setCard_token("card_.eyJleHAiOjE2ODU0OTExOTksImlhdCI6MTU0MDE5Nj" +
                    "UwMCwiaXNzIjoiQmFuayBCUkkgLSBEQ0UiLCJqdGkiOiJhMGM2MjlhNS1hYWI5L" +
                    "TQ5OWMtODg5MS0yNzA1NDg3NGRmYWUiLCJuYmYiOjE1NDAxOTY1MDEsInBhcnRuZXJJZCI6Iu-" +
                    "_vSIsInNlcnZpY2VOYW1lIjoiRERfRVhURVJOQUxfU0VSVklDRSJ9.hceS_BQtzCIyMJCVMMvPWSf" +
                    "TvqIrW9TIL9arAUi95e-P6Kq9bvmQNuGLcfV6GLnQEc07fKF6IbaLLkUquEm2iDfsP1HMLv_crXiF9s" +
                    "nwzqzTk5vJqYvLmRGDqhZk-tFw-MwX0NW-op2iyRUhwSTB7rCNVOyfeIGfif7dKpu2PdFT98VUimnsKRWqH" +
                    "jAR7uCVKXweDbfKVpLHpgcR914MvSthqt4a7eHzUxm6o6eqyjQjf_vkQi4Fl_iG98JOVuzVuXft5P50QKcKwAh" +
                    "nrIiGMC-Vd4DZWQ1rMVbx1iSLvGzBrR1xm3wIYYlmyR0pUVlDdGaE04N1Gz_dvcsgx15Ecw");
            location.setLat("");
            location.setLon("");
            cardTokenOTPVerResponse.setLocation(location);
            cardTokenOTPVerResponse.setLast4("1198");
            cardTokenOTPVerResponse.setEmail("test@test.com");
            metadata.setExample1("example1");
            cardTokenOTPVerResponse.setMetadata(metadata);
            cardTokenOTPVerResponse.setCard_type("PVRGLR");
            cardTokenOTPVerResponse.setLimit_transaction("");
            res = setResponse(HttpStatus.OK, cardTokenOTPVerResponse);
        }
        return res;
    }

    private ResponseEntity<ResponseOTP> setResponse(HttpStatus httpStatus, CardTokenOTPVerResponse cardTokenOTPVerResponse) {
        ResponseOTP response = new ResponseOTP();
        response.setBody(cardTokenOTPVerResponse);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
    }
}
