/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (4.1.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package io.hardplant.api;

import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-08-21T16:50:57.917+09:00[Asia/Seoul]")

@Validated
@Api(value = "match", description = "the match API")
public interface MatchApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    @ApiOperation(value = "", nickname = "matchGet", notes = "register and match", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK") })
    @RequestMapping(value = "/match",
        method = RequestMethod.GET)
    default ResponseEntity<String> matchGet() {
    	
    	
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
