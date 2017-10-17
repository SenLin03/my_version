package com.david.sys.entity;

import com.david.common.BaseEntity;
import com.david.common.utils.UserUtils;

import java.util.Date;

/**
 * Data entity
 */
public abstract class DataEntity<T> extends BaseEntity<T> {

    private static final long serialVersionUID = 1L;

    private User user;
    private User createUser;
    private User updateUser;

    public DataEntity() {
        this.status = STATUS_NORMAL;
    }

    public DataEntity(String id) {
        this();
        this.id = id;
    }


    /**
     * Insert the previous implementation method, subclass implementation
     */
    public void preInsert() {
        User user = UserUtils.getLoginUser();
        if (user != null) {
            this.updateBy = user.getId();
            this.createBy = user.getId();
        }
        this.createDate = new Date();
        this.updateDate = new Date();
    }

    /**
     * Insert the previous implementation method, subclass implementation
     */
    public void preUpdate() {
        User user = UserUtils.getLoginUser();
        if (user != null) {
            this.updateBy = user.getId();
        }
        this.updateDate = new Date();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getCreateUser() {
        return createUser;
    }

    public void setCreateUser(User createUser) {
        this.createUser = createUser;
    }

    public User getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(User updateUser) {
        this.updateUser = updateUser;
    }
}

