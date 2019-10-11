package partner.api.bri.co.id.deletecardtoken;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class DeleteCardTokenRequest {

    @NotEmpty(message = "must be filled")
    @NotNull(message = "cannot null")
    private String card_token;
}
