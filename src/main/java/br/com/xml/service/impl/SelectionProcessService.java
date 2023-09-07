package br.com.xml.service.impl;

import br.com.xml.dto.SelectionProcessFormDTO;
import br.com.xml.mapper.SelectionProcessMapper;
import br.com.xml.model.SelectionProcess;
import br.com.xml.repository.SelectionProcessRepository;
import br.com.xml.service.ISelectionProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class SelectionProcessService implements ISelectionProcessService {

    private final SelectionProcessRepository selectionProcessRepository;
    private final SelectionProcessMapper selectionProcessMapper;

    @Autowired
    public SelectionProcessService(SelectionProcessRepository selectionProcessRepository,
                                   SelectionProcessMapper selectionProcessMapper) {
        this.selectionProcessRepository = selectionProcessRepository;
        this.selectionProcessMapper = selectionProcessMapper;
    }

    @Transactional
    @Override
    public SelectionProcess createSelectionProcess(SelectionProcessFormDTO selectionProcessFormDTO) {
        SelectionProcess selectionProcess = new SelectionProcess();
//        this.selectionProcessMapper.dtoToEntityIgnoreNullValues(selectionProcess, selectionProcessFormDTO);
        selectionProcess = this.selectionProcessRepository.save(selectionProcess);
        return selectionProcess;
    }
}
