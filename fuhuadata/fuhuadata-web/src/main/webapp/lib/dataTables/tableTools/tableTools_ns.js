$.extend( $.fn.dataTable.defaults, {
    "dom": '<"right"T><"cmn_page"f<"wrapper"ip>>t' //各类组件位置设置
});

//设置swf位置
TableTools.DEFAULTS.sSwfPath = 'js/dataTables/tableTools/swf/copy_csv_xls_pdf.swf'

TableTools.buttons.copy = $.extend( {}, TableTools.buttons.copy, {
    "sText": "Copied __LINES__ rows to the clipboard",
    "fnComplete": function(nButton, oConfig, flash, text) {
        var lines = text.split('\n').length;
        if (oConfig.bHeader) lines--;
        if (this.s.dt.nTFoot !== null && oConfig.bFooter) lines--;
        var html = "<div class='load_bg'></div><div class='load_con'><span>__CONTENT__</span>";
        var content = oConfig.sText.replace("__LINES__", lines);
        content = html.replace("__CONTENT__", content);
        //重新定义样式
        this.classes.print.info = "load";
        this.fnInfo(content, 1500);
        this.classes.print.info = "DTTT_print_info";
    }
});