package io.choerodon.choerodonstudyservice.app.service.impl;

import io.choerodon.choerodonstudyservice.app.service.UserService;
import io.choerodon.choerodonstudyservice.infra.dto.UserDTO;
import io.choerodon.choerodonstudyservice.infra.feign.IamFeign;
import io.choerodon.choerodonstudyservice.infra.mapper.OrgaizationMapper;
import io.choerodon.choerodonstudyservice.infra.mapper.UserMapper;
import io.choerodon.core.exception.CommonException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private IamFeign iamFeign;

    private UserMapper userMapper;
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper =userMapper;
    }
    public UserDTO insertUserFromAim(long oid, long uid) {
        UserDTO userDTO= iamFeign.getUser(oid,uid);
        int i=userMapper.insert(userDTO);
        if(i!=1){
            throw new CommonException("数据插入失败");
        }
        return userDTO;
    }


    public UserDTO selectUserByOidAndUid(long oid, long uid) {
          UserDTO userDTO=new UserDTO();
          userDTO.setId(uid);
          userDTO.setOrganizationId(oid);
          return userMapper.selectOne(userDTO);
    }

}
