package mode.entities.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import mode.DB.Conexao;
import mode.DB.DBException;
import mode.entities.Department;
import mode.entities.Seller;
import mode.entities.dao.SellerDao;

public class SellerDaoJDBC implements SellerDao {

	private Connection connection = null;

	public SellerDaoJDBC(Connection connection) {
		this.connection = connection;
	}

	@Override
	public Seller findById(Long id) {
		try {
			Seller seller = new Seller();
			Department department = new Department();
			PreparedStatement ps = connection.prepareStatement(
					"SELECT * FROM seller INNER JOIN department ON departmentid = department.id WHERE seller.id = ?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				department.setId(rs.getLong("department.id"));
				department.setName(rs.getString("name"));
				seller.setId(rs.getLong("seller.id"));
				seller.setName(rs.getString("seller.name"));
				seller.setEmail(rs.getString(rs.getString("seller.email")));
				seller.setBaseSalary(rs.getDouble("seller.basesalary"));
				seller.setBirthDate(
						LocalDateTime.parse(rs.getString("birthdate"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
				seller.setDepartment(department);

			}
			return seller;
		} catch (SQLException erro) {
			throw new DBException(erro.getMessage());
		}
	}

	@Override
	public void update(Seller seller) {
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(
					"UPDATE seller SET name = ?, email = ?, birthdate = ?, departmentid = ? WHERE id = ? ");
			ps.setString(1, seller.getName());
			ps.setString(2, seller.getEmail());
			ps.setDate(3, conversorTime(seller.getBirthDate()));
			ps.setLong(4, seller.getDepartment().getId());
			ps.setLong(5, seller.getId());
			ps.executeUpdate();
		} catch (SQLException error) {
			throw new DBException(error.getMessage());
		} finally {
			Conexao.closeStatement(ps);
		}

	}

	@Override
	public void deleteById(Long id) {
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement("DELETE FROM seller WHERE id = ?");
			ps.setLong(1, id);
			ps.executeUpdate();
		} catch (SQLException error) {
			throw new DBException(error.getMessage());
		} finally {
			Conexao.closeStatement(ps);
		}

	}

	@Override
	public void insert(Seller seller) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Seller> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;

		List<Seller> listaSeller = new ArrayList<>();

		try {
			st = connection.prepareStatement(
					"SELECT * FROM seller INNER JOIN department ON seller.DepartmentId = department.Id");
			rs = st.executeQuery();

			while (rs.next()) {
				Seller seller = new Seller();
				Department department = new Department();
				seller.setId(rs.getLong("id"));
				seller.setName(rs.getString("name"));
				seller.setEmail(rs.getString("email"));
				seller.setBirthDate(
						LocalDateTime.parse(rs.getString("birthdate"), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
				seller.setBaseSalary(rs.getDouble("basesalary"));
				department.setId(rs.getLong("department.id"));
				department.setName(rs.getString("department.name"));
				seller.setDepartment(department);
				listaSeller.add(seller);
			}
			return listaSeller;
		} catch (SQLException error) {
			throw new DBException(error.getMessage());
		} finally {
			Conexao.closeResultSet(rs);
			Conexao.closeStatement(st);
		}
	}

	/** STACK-OVER-FLOW SAVE THE DAY */
	private static java.sql.Date conversorTime(LocalDateTime dt) {
		LocalDate locald = LocalDate.of(dt.getYear(), dt.getMonth(), dt.getDayOfMonth());
		Date date = Date.valueOf(locald);
		return new java.sql.Date(date.getTime());
	}

}
