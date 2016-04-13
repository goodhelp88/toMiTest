package it.polito.applied.ToMi.controller;

import java.util.List;

import org.hibernate.validator.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.polito.applied.ToMi.exception.BadRequestException;
import it.polito.applied.ToMi.exception.ForbiddenException;
import it.polito.applied.ToMi.pojo.DetectedPosition;
import it.polito.applied.ToMi.service.AppService;


@RestController
public class AppController extends BaseController{
	
	
	@Autowired
	private AppService appService;
	
	@PreAuthorize("hasRole('ROLE_APP')")
	@RequestMapping(value="/v1/position", method=RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void savePosition(@RequestBody List<DetectedPosition> position, @RequestHeader(required=true, value="user") @Email String userEmail) throws BadRequestException, ForbiddenException {
		
	
		for(int i=0; i<position.size(); i++){
			position.get(i).setUserEmail(userEmail);
		}
		appService.saveDetectedPosition(position);
	}
}
