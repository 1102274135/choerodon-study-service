package io.choerodon.choerodonstudyservice.api.controller.v1;

import io.choerodon.base.annotation.Permission;
import io.choerodon.base.enums.ResourceType;
import io.choerodon.choerodonstudyservice.app.service.ProjectService;
import io.choerodon.choerodonstudyservice.infra.dto.ProjectDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/projects/{id}")
    @Permission(type = ResourceType.SITE)
    @ApiOperation(value = "根据id获取project")
    public ResponseEntity<ProjectDTO> getProjectById(long id){
        return new ResponseEntity<>(projectService.selectProjectById(id), HttpStatus.OK);
    }

    @GetMapping("orgaizations/{organization_id}/projects")
    @Permission(type = ResourceType.SITE)
    @ApiOperation(value = "根据organization_id获取projects并分页")
    public List<ProjectDTO> getProjectsByOrgaizationId(@PathVariable("organization_id") long oid, @RequestParam("page")int page){
            return projectService.getProjectsByOid(oid,page);
    }
}
