package cn.stylefeng.guns.modular.note.model.params;

import lombok.Data;
import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 约单报名
 * </p>
 *
 * @author 
 * @since 2019-11-19
 */
@Data
public class QxInviteApplyParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


    /**
     * 标识
     */
    private Long id;

    /**
     * 乐观锁
     */
    private Integer version;

    /**
     * 创建人
     */
    private Long createdBy;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新人
     */
    private Long updatedBy;

    /**
     * 更新时间
     */
    private Date updatedTime;

    /**
     * 删除标识
     */
    private Boolean deleted;

    /**
     * 约单ID
     */
    private Long inviteId;

    /**
     * 报名用户ID
     */
    private Long userId;

    /**
     * 状态：0-待确定；1-已选中；2-未选中
     */
    private String status;

    @Override
    public String checkParam() {
        return null;
    }

}
