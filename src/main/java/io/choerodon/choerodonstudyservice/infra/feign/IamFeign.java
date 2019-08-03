package io.choerodon.choerodonstudyservice.infra.feign;

import io.choerodon.choerodonstudyservice.infra.dto.OrganizationDTO;
import io.choerodon.choerodonstudyservice.infra.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "iam-service")
public interface IamFeign {
      @GetMapping("/v1/organizations/{organization_id}")
      OrganizationDTO getOranization(@PathVariable("organization_id") long orgId);

      @GetMapping("/v1/organizations/{organization_id}/users/{user_id}")
      UserDTO getUser(@PathVariable("organization_id") long orgId,@PathVariable("user_id") long uid);

}
