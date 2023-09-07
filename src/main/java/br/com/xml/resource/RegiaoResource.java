package br.com.xml.resource;

import br.com.xml.dto.RegiaoConsolidatedDTO;
import br.com.xml.service.IRegiaoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ApiResponses(value = {@ApiResponse(code = 200, message = "Return ResponseModel with success message"),
        @ApiResponse(code = 500, message = "Case has error, return a ResponseModel with Exception")})
@RequestMapping("/regioes")
public class RegiaoResource {

    private final IRegiaoService regiaoService;

    @Autowired
    public RegiaoResource(IRegiaoService regiaoService) {
        this.regiaoService = regiaoService;
    }

    @GetMapping
    @ApiOperation(value = "Get consolidated values by region.", notes = "This Operation get consolidated values by region")
    public @ResponseBody ResponseEntity<List<RegiaoConsolidatedDTO>> getConcolidatedByRegiao() {
        return new ResponseEntity<>(this.regiaoService.getConcolidatedByRegiao(), HttpStatus.OK);
    }
}
