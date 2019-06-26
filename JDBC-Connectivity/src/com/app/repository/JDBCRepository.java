package com.app.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.app.factory.ConnectionFactory;
import com.app.model.Product;

public class JDBCRepository implements Repository {

	Connection conn = null;

	@Override
	public void save(Product product) {
		try {
			conn = ConnectionFactory.getConnection();

			// String sql = "insert into products(id,name,price,type) values(?,?,?,?)";
			String sql = "insert into products(id,name,price,type) values(product_seq.nextval,?,?,?)";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, product.getName());
			ps.setDouble(2, product.getPrice());
			ps.setString(3, product.getType());

			int count = ps.executeUpdate();
			System.out.println(count + " record added successfully");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Optional<Product> findById(int id) {
		// Optional<Product> optional;
		Product product = new Product();
		try {
			conn = ConnectionFactory.getConnection();

			// String sql = "insert into products(id,name,price,type) values(?,?,?,?)";
			String sql = "select*from products where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getDouble("price"));
				product.setType(rs.getString("type"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return Optional.ofNullable(product);
	}

	@Override
	public void delete(int id) {
		try {
			conn = ConnectionFactory.getConnection();

			String sql = "delete from products where id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int count = ps.executeUpdate();

			System.out.println(count + " record deleted successfully");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(int id, double price) {
		try {
			conn = ConnectionFactory.getConnection();

			String sql = "update products set price=? where id =?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, price);
			ps.setInt(2, id);
			int count = ps.executeUpdate();

			System.out.println(count + " record updated successfully");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Product> findAll() {
		List<Product> li = new ArrayList<>();
		try {
			conn = ConnectionFactory.getConnection();

			String sql = "select*from products";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Product product =  new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getDouble("price"));
				product.setType(rs.getString("type"));
				
				li.add(product);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return li;
	}
   
	public List<Product> test() {
		List<Product> li = new ArrayList<>();
		try {
			conn = ConnectionFactory.getConnection();
            String table = "products";
			String sql = "select*from "+table;
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Product product =  new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getDouble("price"));
				product.setType(rs.getString("type"));
				
				li.add(product);
			}


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return li;
	}
}
