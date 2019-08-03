package io.choerodon.choerodonstudyservice.app.service.impl;

import io.choerodon.choerodonstudyservice.app.service.OrganizationService;
import io.choerodon.choerodonstudyservice.app.service.ProjectService;
import io.choerodon.choerodonstudyservice.infra.dto.OrganizationDTO;
import io.choerodon.choerodonstudyservice.infra.dto.ProjectDTO;
import io.choerodon.choerodonstudyservice.infra.feign.IamFeign;
import io.choerodon.choerodonstudyservice.infra.mapper.OrgaizationMapper;
import io.choerodon.core.exception.CommonException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {
    @Autowired
    private IamFeign iamFeign;

    private OrgaizationMapper orgaizationMapper;
    @Autowired
    private ProjectService projectService;

    public OrganizationServiceImpl(OrgaizationMapper orgaizationMapper) {
        this.orgaizationMapper = orgaizationMapper;
    }

    public OrganizationDTO insertOrganizationFromAim(long id) {
        OrganizationDTO organizationDTO= iamFeign.getOranization(id);
        List<ProjectDTO> pros=organizationDTO.getProjects();
        pros.forEach(projectService::insertProject);
        int i=orgaizationMapper.insert(organizationDTO);
        if(i!=1){
            throw new CommonException("数据插入失败");
        }
        return  organizationDTO;
    }

    public OrganizationDTO selectOrganizationById(long id) {
           OrganizationDTO organizationDTO=new OrganizationDTO();
           organizationDTO.setId(id);
           return orgaizationMapper.selectByPrimaryKey(organizationDTO);
    }
}
