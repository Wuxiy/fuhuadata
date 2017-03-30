/**
 * Created by huxiangyang on 2017/3/13.
 */

//创建面包屑导航
$('#location').append(createCrumbsL());

var title = $('#pTitle').text()+$('#sTitle').text();
$('#hTitle').text(iGetInnerText(title));
