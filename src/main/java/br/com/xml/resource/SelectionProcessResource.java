package br.com.xml.resource;

import br.com.xml.dto.SelectionProcessFormDTO;
import br.com.xml.model.SelectionProcess;
import br.com.xml.service.ISelectionProcessService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@ApiResponses(value = {@ApiResponse(code = 200, message = "Return ResponseModel with success message"),
        @ApiResponse(code = 500, message = "Case has error, return a ResponseModel with Exception")})
@RequestMapping("/v0/xml")
public class SelectionProcessResource {


    private final ISelectionProcessService selectionProcessService;
    @Autowired
    public SelectionProcessResource(ISelectionProcessService selectionProcessService) {
        this.selectionProcessService = selectionProcessService;
    }
    @PostMapping("/process")
    @ApiOperation(value = "Save Selection Process", notes = "This Operation saves selection process")
    public @ResponseBody ResponseEntity<SelectionProcess> save(@RequestBody @Valid SelectionProcessFormDTO selectionProcessFormDTO) {
        return new ResponseEntity<>(this.selectionProcessService.createSelectionProcess(selectionProcessFormDTO),
                HttpStatus.CREATED);
    }
}
