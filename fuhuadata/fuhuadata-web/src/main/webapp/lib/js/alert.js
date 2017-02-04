/* ========================================================================
 * Bootstrap: alert.js v3.3.0
 * http://getbootstrap.com/javascript/#alerts
 * ========================================================================
 * Copyright 2011-2014 Twitter, Inc.
 * Licensed under MIT (https://github.com/twbs/bootstrap/blob/master/LICENSE)
 * ======================================================================== */


+function ($) {
  'use strict'; //1.使用严格模式ES5支持

  // ALERT CLASS DEFINITION
  // ======================

  var dismiss = '[data-dismiss="alert"]'
  var Alert   = function (el) {
  	//传入元素，如果元素内部有dismiss上设置的自定义属性，则click事件会触发原型上的close方法
    $(el).on('click', dismiss, this.close) //这里的this指Alert？
  }

  Alert.VERSION = '3.3.0'
  //添加过渡效果
  Alert.TRANSITION_DURATION = 150
  Alert.prototype.close = function (e) { //原型方法，所有实例继承
    var $this    = $(this)  //被单击元素的jQuery对象，临时赋值，防止this污染
    var selector = $this.attr('data-target')  //获取自定义属性data-target的值

    if (!selector) {  //如果自定义属性data-target无值，则获取href属性的值
      selector = $this.attr('href')
      selector = selector && selector.replace(/.*(?=#[^\s]*$)/, '') // strip for ie7
    }
    //执行选择器，获取jQuery对象，该对象元素通常就是要被删除的元素
    //$parent名称有点不太合适，但是一般都表示包含关闭按钮和alert内容的父元素容器（除非data-target或href有特定值）
    var $parent = $(selector)

    if (e) e.preventDefault()  //防止冒泡，阻止默认行为，比如按钮或链接的其他行为

    if (!$parent.length) {  //如果上面没能取到有效的元素，则选择第一个class含alert的祖先
      $parent = $this.closest('.alert')
    }
    //新建一个'close.bs.alert'事件，并用该事件触发上面所选到的jquery对象
    $parent.trigger(e = $.Event('close.bs.alert'))
    // 如果开发者利用preventDefault阻止了该事件的默认方法，则return结束，否则继续执行
    // 注意：此处的e是新建的'close.bs.alert'事件，与上面被阻止默认的click事件无关
    if (e.isDefaultPrevented()) return

    $parent.removeClass('in')  //删除$parent上的in样式（如果没有则不做处理）

    function removeElement() {  //通用内部函数，在触发closed事件后，再删除$parent元素
      // detach from parent, fire event then clean up data
      //detach() 方法移除被选元素，包括所有的文本和子节点。然后它会保留数据和事件。该方法会保留移除元素的副本，允许它们在以后被重新插入。
      $parent.detach().trigger('closed.bs.alert').remove()
    }
    //如果支持动画，并且设置了fade样式，则在执行动画过渡效果后（从有in样式，变化到无in样式）再删除元素；否则直接删除元素
    $.support.transition && $parent.hasClass('fade') ?
      $parent
        .one('bsTransitionEnd', removeElement)  //
        .emulateTransitionEnd(Alert.TRANSITION_DURATION) :  //emulateTransitionEnd()方法定义在transition.js里
      removeElement()
  }


  // ALERT PLUGIN DEFINITION
  // =======================

  function Plugin(option) {
  	//遍历所有符合规则的元素，例如在btnClose按钮上绑定的alert插件：$("#btnClose").alert();
    return this.each(function () { //this指$
      var $this = $(this)
      var data  = $this.data('bs.alert') //data() 方法向被选元素附加数据，或者从被选元素获取数据。
      //如果值不存在，就创建一个alert实例，然后设置为data-bs.alert的值
      if (!data) $this.data('bs.alert', (data = new Alert(this)))
      //如果option传递了string，则表示要执行某个方法，比如传入了close，则要执行alert实例的close方法
      //data["close"]相当于data.close();
      if (typeof option == 'string') data[option].call($this)
    })
  }
  //在jQuery上定义alert插件，并重设插件构造器
  var old = $.fn.alert
  //保留其他库的 $.fn.alert代码（如果定义的话），以便在noConflic之后，可以继续使用该老代码
  $.fn.alert             = Plugin
  $.fn.alert.Constructor = Alert  //并重设插件构造器，可以通过该属性获取插件的真实函数


  // ALERT NO CONFLICT
  // =================

  $.fn.alert.noConflict = function () {
    $.fn.alert = old
    return this
  }


  // ALERT DATA-API
  // ==============
  //为声明式的HTML绑定单击事件
  //即在整个document对象上，检测是否有自定义属性data-dismiss="alert"
  //如果有，则设置：单击的时候，关闭指定警告框元素
  $(document).on('click.bs.alert.data-api', dismiss, Alert.prototype.close)

}(jQuery);
