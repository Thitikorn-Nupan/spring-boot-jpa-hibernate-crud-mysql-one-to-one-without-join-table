package com.ttknpdev.exceptions.configuration;

import com.ttknpdev.constant.CommonStatus;
import com.ttknpdev.entity.ResponseObject;
import com.ttknpdev.exceptions.handler.ContentNotAllowed;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {

    /*
        remember it will work after you throw it
        Like. return ... orElseThrow(throw new NotAllowed("There is not exist"))
        Just throw your handler will be enough
    */
    @ExceptionHandler(value = ContentNotAllowed.class)
    private ResponseEntity<ResponseObject> getNotAllowed(ContentNotAllowed contentNotAllowed){
        // configException.info("getNotAllowedMethod(NotAllowedMethod) method is working");
        return ResponseEntity
                .status((short) CommonStatus.UNACCEPTED[0])
                .body(ResponseObject
                        .<String>builder()
                        .status((short) CommonStatus.UNACCEPTED[0])
                        .info((String) CommonStatus.UNACCEPTED[1])
                        .data("Cause : "+ contentNotAllowed.getCurrentCause())
                        .build());
    }

}
