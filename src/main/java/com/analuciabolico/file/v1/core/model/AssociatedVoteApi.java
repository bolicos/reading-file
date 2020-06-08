package com.analuciabolico.file.v1.core.model;

import com.analuciabolico.file.v1.core.enums.AssociatedVoteApiEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AssociatedVoteApi implements Serializable {
    private AssociatedVoteApiEnum status;
}
