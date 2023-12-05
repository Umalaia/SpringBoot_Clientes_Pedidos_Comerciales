package unir.exa.ventas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import unir.exa.ventas.modelo.dao.ClienteDao;
import unir.exa.ventas.modelo.dao.PedidoDao;
import unir.exa.ventas.modelo.entity.Cliente;
import unir.exa.ventas.modelo.entity.Pedido;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteDao cliDao;
	
	@Autowired
	private PedidoDao pDao;
	
	@GetMapping("/clientes")
	public String verClientes(Model model) {
		List<Cliente> clientes = cliDao.todosLosClientes();
		model.addAttribute("clientes", clientes);
		return "clientes";
	}
	
	
	@GetMapping("/clientes/pedidosPorCliente/{id}")
	public String verPedidosPorCliente(@PathVariable ("id") int idCliente, Model model) {
		List<Pedido> pedidos = pDao.pedidosPorCliente(idCliente);
		model.addAttribute("pedidos", pedidos);
		return "pedidosPorCliente";
	}

}
