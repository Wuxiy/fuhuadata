//--设置树
var setting = {
	view: {
		dblClickExpand: false //双击节点时，是否自动展开父节点的标识
	},
	data: {
		simpleData: {
			enable: true //数据是否采用简单数据模式 (Array)
		}
	},
	callback: {
		onClick: onClick
	}
};
//--添加树的数据
var zNodes =[
	{id:1, pId:0, name:"除草剂",val:"除草剂" , open:true},
	{id:11, pId:1, name:"草甘膦",val:"除草剂-草甘膦", open:true},
	{id:111, pId:11, name:"原药",val:"除草剂-草甘膦-原药"},
	{id:112, pId:11, name:"水剂",val:"除草剂-草甘膦-水剂"},
	{id:113, pId:11, name:"颗粒剂",val:"除草剂-草甘膦-颗粒剂"},
	{id:12, pId:1, name:"草胺膦",val:"草胺膦"},
	{id:2, pId:0, name:"杀菌剂",val:"杀菌剂"},
	{id:3, pId:0, name:"杀虫剂",val:"杀虫剂"},
	{id:4, pId:0, name:"化工品",val:"化工品"}
 ];
 
function onClick(e, treeId, treeNode) {
	var zTree = $.fn.zTree.getZTreeObj("treeDemo"), //获取treeDemo对象
	nodes = zTree.getSelectedNodes(),  //当前被选中的节点数据集合
	v = "";
	nodes.sort(function compare(a,b){return a.id-b.id;});
	for (var i=0, l=nodes.length; i<l; i++) {
		v += nodes[i].val + ",";
	}
	if (v.length > 0 ) {v = v.substring(0, v.length-1)};
	var $category = $("#category");
	$category.attr("value", v);
}
//--控制下拉菜单的出现位置
//function showMenu() {
//	var $category = $("#category");
////	var $ctOffset = $("#category").offset(); //返回第一个匹配元素的偏移坐标
////	$("#menuContent").css({left:0 + "px", top:$category.outerHeight() + "px"}).slideDown("fast");
//
//	$("body").bind("mousedown", onBodyDown);
//}
////--关闭下拉菜单
//function hideMenu() {
//	$("#menuContent").fadeOut("fast");
//	$("body").unbind("mousedown", onBodyDown);
//}
////--在什么时候关闭下拉菜单
//function onBodyDown(event) {// || or, && and
//	if (!(event.target.id == "menuBtn" || event.target.id == "category"|| event.target.id == "menuContent" || $(event.target).parents("#menuContent").length>0)) {
//		hideMenu();
//	}
//}
//--初始化树
$(document).ready(function(){
	$.fn.zTree.init($("#treeDemo"), setting, zNodes);
});
