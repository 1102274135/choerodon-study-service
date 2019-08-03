package io.choerodon.choerodonstudyservice.api.controller.v1;

import io.choerodon.base.annotation.Permission;
import io.choerodon.base.enums.ResourceType;
import io.choerodon.choerodonstudyservice.app.service.UserService;
import io.choerodon.choerodonstudyservice.infra.dto.OrganizationDTO;
import io.choerodon.choerodonstudyservice.infra.dto.UserDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/aim/{organization_id}/{user_id}")
    @Permission(type = ResourceType.SITE)
    @ApiOperation(value = "从aim中获取User并插入")
    public ResponseEntity<UserDTO> insertOrganizationFromAim(@PathVariable("organization_id") long oid, @PathVariable("user_id") long uid){
        return new ResponseEntity<>(userService.insertUserFromAim(oid,uid), HttpStatus.OK);
    }

    @GetMapping("/{organization_id}/users/{user_id}")
    @Permission(type = ResourceType.SITE)
    @ApiOperation(value = "根据id获取Oraganization")
    public ResponseEntity<UserDTO> getOrganization(@PathVariable(value = "organization_id") long oid,@PathVariable(value = "user_id")long uid) {
        UserDTO userDTO=userService.selectUserByOidAndUid(oid,uid);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }



}
