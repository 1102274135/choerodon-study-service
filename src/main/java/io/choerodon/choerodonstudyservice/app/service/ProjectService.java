package io.choerodon.choerodonstudyservice.app.service;

import io.choerodon.choerodonstudyservice.infra.dto.ProjectDTO;

import java.util.List;

public interface ProjectService {
    ProjectDTO insertProject(ProjectDTO projectDTO);
    ProjectDTO selectProjectById(long id);
    List<ProjectDTO> getProjectsByOid(long oid,int page);
}
