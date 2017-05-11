package com.fuhuadata.service.task.event;

import com.fuhuadata.domain.mybatis.BaseEntity;
import org.springframework.context.ApplicationEvent;

import java.io.Serializable;

/**
 * <p>User: wangjie
 * <p>Date: 5/10/2017
 */
public class SyncEvent<T extends BaseEntity<ID>, ID extends Serializable> extends ApplicationEvent {

    public SyncEvent() {
        super("NC 档案同步事件");
    }

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public SyncEvent(Object source) {
        super(source);
    }
}
