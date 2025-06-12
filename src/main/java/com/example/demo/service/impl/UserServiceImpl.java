package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dto.CountResult;
import com.example.demo.mapper.UserRoleMapper;
import com.example.demo.pojo.Menus;
import com.example.demo.pojo.User;
import com.example.demo.pojo.UserRole;
import com.example.demo.service.UserService;
import com.example.demo.mapper.UserMapper;
import com.example.demo.vo.MenusVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author 24123
* @description 针对表【t_user】的数据库操作Service实现
* @createDate 2025-05-19 15:05:50
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    public Map<String,Object> queryUserListService(Integer pageNum, Integer pageSize) {
    Map<String,Object> result = new HashMap<>();
    //指定分页参数
        Page<User>  page = new Page<>(pageNum, pageSize);
        List<User> userList=  userMapper.selectList(page, null);
        result.put("total",page.getTotal());
        result.put("userList",userList);
        return result;
    }
    @Transactional
    @Override
    public void saveUserRolerService(User user) {
        System.out.println("1----"+user.getId());
        //保存用户基本信息后需要获得数据库自增产生的用户id
        userMapper.saveUserMapper(user);
        //获得数据库自增产生的id
        System.out.println("2----"+user.getId());
        Integer uid=user.getId();
        //获得当前用户分配的角色id的集合,从前台提交
        Integer[] rids=user.getRids();
        for(Integer rid:rids){
            //保存用户角色关系表
            UserRole ur=new UserRole();
            ur.setUid(uid);//用户id赋值
            ur.setRid(rid);//角色id赋值
            userRoleMapper.insert(ur);
        }
    }
    @Transactional
    @Override
    public void updateUserRolerService(User user) {
        //删除当前更新用户和角色的所有关系，断开关系
        QueryWrapper<UserRole> del=new QueryWrapper<>();
        del.eq("uid",user.getId());
        userRoleMapper.delete(del);

        //更新用户信息
        userMapper.updateById(user);

        //中间关系表重新添加数据
        Integer[] rids=user.getRids();
        for(Integer rid:rids){
            //保存用户角色关系表
            UserRole ur=new UserRole();
            ur.setUid(user.getId());//用户id赋值
            ur.setRid(rid);//角色id赋值
            userRoleMapper.insert(ur);
        }

    }
    @Transactional
    @Override
    public void deleteUserRoleService(Integer id) {
        //删除用户
        userMapper.deleteById(id);

        //删除当前用户和角色关系表
        QueryWrapper<UserRole> del=new QueryWrapper<>();
        del.eq("uid",id);
        userRoleMapper.delete(del);

    }

    @Override
    public List<CountResult> countEmployeeAgeService() {
       return userMapper.countEmployeeAgeMapper();
    }

    @Override
    public List<CountResult> countEmployeeEduService() {
        return userMapper.countEmployeeEduMapper();
    }
/**
 * 根据用户ID查询菜单列表服务
 * 此方法从数据库中获取用户的菜单权限数据，并组织成树形结构返回
 *
 * @param uid 用户ID，用于查询用户对应的菜单权限
 * @return 返回用户可访问的菜单列表，以树形结构组织
 */
@Override
public List<MenusVo> queryUserMenusListService(Integer uid) {
    // 通过用户ID从数据库中查询用户对应的菜单权限数据
    List<Menus> menus = userMapper.queryUserMenusMapper(uid);
    // 调用私有方法处理菜单数据，生成树形结构的菜单列表
    return doListMenus(menus,0);
}

/**
 * 递归处理菜单列表
 * 此方法通过递归方式构建树形结构的菜单列表
 *
 * @param menus 菜单实体列表，通常从数据库中获取
 * @param id 当前处理的菜单节点的父节点ID，初始调用时通常为0，表示顶级菜单
 * @return 返回以当前父节点ID为基准的子菜单列表
 */
private List<MenusVo> doListMenus(List<Menus> menus,Integer id){
    // 创建集合对象保存返回值
    List<MenusVo> result=new ArrayList<>();
    // 遍历menus集合获得每个菜单节点对象，m每个菜单节点对象
    for(Menus m:menus){
        // m菜单节点对象的父节点id，是否和传入id相等，如果相等说明当前遍历的节点m，是id对应的菜单节点的子节点
        if(m.getPid().equals(id)){
            // 创建MenusVo对象，用于存放转换后的菜单数据
            MenusVo menusVo=new MenusVo();
            // 将菜单数据从Menus对象复制到MenusVo对象
            BeanUtils.copyProperties(m,menusVo);
            // 进行递归遍历，查找当前菜单节点的子节点
            menusVo.setSubMenus(doListMenus(menus,m.getId()));
            // 将处理后的菜单节点添加到结果集合
            result.add(menusVo);
        }
    }
    // 返回结果集合，即树形结构的菜单列表
    return result;
}


}





