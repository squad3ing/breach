package com.hcl.ing.breach.dto;

import java.io.Serializable;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long loginId;
	private  String password;

}
