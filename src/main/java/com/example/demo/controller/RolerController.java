package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.pojo.RoleMenu;
import com.example.demo.pojo.Roler;
import com.example.demo.service.RoleMenuService;
import com.example.demo.service.RolerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController

public class RolerController {
    @Autowired
    private RolerService rolerService;


    /*处理分页查询请求*/
    @GetMapping("/rolerList")
    public Map<String,Object> rolerList(
            @RequestParam(defaultValue = "1") Integer pageNum
            , @RequestParam(defaultValue = "3") Integer pageSize){
        return rolerService.queryRolePageListService(pageNum,pageSize);
    }
    @PostMapping("/updateRoler")
    @CacheEvict(cacheNames = "roler_cache", allEntries = true)
    public Map<String,Object> updateRoler(@RequestBody Roler roler){
        Map<String, Object> result= new HashMap<>();
        result.put("code",400);
        result.put("msg","操作失败......");
        try {
            rolerService.updateById(roler);
            result.put("code",200);
            result.put("msg","更新角色信息成功...");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
    /*处理角色信息添加的请求*/
    @PostMapping("/saveRoler")
    @CacheEvict(cacheNames = "roler_cache", allEntries = true)
    public Map<String,Object> saveRoler(@RequestBody Roler roler){
     Map<String,Object> result = new HashMap<>();
        result.put("code",400);
        result.put("msg","操作失败.......");
        try{
            rolerService.save(roler);
            result.put("code",200);
            result.put("msg","保存角色信息成功......");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
    /*处理角色信息删除的请求*/
    @GetMapping("/deleteRoler/{id}")
    @CacheEvict(cacheNames = "roler_cache", allEntries = true)
    public Map<String,Object> deleteRoler(@PathVariable Integer id){
        Map<String,Object> result = new HashMap<>();
        result.put("code",400);
        result.put("msg","操作失败.......");
        try{
            //删除角色信息
            rolerService.removeById(id);
            //删除角色和菜单的关联关系
            QueryWrapper<RoleMenu> wrapper = new QueryWrapper<>();
            wrapper.eq("rid",id);
            roleMenuService.remove(wrapper);

            result.put("code",200);
            result.put("msg","删除角色信息成功......");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    @Autowired
    private RoleMenuService  roleMenuService;
    /*处理角色授权请求*/
    @PostMapping("/grantRoleMenus")
    public Map<String,Object> grantRoleMenus(@RequestBody Integer[] ids){
        System.out.println("ids="+ Arrays.toString(ids));
        Map<String,Object> result = new HashMap<>();
        result.put("code",400);
        result.put("msg","操作失败.......");
        try{
            //数组中获得第一个元素，角色id
            Integer rid = ids[0];


            List<RoleMenu> list=new ArrayList<>();
            //for循环遍历
            for(int i=1;i<ids.length;i++){
                //完成角色授权，给角色和菜单的中间关系添加数据，建立关系
                RoleMenu roleMenu = new RoleMenu();
                roleMenu.setRid(rid);
                roleMenu.setMid(ids[i]);
                //将roleMenu对象添加到list集合中
                list.add(roleMenu);
            }
            //先删除该角色原有的所有菜单权限
            QueryWrapper<RoleMenu> wrapper = new QueryWrapper<>();
            wrapper.eq("rid", rid);
            roleMenuService.remove(wrapper);
            //批量添加角色和菜单的中间关系
            roleMenuService.saveBatch(list);//批量添加
            result.put("code",200);
            result.put("msg","角色授权成功......");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
    /*处理根据角色id查询所有菜单id集合*/
    @GetMapping("/loadRoleMid/{rid}")
    public List<Integer> loadRoleMid(@PathVariable Integer rid){
   /*     QueryWrapper<RoleMenu> wrapper = new QueryWrapper<>();
        wrapper.eq("rid",rid);
        wrapper.select("mid");
        List<Integer>result = roleMenuService.listObjs(wrapper);
        return result;*/
return roleMenuService.queryRoleMidsListService(rid);
    }
/*加载所有角色信息，并缓存到 Redis*/
@GetMapping("/loadAllRoles")
@Cacheable(cacheNames = "roler_cache", key = "#root.methodName") // 缓存名为 roler_cache，key 为方法名
public List<Roler> loadAllRoles() {
    QueryWrapper<Roler> wrapper = new QueryWrapper<>();
    wrapper.select("id", "rname");
    List<Roler> list = rolerService.list(wrapper);
    return list;
}

}
