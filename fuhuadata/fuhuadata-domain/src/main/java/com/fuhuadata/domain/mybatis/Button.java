package com.fuhuadata.domain.mybatis;

import javax.persistence.*;

@Table(name = "p_button")
public class Button extends BaseEntity<Integer> {
    /**
     * 按钮id
     */
    @Id
    @Column(name = "button_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer buttonId;

    @Column(name = "permission")
    private String permission;

    /**
     * 菜单ID
     */
    @Column(name = "menu_id")
    private Integer menuId;

    /**
     * 名称
     */
    @Column(name = "button_name")
    private String buttonName;

    /**
     * posturl
     */
    private String posturl;

    /**
     * 备注
     */
    private String backup;

    /**
     * 是否允许该权限
     */
    @Transient
    private Boolean permitted;

    /**
     * 获取按钮id
     *
     * @return button_id - 按钮id
     */
    public Integer getButtonId() {
        return buttonId;
    }

    /**
     * 设置按钮id
     *
     * @param buttonId 按钮id
     */
    public void setButtonId(Integer buttonId) {
        this.buttonId = buttonId;
    }

    /**
     * 获取菜单ID
     *
     * @return menu_id - 菜单ID
     */
    public Integer getMenuId() {
        return menuId;
    }

    /**
     * 设置菜单ID
     *
     * @param menuId 菜单ID
     */
    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    /**
     * 获取名称
     *
     * @return button_name - 名称
     */
    public String getButtonName() {
        return buttonName;
    }

    /**
     * 设置名称
     *
     * @param buttonName 名称
     */
    public void setButtonName(String buttonName) {
        this.buttonName = buttonName == null ? null : buttonName.trim();
    }

    /**
     * 获取posturl
     *
     * @return posturl - posturl
     */
    public String getPosturl() {
        return posturl;
    }

    /**
     * 设置posturl
     *
     * @param posturl posturl
     */
    public void setPosturl(String posturl) {
        this.posturl = posturl == null ? null : posturl.trim();
    }

    /**
     * 获取备注
     *
     * @return backup - 备注
     */
    public String getBackup() {
        return backup;
    }

    /**
     * 设置备注
     *
     * @param backup 备注
     */
    public void setBackup(String backup) {
        this.backup = backup == null ? null : backup.trim();
    }

    @Override
    public void setId(Integer integer) {
        this.buttonId = integer;
    }

    @Override
    public Integer getId() {
        return this.buttonId;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }

    public Boolean getPermitted() {
        return permitted;
    }

    public void setPermitted(Boolean permitted) {
        this.permitted = permitted;
    }
}