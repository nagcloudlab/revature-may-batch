package com.example.web.dto;

import com.example.entity.TodoType;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class TodoDto {
    private int id;
    private String title;
    private boolean completed;
    private TodoType type;
}
