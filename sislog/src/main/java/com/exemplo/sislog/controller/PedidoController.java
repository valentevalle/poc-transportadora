package com.exemplo.sislog.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.exemplo.sislog.dto.PedidoDTO;
import com.exemplo.sislog.model.Pedido;
import com.exemplo.sislog.service.PedidoService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/pedido")
public class PedidoController {

	Logger logger = LoggerFactory.getLogger(PedidoController.class);

	@Autowired
	PedidoService pedidoService;

	@RequestMapping(value = "/solicitar", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> solicitarFrete(@RequestParam(value = "file", required = true) MultipartFile file,
			@RequestPart(required = true, value = "pedido") Pedido pedido) throws JsonProcessingException {
		try {
			if ((pedido != null) && (pedido.getCarga() != null) && (pedido.getCarga().getNotaFiscal() != null)) {
//				pedido.getCargas().get(0).getNotaFiscal().setDocumento(file.getBytes());
				pedidoService.solicitar(pedido);
				return new ResponseEntity<String>("Pedido realizado com sucesso. Nota Fiscal da carga:"
						+ pedido.getCarga().getNotaFiscal().getNumeroNotaFiscal(), HttpStatus.OK);
			} else {
				throw new RuntimeException("Dados incompletos para fazer o pedido.");
			}
		} catch ( RuntimeException e) {
			logger.error(e.getMessage());
			return new ResponseEntity<String>("Não foi possível realizar o pedido", HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/consultar", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public PedidoDTO consultarPedido(
			@RequestParam(value = "cnpjEntrega", required = true) String cnpjEmpresaEntrega,
			@RequestParam(required = true, value = "dataEmissao") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dataEmissaoNotaFiscal,
			@RequestParam(required = true, value = "numeroNotaFiscal") String numeroNotaFiscal)
			throws JsonProcessingException {
		Pedido pedido = pedidoService.consultar(cnpjEmpresaEntrega, numeroNotaFiscal, dataEmissaoNotaFiscal);
//		if (pedido != null) {

//			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(pedido), HttpStatus.OK);
			return new PedidoDTO(pedido);
//		}

	}

}
