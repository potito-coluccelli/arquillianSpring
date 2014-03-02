package org.yukkasource.arquillianSpring.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.yukkasource.arquillianSpring.beans.Result;

/**
 * Created by tito on 3/2/14.
 */
@RestController
public class RestService {
    @RequestMapping(value = "/restService",method= RequestMethod.GET,produces={"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public Result helloService(
            @RequestParam(value="param", required=true) String param){
        return new Result(param);
    }
}
