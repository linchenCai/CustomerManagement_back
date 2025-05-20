package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.pojo.Menus;
import com.example.demo.service.MenusService;
import com.example.demo.mapper.MenusMapper;
import com.example.demo.vo.MenusVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @author 24123
 * @description 针对表【t_menus】的数据库操作Service实现
 * @createDate 2025-05-13 14:33:12
 */
@Service
public class MenusServiceImpl extends ServiceImpl<MenusMapper, Menus>
        implements MenusService {

    // MenusMapper 可以通过 baseMapper 字段从 ServiceImpl 继承，或者显式注入
     @Autowired
    private MenusMapper menusMapper; // 如果不使用 baseMapper，则需要这个

    @Override
    public List<MenusVo> queryMenuListService() {
        // 1. 查询所有菜单数据
        // 使用 ServiceImpl 提供的 list() 方法，它会调用 baseMapper.selectList(null)
        List<Menus> allMenus = this.list(); // 或者 menusMapper.selectList(null)

        // 2. 构建菜单树，通常从根节点开始 (例如 pid 为 0 或 null 的节点)
        // 假设顶级菜单的 pid 为 0。如果您的顶级菜单 pid 为 null，请将 0 改为 null
        // 并注意 Integer 比较时 null 的处理。
        // 为简单起见，这里假设 pid=0 为根节点，并且 pid 字段在数据库中对于根节点是 0 而不是 NULL。
        // 如果 pid 可能是 null，那么 buildSubMenus 方法中的 equals 比较需要处理 null 情况。
        return buildSubMenus(allMenus, 0);
    }

    @Override
    public void saveMenusService(Menus menus) {
        QueryWrapper<Menus> wrapper = new QueryWrapper<>();
        wrapper.select("max(component) maxv");
        //获得component的最大值
        Menus ms = menusMapper.selectOne(wrapper);
        //component组件属性的值，是数据库最大值加1
        menus.setComponent(ms.getMaxv()+1);
        menusMapper.insert(menus);
    }
    /**
     * 递归构建子菜单树
     *
     * @param allMenus 所有菜单的列表
     * @param parentId 当前要查找的父菜单ID
     * @return 指定父菜单ID下的子菜单树列表
     */
    private List<MenusVo> buildSubMenus(List<Menus> allMenus, Integer parentId) {
        List<MenusVo> subMenusTree = new ArrayList<>();

        for (Menus menu : allMenus) {
            // 检查当前菜单的父ID是否与传入的parentId匹配
            // 注意：如果 parentId 可能为 null，或者 menu.getPid() 可能为 null，需要更健壮的比较
            // 例如： (parentId == null && menu.getPid() == null) || (parentId != null && parentId.equals(menu.getPid()))
            // 这里简化为：假定根节点的 parentId 是 0，且所有菜单都有 pid。
            if (menu.getPid() != null && menu.getPid().equals(parentId)) {
                MenusVo menusVo = new MenusVo();
                BeanUtils.copyProperties(menu, menusVo); // 将 POJO属性 复制到 VO

                // 递归查找当前菜单的子菜单
                menusVo.setSubMenus(buildSubMenus(allMenus, menu.getId()));
                subMenusTree.add(menusVo);
            }
        }
        return subMenusTree;
    }
}



