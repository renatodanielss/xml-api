package br.com.xml.service;

import br.com.xml.dto.SelectionProcessFormDTO;
import br.com.xml.model.SelectionProcess;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public interface ISelectionProcessService {

    SelectionProcess createSelectionProcess(SelectionProcessFormDTO selectionProcessFormDTO);
}
