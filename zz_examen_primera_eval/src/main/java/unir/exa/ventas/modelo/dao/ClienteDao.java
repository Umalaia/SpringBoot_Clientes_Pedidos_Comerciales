package unir.exa.ventas.modelo.dao;

import java.util.List;

import unir.exa.ventas.modelo.entity.Cliente;

public interface ClienteDao {
	List<Cliente> todosLosClientes();
}
