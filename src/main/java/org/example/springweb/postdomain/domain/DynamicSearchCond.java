package org.example.springweb.postdomain.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DynamicSearchCond {
    private String userId;
    private Integer likes;
}
