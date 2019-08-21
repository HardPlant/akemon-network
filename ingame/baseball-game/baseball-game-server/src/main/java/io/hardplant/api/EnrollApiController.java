package io.hardplant.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-08-21T09:44:01.659+09:00[Asia/Seoul]")

@Controller
@RequestMapping("${openapi.baseballGame.base-path:/baseball-game/v1}")
public class EnrollApiController implements EnrollApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public EnrollApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
