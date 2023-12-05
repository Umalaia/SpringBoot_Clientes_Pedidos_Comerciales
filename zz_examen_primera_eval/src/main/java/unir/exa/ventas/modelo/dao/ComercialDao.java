package unir.exa.ventas.modelo.dao;

import java.util.List;

import unir.exa.ventas.modelo.entity.Comercial;

public interface ComercialDao {
	List<Comercial> todosLosComerciales();
	Comercial altaComercial(Comercial comercial);
	int eliminarComercial(int idComercial);
	int modificarComercial(Comercial comercial);
	Comercial verUnComercial(int idComercial);
	
}
