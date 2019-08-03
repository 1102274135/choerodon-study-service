package io.choerodon.choerodonstudyservice.app.service.impl;

import com.github.pagehelper.PageHelper;
import io.choerodon.choerodonstudyservice.app.service.ProjectService;
import io.choerodon.choerodonstudyservice.infra.dto.ProjectDTO;
import io.choerodon.choerodonstudyservice.infra.mapper.ProjectMapper;
import io.choerodon.choerodonstudyservice.infra.mapper.UserMapper;
import io.choerodon.core.exception.CommonException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    public static final int PAGE_SIZE=5;
    private ProjectMapper projectMapper;
    public ProjectServiceImpl(ProjectMapper projectMapper) {
        this.projectMapper =projectMapper;
    }

    public ProjectDTO insertProject(ProjectDTO projectDTO) {
        int i=projectMapper.insertSelective(projectDTO);
        if(i!=1){
            throw new CommonException("数据插入失败");
        }
        return projectDTO;
    }

    public ProjectDTO selectProjectById(long id) {
        return projectMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ProjectDTO> getProjectsByOid(long oid, int page) {
        PageHelper.startPage(page,ProjectServiceImpl.PAGE_SIZE);
        ProjectDTO projectDTO=new ProjectDTO();
        projectDTO.setOrganizationId(oid);
        return projectMapper.select(projectDTO);
    }
}
