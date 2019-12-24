/**
 * 
 */
package com.altsoft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author jsh
 *
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@Entity
@Table(name="users")
public class Users{
	@Id
    @Column
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	public Long id;
    @Column
	public String user_id;
    @Column
	public String user_pw;
    @Column
	public String user_name;
}
