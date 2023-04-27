package com.xc.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRoleDto {
    Integer roleId;
    Integer status;
}
