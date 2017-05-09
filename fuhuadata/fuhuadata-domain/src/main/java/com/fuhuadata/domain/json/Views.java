package com.fuhuadata.domain.json;

/**
 * JsonView 使用
 *
 * <p>Views.Editable 表示可编辑</p>
 * <p>Views.Viewable 表示可查看</p>
 * <p>Views.Internal 表示内部使用，应该具有最多的字段</p>
 *
 * <p>User: wangjie
 * <p>Date: 5/8/2017
 */
public class Views {

    public interface Summary {}

    public interface Editable extends Summary {}

    public interface Viewable extends Editable {}

    public interface Internal extends Viewable {}
}
