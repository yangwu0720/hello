package cn.edu.zafu.subjectbuild.user.service.impl;

import cn.edu.zafu.subjectbuild.user.entity.UserEntity;
import cn.edu.zafu.subjectbuild.user.mapper.UserMapper;
import cn.edu.zafu.subjectbuild.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cyk
 * @since 2020-04-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

}
