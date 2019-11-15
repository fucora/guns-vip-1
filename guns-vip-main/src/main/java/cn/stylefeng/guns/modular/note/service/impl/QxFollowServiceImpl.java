package cn.stylefeng.guns.modular.note.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.note.entity.QxFollow;
import cn.stylefeng.guns.modular.note.mapper.QxFollowMapper;
import cn.stylefeng.guns.modular.note.model.params.QxFollowParam;
import cn.stylefeng.guns.modular.note.model.result.QxFollowResult;
import  cn.stylefeng.guns.modular.note.service.QxFollowService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 用户关注关系表 服务实现类
 * </p>
 *
 * @author 
 * @since 2019-11-14
 */
@Service
public class QxFollowServiceImpl extends ServiceImpl<QxFollowMapper, QxFollow> implements QxFollowService {

    @Override
    public void add(QxFollowParam param){
        QxFollow entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(QxFollowParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(QxFollowParam param){
        QxFollow oldEntity = getOldEntity(param);
        QxFollow newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public QxFollowResult findBySpec(QxFollowParam param){
        return null;
    }

    @Override
    public List<QxFollowResult> findListBySpec(QxFollowParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(QxFollowParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(QxFollowParam param){
        return param.getId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private QxFollow getOldEntity(QxFollowParam param) {
        return this.getById(getKey(param));
    }

    private QxFollow getEntity(QxFollowParam param) {
        QxFollow entity = new QxFollow();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}