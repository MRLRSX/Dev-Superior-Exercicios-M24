package mode.entities.dao;

import mode.DB.Conexao;
import mode.entities.dao.impl.SellerDaoJDBC;

public class DaoFactory {
   
	public static SellerDao createSellerDaoJDBC() {
		return new SellerDaoJDBC(Conexao.getConnection());
	}
}
