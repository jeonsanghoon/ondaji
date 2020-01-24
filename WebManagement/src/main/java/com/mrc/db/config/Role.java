/**
 * 
 */
package com.mrc.db.configuration;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author jsh
 *
 */
@AllArgsConstructor
@Getter
public enum Role {
    ADMIN("ROLE_ADMIN"),
    MEMBER("ROLE_MEMBER");

    private String value;

}
