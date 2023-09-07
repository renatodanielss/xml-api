package br.com.xml.resource;

import br.com.xml.service.IAgentesService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@ApiResponses(value = {@ApiResponse(code = 200, message = "Return ResponseModel with success message"),
        @ApiResponse(code = 500, message = "Case has error, return a ResponseModel with Exception")})
@RequestMapping("/agentes")
public class AgentesResource {

    private final IAgentesService agentesService;

    @Autowired
    public AgentesResource(IAgentesService agentesService) {
        this.agentesService = agentesService;
    }

    @PostMapping("/xml")
    @ApiOperation(value = "Save agentes structure from a xml file", notes = "This Operation saves agentes structure from a xml file")
    public @ResponseBody ResponseEntity save(@RequestParam(value = "xmlFile", required = false) MultipartFile xmlMultipartFile) throws IOException {
        this.agentesService.processarXml(xmlMultipartFile);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
