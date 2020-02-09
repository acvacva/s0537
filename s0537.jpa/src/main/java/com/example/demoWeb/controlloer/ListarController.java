package com.example.demoWeb.controlloer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demoWeb.model.Producto;
import com.example.demoWeb.model.Tipoproducto;
import com.example.demoWeb.repo.IListacomprarepo;
import com.example.demoWeb.repo.ITipoproductorepo;


@Controller
public class ListarController {

	@Autowired
	private IListacomprarepo repo;
	@Autowired
	private ITipoproductorepo repo1;

	@GetMapping("/listar")
	public String greeting(Model model) {
	//logica

     model.addAttribute("personas", repo.findAll());
     model.addAttribute("prdflt", repo.findByDescripcion("AVENA INTEGRAL SUAVE"));
	
	System.out.println("Este comentario ocurre antes del error de thymeleaf ***** ");
	
	/* articulo.setNombre_producto("carne de res");
    articulo.setDescripcion("carne picada para hamburguesa");
    articulo.setComprar(true);
    articulo.setId_producto(8);
    repo.save(articulo);
	*/
    //hacer un ciclo for each aqui para ver si funciona

	
 for (Object i: repo.findAll()) {
  System.out.println (i); //Muestra cada uno de los nombres dentro de listaDeNombres

}
 try {
 Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/s0537jpa?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root1");
 PreparedStatement miSentencia=miConexion.prepareStatement("select id_producto,nombre_producto,descripcion,tipoproducto from producto" + " where tipoproducto=?");
	// 3 establecer parametros de la consulta
	miSentencia.setString(1, "LACTEO");

	// 4 ejecutar y recorrer consulta
	ResultSet rs=miSentencia.executeQuery();
	// 5 recorrer la tabla virtual del resultset
	while (rs.next()) {
		System.out.println(rs.getString(1)+" -- "+rs.getString(2)+" --  "+rs.getString(3));
	}
	 PreparedStatement miSentencia2=miConexion.prepareStatement("SELECT * FROM producto INNER JOIN tipoproducto ON producto.tipoproducto_id = tipoproducto.id_tipoproducto WHERE producto.comprar=1;");
	 ResultSet rs1=miSentencia2.executeQuery();
	 System.out.println("Prepared statement con inner join que hay que comprar");
		while (rs1.next()) {
			//System.out.println(rs1);
			System.out.println(rs1.getString(1)+"--"+rs1.getString(2)+"--"+rs1.getString(3)+"--"+rs1.getString(4)+"--"+rs1.getString(5));
		}
 }
		catch ( SQLException e) {
	        e.printStackTrace();
	        System.exit(128);
 }
return "listar";

}
	
	@GetMapping("/comprar")
	public String compra(Model model) {
     model.addAttribute("compra", repo.findByComprar(true));
    
return "comprar";
}
	
	@GetMapping("/nocomprar")
	public String nocomprar(Model model) {
     model.addAttribute("nocomprar", repo.findByComprar(false));

return "nocomprar";
}
	
	@GetMapping("/insertar")
	public String insertar(Model model) {
     Producto articulo= new Producto();
     articulo.setNombre_producto("NARANJA");
     articulo.setDescripcion("FRUTAS FRESCAS");
     articulo.setComprar(true);
     articulo.setId_producto(8);
     articulo.setTipoproducto("FRUTAS");
     repo.save(articulo);
     model.addAttribute("personas", repo.findAll());
return "listar";
}
	
@GetMapping("/tipoproducto")
	public String buscar(Model model) {
    model.addAttribute("personas", repo1.findAll());
 return "tipoproducto";

}

@GetMapping("/todos")
public String buscartodos(Model model) {
model.addAttribute("personas", repo1.findAll());
System.out.println("Hola todos los registros relacionados");
for (Object i: repo1.findAll()) {
	  System.out.println (i); //Muestra cada uno de los nombres dentro de listaDeNombres
	}

System.out.println("Select by tipoproducto LACTEO");
for (Tipoproducto tiprod : repo1.findByTipoproducto("LACTEO")) {
	System.out.println(tiprod);
}

System.out.println("Select by tipoproducto CARNES");
for (Tipoproducto tiprod : repo1.findByTipoproducto("CARNES")) {
	System.out.println(tiprod);
}

System.out.println("Select by tipoproducto CEREALES-LEGUMBRES");
for (Tipoproducto tiprod : repo1.findByTipoproducto("CEREALES-LEGUMBRES")) {
	System.out.println(tiprod);
}
return "tipoproducto";

}
 //    http://localhost:9899/greeting?name=Leche
	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		//logica
        model.addAttribute("name", name);
		return "greeting";
			
		}

}
