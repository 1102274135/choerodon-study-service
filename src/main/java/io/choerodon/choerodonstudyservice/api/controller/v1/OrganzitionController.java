package io.choerodon.choerodonstudyservice.api.controller.v1;

import io.choerodon.base.annotation.Permission;
import io.choerodon.base.enums.ResourceType;
import io.choerodon.choerodonstudyservice.app.service.OrganizationService;
import io.choerodon.choerodonstudyservice.infra.dto.OrganizationDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/organizations")
public class OrganzitionController {
    @Autowired
    private OrganizationService organizationService;

    @PostMapping("/aim/{id}")
    @Permission(type = ResourceType.SITE)
    @ApiOperation(value = "从aim中获取Organization并插入")
    public ResponseEntity<OrganizationDTO> insertOrganizationFromAim(@PathVariable(value = "id") long id){
        OrganizationDTO organizationDTO=organizationService.insertOrganizationFromAim(id);
        System.out.println(organizationDTO);
        return new ResponseEntity<>(organizationDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Permission(type = ResourceType.SITE)
    @ApiOperation(value = "根据id获取Oraganization")
    public ResponseEntity<OrganizationDTO> getOrganization(@PathVariable(value = "id") long id){

        return new ResponseEntity<>(organizationService.selectOrganizationById(id), HttpStatus.OK);
    }



}
