package io.hardplant.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-08-21T16:50:57.917+09:00[Asia/Seoul]")

@Controller
@RequestMapping("${openapi.matchmaker.base-path:/matchmaker/v1}")
public class MatchApiController implements MatchApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public MatchApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
