$.fn.dataTableExt.oPagination.input = {
    "fnInit": function(oSettings, nPaging, fnCallbackDraw) {

        var nFirst = document.createElement('span');
        var nPrevious = document.createElement('span');
        var nNext = document.createElement('span');
        var nLast = document.createElement('span');
        var nInput = document.createElement('input');
        var nPage = document.createElement('span');
        var nOf = document.createElement('span');
        var nGoto = document.createElement('a');

        nFirst.innerHTML = oSettings.oLanguage.oPaginate.sFirst;
        nPrevious.innerHTML = oSettings.oLanguage.oPaginate.sPrevious;
        nNext.innerHTML = oSettings.oLanguage.oPaginate.sNext;
        nLast.innerHTML = oSettings.oLanguage.oPaginate.sLast;

        nFirst.className = "paginate_button first disabled";
        nPrevious.className = "paginate_button previous disabled";
        nNext.className = "paginate_button next";
        nLast.className = "paginate_button last";
        nOf.className = "paginate_of";
        nPage.className = "paginate_page";
        nInput.className = "paginate_input text";
        nGoto.className = "paginate_goto";

        if (oSettings.sTableId !== '') {
            nPaging.setAttribute('id', oSettings.sTableId + '_paginate');
            nPrevious.setAttribute('id', oSettings.sTableId + '_previous');
            nPrevious.setAttribute('id', oSettings.sTableId + '_previous');
            nNext.setAttribute('id', oSettings.sTableId + '_next');
            nLast.setAttribute('id', oSettings.sTableId + '_last');
        }

        nInput.type = "text";
        nPage.innerHTML = "Go to ";

        nPaging.appendChild(nFirst);
        nPaging.appendChild(nPrevious);
        nPaging.appendChild(nNext);
        nPaging.appendChild(nLast);

        nPaging.appendChild(nOf);
        nPaging.appendChild(nPage);
        nPaging.appendChild(nInput);
        nPaging.appendChild(nGoto);


        $(nFirst).click(function() {
            var iCurrentPage = Math.ceil(oSettings._iDisplayStart / oSettings._iDisplayLength) + 1;
            if (iCurrentPage != 1) {
                oSettings.oApi._fnPageChange(oSettings, "first");
                fnCallbackDraw(oSettings);
                $(nFirst).addClass('disabled');
                $(nPrevious).addClass('disabled');
                $(nNext).removeClass('disabled');
                $(nLast).removeClass('disabled');
            }
        });

        $(nPrevious).click(function() {
            var iCurrentPage = Math.ceil(oSettings._iDisplayStart / oSettings._iDisplayLength) + 1;
            if (iCurrentPage != 1) {
                oSettings.oApi._fnPageChange(oSettings, "previous");
                fnCallbackDraw(oSettings);
                if (iCurrentPage == 2) {
                    $(nFirst).addClass('disabled');
                    $(nPrevious).addClass('disabled');
                }
                $(nNext).removeClass('disabled');
                $(nLast).removeClass('disabled');
            }
        });

        $(nNext).click(function() {
            var iCurrentPage = Math.ceil(oSettings._iDisplayStart / oSettings._iDisplayLength) + 1;
            if (iCurrentPage != (Math.ceil(oSettings.fnRecordsDisplay() / oSettings._iDisplayLength))) {
                oSettings.oApi._fnPageChange(oSettings, "next");
                fnCallbackDraw(oSettings);
                if (iCurrentPage == (Math.ceil(oSettings.fnRecordsDisplay() / oSettings._iDisplayLength) - 1)) {
                    $(nNext).addClass('disabled');
                    $(nLast).addClass('disabled');
                }
                $(nFirst).removeClass('disabled');
                $(nPrevious).removeClass('disabled');
            }
        });

        $(nLast).click(function() {
            var iCurrentPage = Math.ceil(oSettings._iDisplayStart / oSettings._iDisplayLength) + 1;
            if (iCurrentPage != (Math.ceil(oSettings.fnRecordsDisplay() / oSettings._iDisplayLength))) {
                oSettings.oApi._fnPageChange(oSettings, "last");
                fnCallbackDraw(oSettings);
                $(nFirst).removeClass('disabled');
                $(nPrevious).removeClass('disabled');
                $(nNext).addClass('disabled');
                $(nLast).addClass('disabled');
            }
        });

        $(nGoto).click(function(e) {

            e.preventDefault();
            var pageNumberInput = $(nInput)[0];
            // 38 = up arrow, 39 = right arrow
            // if ( e.which == 38 || e.which == 39 )
            // {
            //     this.value++;
            // }
            // // 37 = left arrow, 40 = down arrow
            // else if ( (e.which == 37 || e.which == 40) && this.value > 1 )
            // {
            //     this.value--;
            // }
            if (pageNumberInput.value === "" || pageNumberInput.value.match(/[^0-9]/)) {
                /* Nothing entered or non-numeric character */
                pageNumberInput.value = pageNumberInput.value.replace(/[^\d]/g, ''); // don't even allow anything but digits
                return;
            }

            var iNewStart = oSettings._iDisplayLength * (pageNumberInput.value - 1);
            if (iNewStart < 0) {
                iNewStart = 0;
            }
            if (iNewStart > oSettings.fnRecordsDisplay()) {
                iNewStart = (Math.ceil(oSettings.fnRecordsDisplay() / oSettings._iDisplayLength) - 1) * oSettings._iDisplayLength;
            }

            if (iNewStart == 0) {
                $(nFirst).addClass('disabled');
                $(nPrevious).addClass('disabled');

                if(pageNumberInput.value * oSettings._iDisplayLength >= oSettings.fnRecordsDisplay()){
                    $(nNext).addClass('disabled');
                    $(nLast).addClass('disabled');
                }else{
                    $(nNext).removeClass('disabled');
                    $(nLast).removeClass('disabled');
                }

            } else if (iNewStart == ((Math.ceil(oSettings.fnRecordsDisplay() / oSettings._iDisplayLength) - 1) * oSettings._iDisplayLength)) {
                $(nNext).addClass('disabled');
                $(nLast).addClass('disabled');
                $(nFirst).removeClass('disabled');
                $(nPrevious).removeClass('disabled');
            } else {
                $(nFirst).removeClass('disabled');
                $(nPrevious).removeClass('disabled');
                $(nNext).removeClass('disabled');
                $(nLast).removeClass('disabled');
            }

            oSettings._iDisplayStart = iNewStart;
            fnCallbackDraw(oSettings);
        });

        /* Take the brutal approach to cancelling text selection */
        $('span', nPaging).bind('mousedown', function() {
            return false;
        });
        $('span', nPaging).bind('selectstart', function() {
            return false;
        });

        // If we can't page anyway, might as well not show it
        var iPages = Math.ceil((oSettings.fnRecordsDisplay()) / oSettings._iDisplayLength);
        if (iPages <= 1) {
            // $(nPaging).hide();
            $(nNext).addClass('disabled');
            $(nLast).addClass('disabled');
            $(nFirst).addClass('disabled');
            $(nPrevious).addClass('disabled');
        }

        // console.log(nPaging);
    },


    "fnUpdate": function(oSettings, fnCallbackDraw) {
        if (!oSettings.aanFeatures.p) {
            return;
        }

        if (!oSettings.oLanguage.infoPages) {
            oSettings.oLanguage.infoPages = "_CUR_/_MENU_";
        }
        if (!oSettings.oLanguage.jumpToPage) {
            oSettings.oLanguage.jumpToPage = "Go to ";
        }

        var iPages = Math.ceil((oSettings.fnRecordsDisplay()) / oSettings._iDisplayLength);
        var iCurrentPage = Math.ceil(oSettings._iDisplayStart / oSettings._iDisplayLength) + 1;

        var an = oSettings.aanFeatures.p;

        iPages = iPages===0?1:iPages;

        if (iPages > 1) // hide paging when we can't page
        {
            // $(an).hide();
            // $(an).find('input').each(function(){
            //     $(this).prop('disabled', 'disabled');
            //     $(this).prop('readonly', 'readonly');
            // });
            // $(an).find('span').addClass('disabled');
            //
        }
        /* Loop over each instance of the pager */
        for (var i = 0, iLen = an.length; i < iLen; i++) {
            var spans = an[i].getElementsByTagName('span');
            var inputs = an[i].getElementsByTagName('input');

            spans[4].innerHTML = " " + oSettings.oLanguage.infoPages
                .replace("_CUR_", iCurrentPage)
                .replace("_MENU_", iPages) + ", ";
            spans[5].innerHTML = oSettings.oLanguage.jumpToPage + " ";
            inputs[0].value = iCurrentPage;

            if(iPages > 1){
                if(iCurrentPage > 1){
                    $(spans[0]).removeClass('disabled');
                    $(spans[1]).removeClass('disabled');
                }else if (iCurrentPage < iPages){
                    $(spans[2]).removeClass("disabled");
                    $(spans[3]).removeClass("disabled");
                }
            }
        }
    }
};
$.extend( $.fn.dataTable.defaults, {
    "dom": '<"cmn_page"f<"toolbar"><"wrapper"ip>>t'//各类组件位置设置
});