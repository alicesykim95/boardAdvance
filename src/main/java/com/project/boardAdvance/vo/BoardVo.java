package com.project.boardAdvance.vo;

import com.project.boardAdvance.model.User;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class BoardVo {

        User user;
        int success;

}
