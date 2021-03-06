package com.david.sys.controller.syssetting;

import com.david.common.BaseController;
import com.david.common.Page;
import com.david.common.utils.CacheUtils;
import com.david.common.utils.JStringUtils;
import com.david.sys.entity.Config;
import com.david.sys.service.ConfigService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 公共配置表 控制器
 *
 * @author david.cn
 * @version 1.0
 */
@Controller
@RequestMapping("${adminPath}/sys/config")
public class ConfigController extends BaseController {

    @Autowired
    private ConfigService configService;

    @ModelAttribute
    public Config get(@RequestParam(required = false) String id) {
        Config entity = null;
        if (JStringUtils.isNotBlank(id)) {
            entity = configService.get(id);
        }
        if (entity == null) {
            entity = new Config();
        }
        return entity;
    }

    @RequiresPermissions("sys:config:view")
    @RequestMapping()
    public String list(Config config, Model model, Page<Config> page) {
        page.setEntity(config);
        model.addAttribute("page", page.setList(configService.findPage(page)));
        return "sys/config/list";
    }

    @RequiresPermissions("sys:config:create")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Config config, Model model) {
        model.addAttribute("config", config);
        return "sys/config/form";
    }

    @RequiresPermissions("sys:config:create")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Config config, RedirectAttributes redirectAttributes) {
        configService.save(config);
        addMessage(redirectAttributes, "Success");
        return "redirect:" + adminPath + "/sys/config/update?id=" + config.getId();
    }

    @RequiresPermissions("sys:config:update")
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String update(Config config, Model model) {
        model.addAttribute("config", config);
        return "sys/config/form";
    }

    @RequiresPermissions("sys:config:update")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Config config, RedirectAttributes redirectAttributes) {
        configService.save(config);
        CacheUtils.remove(config.getSysName() + config.getModuleName() + config.getConfigName());
        addMessage(redirectAttributes, "Success");
        return "redirect:" + adminPath + "/sys/config/update?id=" + config.getId();
    }

    @RequiresPermissions("sys:config:delete")
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable("id") String id, int pageNo, int pageSize, RedirectAttributes redirectAttributes) {
        Config config = configService.get(id);
        configService.delete(config);
        CacheUtils.remove(config.getSysName() + config.getModuleName() + config.getConfigName());
        addMessage(redirectAttributes, "Success Delete");
        return "redirect:" + adminPath + "/sys/config?pageNo=" + pageNo + "&pageSize=" + pageSize;
    }
}
