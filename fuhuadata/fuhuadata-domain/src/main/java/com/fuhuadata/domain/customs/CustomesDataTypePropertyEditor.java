package com.fuhuadata.domain.customs;

import java.beans.PropertyEditorSupport;

/**
 * <p>User: wangjie
 * <p>Date: 6/20/2017
 */
public class CustomesDataTypePropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {

        if ("出口".equals(text)) {
            setValue(Boolean.FALSE);
        } else if ("进口".equals(text)) {
            setValue(Boolean.TRUE);
        }
    }
}
