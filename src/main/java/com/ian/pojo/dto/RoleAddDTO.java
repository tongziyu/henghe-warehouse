package com.ian.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/16 18:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleAddDTO {
    private String roleCode;

    private String roleDesc;

    private String roleName;
}
