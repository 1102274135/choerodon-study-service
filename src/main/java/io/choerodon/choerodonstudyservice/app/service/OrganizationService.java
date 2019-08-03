package io.choerodon.choerodonstudyservice.app.service;

import io.choerodon.choerodonstudyservice.infra.dto.OrganizationDTO;

public interface OrganizationService {
      OrganizationDTO insertOrganizationFromAim(long id);
      OrganizationDTO selectOrganizationById(long id);
}
