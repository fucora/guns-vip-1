layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 用户社交账号表管理
     */
    var QxUserSocial = {
        tableId: "qxUserSocialTable"
    };

    /**
     * 初始化表格的列
     */
    QxUserSocial.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'id', hide: true, title: '标识'},
            {field: 'version', sort: true, title: '乐观锁'},
            {field: 'createdBy', sort: true, title: '创建人'},
            {field: 'createdTime', sort: true, title: '创建时间'},
            {field: 'updatedBy', sort: true, title: '更新人'},
            {field: 'updatedTime', sort: true, title: '更新时间'},
            {field: 'deleted', sort: true, title: '删除标识'},
            {field: 'userId', sort: true, title: '用户ID'},
            {field: 'appId', sort: true, title: 'APPID'},
            {field: 'openId', sort: true, title: '社交开放平台ID'},
            {field: 'unionId', sort: true, title: 'UnionId，微信特有'},
            {field: 'type', sort: true, title: '社交平台类型 0-微信;1-支付宝;'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    QxUserSocial.search = function () {
        var queryData = {};
        queryData['condition'] = $("#condition").val();
        table.reload(QxUserSocial.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    QxUserSocial.openAddDlg = function () {
        func.open({
            title: '添加用户社交账号表',
            content: Feng.ctxPath + '/qxUserSocial/add',
            tableId: QxUserSocial.tableId
        });
    };

    /**
    * 点击编辑
    *
    * @param data 点击按钮时候的行数据
    */
    QxUserSocial.openEditDlg = function (data) {
        func.open({
            title: '修改用户社交账号表',
            content: Feng.ctxPath + '/qxUserSocial/edit?id=' + data.id,
            tableId: QxUserSocial.tableId
        });
    };

    /**
     * 导出excel按钮
     */
    QxUserSocial.exportExcel = function () {
        var checkRows = table.checkStatus(QxUserSocial.tableId);
        if (checkRows.data.length === 0) {
            Feng.error("请选择要导出的数据");
        } else {
            table.exportFile(tableResult.config.id, checkRows.data, 'xls');
        }
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    QxUserSocial.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/qxUserSocial/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(QxUserSocial.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("id", data.id);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + QxUserSocial.tableId,
        url: Feng.ctxPath + '/qxUserSocial/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: QxUserSocial.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        QxUserSocial.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        QxUserSocial.openAddDlg();
    });

    // 导出excel
    $('#btnExp').click(function () {
        QxUserSocial.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + QxUserSocial.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            QxUserSocial.openEditDlg(data);
        } else if (layEvent === 'delete') {
            QxUserSocial.onDeleteItem(data);
        }
    });
});
