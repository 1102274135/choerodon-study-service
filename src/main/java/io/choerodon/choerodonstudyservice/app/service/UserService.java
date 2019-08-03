package io.choerodon.choerodonstudyservice.app.service;

import io.choerodon.choerodonstudyservice.infra.dto.UserDTO;

public interface UserService {
    UserDTO insertUserFromAim(long oid,long uid);
    UserDTO selectUserByOidAndUid(long oid,long uid);
}
