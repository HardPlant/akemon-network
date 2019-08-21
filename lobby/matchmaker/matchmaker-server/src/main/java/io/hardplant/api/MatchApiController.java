package io.hardplant.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestContextHolder;

import com.google.gson.Gson;

import io.hardplant.matchmaker.service.MatchmakerService;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-08-21T16:50:57.917+09:00[Asia/Seoul]")

@Controller
@RequestMapping("${openapi.matchmaker.base-path:/matchmaker/v1}")
public class MatchApiController implements MatchApi {

	@Resource
	private MatchmakerService mms;
	
    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public MatchApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

	@Override
	public ResponseEntity<String> matchGet() {
		String session = RequestContextHolder.currentRequestAttributes().getSessionId();
		Gson gson = new Gson();
		Map response = new HashMap<String, String>();
		
		mms.register(session);
		try {
			String roomId = mms.match(session).getRoomId();
			response.put("roomId", roomId);
			
			return new ResponseEntity<String>(gson.toJson(response), HttpStatus.OK);
		} catch (InterruptedException e) {
			return new ResponseEntity<>(HttpStatus.OK);			
		}
	}
    
    

}
