package partner.api.bri.co.id.handler;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {

    public int status;
    public String message;
    public String[] errors;
}
