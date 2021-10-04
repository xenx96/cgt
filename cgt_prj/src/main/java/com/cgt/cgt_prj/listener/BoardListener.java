package com.cgt.cgt_prj.listener;

import com.cgt.cgt_prj.domain.Board;
import com.cgt.cgt_prj.service.SequenceGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BoardListener extends AbstractMongoEventListener<Board> {

    private final SequenceGeneratorService generatorService;

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Board> event){
        event.getSource().set_id(generatorService.generateSequence(Board.SEQUENCE_NAME));
    }

}
