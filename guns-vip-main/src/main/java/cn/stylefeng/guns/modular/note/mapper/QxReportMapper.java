package cn.stylefeng.guns.modular.note.mapper;

import cn.stylefeng.guns.modular.note.entity.QxReport;
import cn.stylefeng.guns.modular.note.model.params.QxReportParam;
import cn.stylefeng.guns.modular.note.model.result.QxReportResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 
 * @since 2019-12-23
 */
public interface QxReportMapper extends BaseMapper<QxReport> {

    /**
     * 获取列表
     *
     * @author 
     * @Date 2019-12-23
     */
    List<QxReportResult> customList(@Param("paramCondition") QxReportParam paramCondition);

    /**
     * 获取map列表
     *
     * @author 
     * @Date 2019-12-23
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") QxReportParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author 
     * @Date 2019-12-23
     */
    Page<QxReportResult> customPageList(@Param("page") Page page, @Param("paramCondition") QxReportParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author 
     * @Date 2019-12-23
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") QxReportParam paramCondition);

}
