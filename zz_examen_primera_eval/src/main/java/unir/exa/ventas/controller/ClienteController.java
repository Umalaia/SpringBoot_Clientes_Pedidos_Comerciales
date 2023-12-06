package unir.exa.ventas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	
	@GetMapping("/clientes/alta")
	public String altaCliente(Model model, Cliente cliente) {
		model.addAttribute("cliente", cliente);
		return "altaCliente";
	}
	
	@PostMapping("/clientes/alta")
	public String altaCliente(RedirectAttributes ratt, Cliente cliente) {
		if(cliDao.altaCliente(cliente) != null) {
			ratt.addFlashAttribute("mensaje", "Cliente dado de alta correctamente");
			return "redirect:/clientes";
		}else {
		ratt.addFlashAttribute("mensaje", "Cliente no se ha dado de alta");
		}
		return "redirect:/clientes";
	}
	
	
	@GetMapping("/clientes/eliminar/{id}")
	public String eliminarCliente(@PathVariable ("id") int idCliente, Model model) {
		if(cliDao.eliminarCliente(idCliente) == 1) {
		model.addAttribute("mensaje", "Cliente eliminado correctamente");
		return "redirect:/clientes";
		}else {
			model.addAttribute("mensaje", "Cliente con pedidos asociados no puede ser eliminado");
		}
		return "forward:/clientes";
	}

	
	@GetMapping("/clientes/modificar/{id}")
	public String modificarCliente(@PathVariable ("id") int idCliente, Model model) {
		Cliente cliente = cliDao.verUnCliente(idCliente);
		model.addAttribute("cliente", cliente);
		return "modificarCliente";
	}
	
	@PostMapping("/clientes/modificar/{id}")
	public String modificarCliente(@PathVariable ("id") int idCliente, RedirectAttributes ratt, Cliente cliente) {
	Cliente cli1 = cliDao.verUnCliente(idCliente);
	cli1.setNombre(cliente.getNombre());
	cli1.setApellido1(cliente.getApellido1());
	cli1.setApellido2(cliente.getApellido2());
	cli1.setCategoria(cliente.getCategoria());
	if(cliDao.modificarCliente(cli1) == 1) {
		ratt.addFlashAttribute("mensaje", "Cliente ha sido modificado correctamente");
		return "redirect:/clientes";
	}else
		ratt.addFlashAttribute("mensaje", "Cliente no ha sido modificado");
		return "redirect:/clientes";
	}
	
	
}
